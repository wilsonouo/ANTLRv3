grammar myCompiler;

options {
  language = Java;
}

@header {
    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.lang.*;
}

@members {
    boolean TRACEON = true;
    
    HashMap<String,Info> symtab = new HashMap<String,Info>();
    
    public enum TypeInfo {
	Integer,
	Const_int,
	Float,
	Const_float,
	Char,
	Literal,
	Bool,
	Error,
    }
    
    class tVar {
	   int   varIndex; // temporary variable's index. Ex: t1, t2, ..., etc.
	   int   iValue;   // value of constant integer. Ex: 123.
	   float ftValue;
	   String fValue;   // value of constant floating point. Ex: 2.314.
	   String strIndex;
	   String strType;  // value of string. Ex: "dsd".
	   
	   tVar(){
	       strIndex = new String();
	       strType = new String();
	       fValue = new String();
	   }
   };

    class Info {
       TypeInfo theType;  // type information.
       tVar theVar;
	   
       Info() {
          theType = TypeInfo.Error;
          theVar = new tVar();
       }
       
    };
    
    
    // labelCount is used to represent temporary label.
    // The first index is 0.
    int labelCount = 0;
	
    // varCount is used to represent temporary variables.
    // The first index is 0.
    int varCount = 0;
    
    // temporary str
    // start with null EX: @.str
    int strCount = 0;

    // Record all assembly instructions.
    List<String> TextCode = new ArrayList<String>();
    
    // Record str info
    List<String> StrTextCode = new ArrayList<String>();


    /*
     * Output prologue.
     */
    void prologue()
    {
       TextCode.add("; === prologue ====");
       TextCode.add("declare dso_local i32 @printf(i8*, ...)");
       TextCode.add("define dso_local i32 @main()");
       TextCode.add("{");
    }
    
	
    /*
     * Output epilogue.
     */
    void epilogue()
    {
       /* handle epilogue */
       TextCode.add("\n; === epilogue ===");
       TextCode.add("ret i32 0");
       TextCode.add("}");
    }
    
    
    /* Generate a new label */
    String newLabel()
    {
       labelCount++;
       return (new String("L")) + Integer.toString(labelCount);
    } 
    
    public List<String> getStrTextCode()
    {
       return StrTextCode;
    }
    
    public List<String> getTextCode()
    {
       return TextCode;
    }
    
}

program:INT_TYPE MAIN '(' ')' 
        {
           /* Output function prologue */
           prologue();
        }
        '{' declarations statements '}' 
        {
            if (TRACEON) System.out.println("INT_TYPE MAIN () {declarations statements}");
            epilogue();
        }
        ;

declarations:type IDENTIFIER ';' declarations
             { 
               if (TRACEON)
                  System.out.println("declarations: type Identifier : declarations");
                  
               if (symtab.containsKey($IDENTIFIER.text)) { 
                   // variable re-declared.
                   System.out.println("Error! " + $IDENTIFIER.getLine() + ": Redeclared identifier.");
                   //System.exit(0);
               }
               
               
               /* Add ID and its info into the symbol table. */
	       Info the_entry = new Info();
	       the_entry.theType = $type.attr_type;
	       the_entry.theVar.varIndex = varCount;
	       varCount ++;
	       symtab.put($IDENTIFIER.text, the_entry);

               // issue the instruction.
	       // Ex: \%a = alloca i32, align 4, (Integer)
               if ($type.attr_type == TypeInfo.Integer) { 
                  TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
               }
               // Ex: \%a = alloca float, align 4, (Float)
               else if ($type.attr_type == TypeInfo.Float) { 
                  TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca float, align 4");
               }
               // Ex: \%a = alloca i8, align 1, (Char)
               else if ($type.attr_type == TypeInfo.Char) { 
                  TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i8, align 1");
               }
               
             }
           |
           {
               if (TRACEON)
                  System.out.println("declarations: ");
           } 
           ;

type returns [TypeInfo attr_type]
   : INT_TYPE { $attr_type = TypeInfo.Integer; }
   | FLOAT_TYPE { $attr_type = TypeInfo.Float; }
   | CHAR_TYPE { $attr_type = TypeInfo.Char; }
   ;

statements:statement statements
          |
          ;



statement: if_statements 
         | while_stmt
         | for_stmt
         | assign_statements ';'
         | func_no_return_stmt ';'     
         ;
         
for_stmt
@init {String out_for_label = new String();
String for_determine = new String();
String for_body = new String();
String for_assign = new String(); }
        :FOR '(' 
        assign_statements
        {
            for_determine = newLabel();
            TextCode.add("br label \%" + for_determine);
            TextCode.add(for_determine + ":");
        }
        ';'
        condition
        {
            // parser check
            if($condition.theInfo.theType != TypeInfo.Bool) {
                System.out.println("Error! " + $FOR.getLine() + ": The expecting type: bool.");
            }
                          
            for_body = newLabel();
            for_assign = newLabel();
            out_for_label = newLabel();
            TextCode.add("br i1 \%t" + $condition.theInfo.theVar.varIndex + ", label \%" + for_body + ", label \%" + out_for_label);
            TextCode.add(for_assign + ":");
        }
        ';'
        assign_statements
        {
            TextCode.add("br label \%" + for_determine);
            TextCode.add(for_body + ":");
        }
        ')'
        then_statements
        {
            TextCode.add("br label \%" + for_assign);
            TextCode.add(out_for_label + ":");
        }
        ;

while_stmt
@init {String out_while_label = new String();
String while_determine = new String(); }
          :WHILE
          {
              while_determine = newLabel();
              TextCode.add("br label \%" + while_determine);
              TextCode.add(while_determine + ":");
          }
          '('
          condition
          {
              // parser check
              if($condition.theInfo.theType != TypeInfo.Bool) {
                  System.out.println("Error! " + $WHILE.getLine() + ": The expecting type: bool.");
              }
                          
              String while_body = new String();
              while_body = newLabel();
              out_while_label = newLabel();
              TextCode.add("br i1 \%t" + $condition.theInfo.theVar.varIndex + ", label \%" + while_body + ", label \%" + out_while_label);
              TextCode.add(while_body + ":");
          }
          ')'
          then_statements
          {
              TextCode.add("br label \%" + while_determine);
              TextCode.add(out_while_label + ":");
          }
          ;
         
// done

if_statements
@init { String label_if = new String(); }
             :if_then_statements
             {
                 label_if = $if_then_statements.else_label;
             }
             if_else_statements[label_if]
             ;
             
if_then_statements
returns [String else_label]
@init {else_label = new String();}
                  :IF '(' condition
                  {
                      // parser check
                      if($condition.theInfo.theType != TypeInfo.Bool) {
                          System.out.println("Error! " + $IF.getLine() + ": The expecting type: bool.");
                      }
                      String true_stmt = new String();
                      true_stmt = newLabel();
                      String false_stmt = new String();
                      else_label = newLabel();
                      TextCode.add("br i1 \%t" + $condition.theInfo.theVar.varIndex + ", label \%" + true_stmt + ", label \%" + else_label);
                      TextCode.add(true_stmt + ":");
                     
                  }
                  ')' then_statements
                  ;
// done
if_else_statements[String else_stmt]
@init {String jump_label = new String();}
                  :ELSE
                  {
                      jump_label = newLabel();
                      TextCode.add("br label \%" + jump_label);
                      TextCode.add(else_stmt + ":");
                      
                  }
                  then_statements
                  {
                      TextCode.add("br label \%" + jump_label);
                      TextCode.add(jump_label + ":");
                      
                  }
                  |
                  {
                      TextCode.add("br label \%" + else_stmt);
                      TextCode.add(else_stmt + ":");
                  }
                  ;


// done
condition
returns [Info theInfo]
@init {theInfo = new Info();}
         : a = arith_expression { theInfo = $a.theInfo; }
         (compare b = arith_expression)*
         {
             if($b.theInfo == null) {
                 $theInfo.theType = TypeInfo.Error;
                 //System.exit(0);
             }
             
             
             String CMPcode = new String();
             String Liden = new String();
             
             // code generate
             if($a.theInfo.theType == TypeInfo.Integer){
             
                 CMPcode = "icmp ";
             
                 switch($compare.text){
                 case "<":
                     CMPcode += "slt";
                     break;
                 case ">":
                     CMPcode += "sgt";
                     break;
                 case "==":
                     CMPcode += "eq";
                     break;
                 case ">=":
                     CMPcode += "sge";
                     break;
                 case "<=":
                     CMPcode += "sle";
                     break;
                 case "!=":
                     CMPcode += "ne";
                     break;
                 default: 
                 }
                 
                 Liden = " i32 \%t" + String.valueOf($a.theInfo.theVar.varIndex) + ", ";
                 if($b.theInfo.theType == TypeInfo.Integer) {
                     Liden += "\%t" + String.valueOf($b.theInfo.theVar.varIndex);
                 }
                 else if($b.theInfo.theType == TypeInfo.Const_int) {
                     Liden += String.valueOf($b.theInfo.theVar.iValue);
                 }
                 
             }
             else if($a.theInfo.theType == TypeInfo.Float){
             
                 CMPcode = "fcmp ";
             
                 switch($compare.text){
                 case "<":
                     CMPcode += "olt";
                     break;
                 case ">":
                     CMPcode += "ogt";
                     break;
                 case "==":
                     CMPcode += "oeq";
                     break;
                 case ">=":
                     CMPcode += "oge";
                     break;
                 case "<=":
                     CMPcode += "ole";
                     break;
                 case "!=":
                     CMPcode += "une";
                     break;
                 default: 
                 }
                 
                 
                 if($b.theInfo.theType == TypeInfo.Float) {
                     Liden = " float \%t" + String.valueOf($a.theInfo.theVar.varIndex) + ", ";
                     Liden += "\%t" + String.valueOf($b.theInfo.theVar.varIndex);
                 }
                 else if($b.theInfo.theType == TypeInfo.Const_float) {
                     int convert2double = varCount;
                     TextCode.add("\%t" + convert2double + " = " + "fpext float \%t" + $a.theInfo.theVar.varIndex + " to double");
                     varCount++;
                     Liden = " double \%t" + String.valueOf(convert2double) + ", ";
                     Liden += $b.theInfo.theVar.fValue;
                 }
             }
             
             
             TextCode.add("\%t" + varCount + " = " + CMPcode + Liden);
             
             
             // set info
             theInfo.theType = TypeInfo.Bool;
             theInfo.theVar.varIndex = varCount;
             varCount++;
             
         }
         ;

//done
compare: EQ_OP 
       | LE_OP
       | GE_OP
       | NE_OP
       | LOGICAL_AND
       | LOGICAL_OR
       | GT_OP
       | LT_OP
       ;

// done
assign_statements: IDENTIFIER assign arith_expression
                 {
                     // check whether the identifier declare 
                     if (!symtab.containsKey($IDENTIFIER.text)) {  System.out.println("Error! " + $IDENTIFIER.getLine() + ":  The identifier hadn't declared yet."); }
                     
                     // code 
                     Info theRHS = $arith_expression.theInfo;
                     Info theLHS = symtab.get($IDENTIFIER.text); 
		      
		      // int
                     if ((theLHS.theType == TypeInfo.Integer) && (theRHS.theType == TypeInfo.Integer)) {		   
                         // issue store insruction.
                         // Ex: store i32 \%tx, i32* \%ty, align 4
                         TextCode.add("store i32 \%t" + theRHS.theVar.varIndex + ", i32* \%t" + theLHS.theVar.varIndex + ", align 4");
                     } 
                     else if ((theLHS.theType == TypeInfo.Integer) && (theRHS.theType == TypeInfo.Const_int)) {
                         // issue store insruction.
                         // Ex: store i32 value, i32* \%ty, align 4
                         TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* \%t" + theLHS.theVar.varIndex + ", align 4");				
                     }
                     // float
                     else if ((theLHS.theType == TypeInfo.Float) && (theRHS.theType == TypeInfo.Float)) {		   
                         // issue store insruction.
                         // Ex: store i32 \%tx, i32* \%ty, align 4
                         TextCode.add("store float \%t" + theRHS.theVar.varIndex + ", float* \%t" + theLHS.theVar.varIndex + ", align 4");
                     } 
                     else if ((theLHS.theType == TypeInfo.Float) && (theRHS.theType == TypeInfo.Const_float)) {
                         // issue store insruction.
                         // Ex: store i32 value, i32* \%ty
                         TextCode.add("store float " + theRHS.theVar.fValue + ", float* \%t" + theLHS.theVar.varIndex + ", align 4");				
                     }  
                     // type error   
                     else{
                         System.out.println("Error! " + $IDENTIFIER.getLine() + ": Expecting the same type of the assign!");
                     }      
    		
                 }
                 ;


assign: ADD_ASSIGN
      | SUB_ASSIGN
      | MUL_ASSIGN
      | DIV_ASSIGN
      | MOD_ASSIGN
      | '='
      ;


       
//done
then_statements:'{' statements '}'
               ;

// done
func_no_return_stmt: IDENTIFIER '(' argument ')'
                   {
                       TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @printf(" + $argument.argValue + ")");
                       varCount++;
                   }
                   ;

// done
argument
returns [String argValue]
@init { argValue = new String(); }
        : a = arg 
        {
            argValue = "i8* getelementptr inbounds (" + $a.theInfo.theVar.strType + ", " + $a.theInfo.theVar.strType + "* " + $a.theInfo.theVar.strIndex + ", i64 0, i64 0)";
        }
        (',' b = arg
        {
            switch($b.theInfo.theType) {
                case Integer:
                    argValue +=  ", i32 \%t" + $b.theInfo.theVar.varIndex;
                    break;
                case Float:
                    int floatConvert = varCount;
                    varCount++;
                    TextCode.add("\%t" + floatConvert + " = fpext float \%t" + $b.theInfo.theVar.varIndex + " to double");
                    argValue += ", double \%t" + floatConvert;
                    break;
                default:
            }
        }
        )*
        ;

// done
arg
returns [Info theInfo]
@init {theInfo = new Info();}
   : arith_expression
   {
       $theInfo = $arith_expression.theInfo;
   }
   | LITERAL
   {
       $theInfo.theType = TypeInfo.Literal;
       String tempStr = new String();
       
       // strIndex
       tempStr = "@.str" + String.valueOf(strCount);
       strCount++;
       $theInfo.theVar.strIndex = tempStr;
       
       tempStr += " = private unnamed_addr constant ";
       
       // input str generate
       String s = new String($LITERAL.text);
       s = s.replace("\"", "");
       int sTemplength = s.length();
       s = s.replace("\\n", "\\0A");
       int slength = sTemplength - (s.length() - sTemplength) + 1;
       s = "\"" + s + "\\00\"";
       // end of input str generate
       
       // String type
       String tempStrType = new String();
       tempStrType = "[" + String.valueOf(slength) + " x i8]";
       $theInfo.theVar.strType = tempStrType;
       
       tempStr += tempStrType + " c" + s + ", align 1";
       StrTextCode.add(tempStr);
   }
   ;
   
   
// done
arith_expression 
returns [Info theInfo]
@init {theInfo = new Info();}
	: a = multExpr { $theInfo = $a.theInfo; }
	( '+' b = multExpr 
	    { 
	        
	        // code generate
	        if (($a.theInfo.theType == TypeInfo.Integer) && ($b.theInfo.theType == TypeInfo.Integer)) {
                    TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
                    // Update arith_expression's theInfo.
                    $theInfo.theType = TypeInfo.Integer;
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                } 
                else if (($a.theInfo.theType == TypeInfo.Integer) && ($b.theInfo.theType == TypeInfo.Const_int)) {
                    TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
					   
                    // Update arith_expression's theInfo.
                    $theInfo.theType = TypeInfo.Integer;
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                }
                else if (($a.theInfo.theType == TypeInfo.Const_int) && ($b.theInfo.theType == TypeInfo.Const_int)) {
			   
                    $theInfo.theType = TypeInfo.Const_int;
                    $theInfo.theVar.iValue = a.theVar.iValue + b.theVar.iValue;
                    
                }
                else if(($a.theInfo.theType == TypeInfo.Float) && ($b.theInfo.theType == TypeInfo.Float)) {
                    TextCode.add("\%t" + varCount + " = fadd float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
                    // Update arith_expression's theInfo.
                    $theInfo.theType = TypeInfo.Float;
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                }
                // float const 
                else if(($a.theInfo.theType == TypeInfo.Float) && ($b.theInfo.theType == TypeInfo.Const_float)) {
                           
                    // turn float to double
                    // Ex: \%a = fpext float \%b to double
                    int changToDouble = varCount;
                    TextCode.add("\%t" + changToDouble + " = fpext float \%t" + $theInfo.theVar.varIndex + " to double");
                    varCount++;
                           
                    // add
                    int doublediv = varCount;
                    TextCode.add("\%t" + doublediv + " = fadd double \%t" + changToDouble + ", " + $b.theInfo.theVar.fValue);
                    varCount++;
                           
                    // convert to float
                    // EX: \%a = fptrunc double \%b to float
                    TextCode.add("\%t" + varCount + " = fptrunc double \%t" + doublediv + "to float");
                           
                    // Update arith_expression's theInfo.
                    $theInfo.theType = TypeInfo.Float;
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                }
                else if(($a.theInfo.theType == TypeInfo.Const_float) && ($b.theInfo.theType == TypeInfo.Const_float)){
                    $theInfo.theType = TypeInfo.Const_float;
                    float floatconst = a.theVar.ftValue + b.theVar.ftValue;
                    double doubleConst = floatconst;
                    $theInfo.theVar.ftValue = floatconst;
                    long d2hex = Double.doubleToLongBits(doubleConst);
                    $theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
                }
                // type check
                else{
                    $theInfo.theType = TypeInfo.Error;
                    //System.exit(0);
                }
            }
	| '-' c = multExpr 
	    {
	        
	        // code generate
	        if (($a.theInfo.theType == TypeInfo.Integer) && ($c.theInfo.theType == TypeInfo.Integer)) {
                    TextCode.add("\%t" + varCount + " = sub nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
					   
                    // Update arith_expression's theInfo.
                    $theInfo.theType = TypeInfo.Integer;
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                } 
                else if (($a.theInfo.theType == TypeInfo.Integer) && ($c.theInfo.theType == TypeInfo.Const_int)) {
                    TextCode.add("\%t" + varCount + " = sub nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $c.theInfo.theVar.iValue);
					   
                    // Update arith_expression's theInfo.
                    $theInfo.theType = TypeInfo.Integer;
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                }
                else if (($a.theInfo.theType == TypeInfo.Const_int) && ($c.theInfo.theType == TypeInfo.Const_int)) {
			   
                    $theInfo.theType = TypeInfo.Const_int;
                    $theInfo.theVar.iValue = a.theVar.iValue - c.theVar.iValue;
                    
                }
                else if(($a.theInfo.theType == TypeInfo.Float) && ($c.theInfo.theType == TypeInfo.Float)) {
                    TextCode.add("\%t" + varCount + " = fsub float \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
					   
                    // Update arith_expression's theInfo.
                    $theInfo.theType = TypeInfo.Float;
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                }
                // float const 
                else if(($a.theInfo.theType == TypeInfo.Float) && ($b.theInfo.theType == TypeInfo.Const_float)) {
                    // turn float to double
                    // Ex: \%a = fpext float \%b to double
                    int changToDouble = varCount;
                    TextCode.add("\%t" + changToDouble + " = fpext float \%t" + $theInfo.theVar.varIndex + " to double");
                    varCount++;
                           
                    // div
                    int doublediv = varCount;
                    TextCode.add("\%t" + doublediv + " = fsub double \%t" + changToDouble + ", " + $c.theInfo.theVar.fValue);
                    varCount++;
                           
                    // convert to float
                    // EX: \%a = fptrunc double \%b to float
                    TextCode.add("\%t" + varCount + " = fptrunc double \%t" + doublediv + "to float");
                           
                    // Update arith_expression's theInfo.
                    $theInfo.theType = TypeInfo.Float;
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                }
                else if(($a.theInfo.theType == TypeInfo.Const_float) && ($c.theInfo.theType == TypeInfo.Const_float)){
                    $theInfo.theType = TypeInfo.Const_float;
                    float floatconst = a.theVar.ftValue - c.theVar.ftValue;
                    double doubleConst = floatconst;
                    $theInfo.theVar.ftValue = floatconst;
                    long d2hex = Double.doubleToLongBits(doubleConst);
                    $theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
                }
                // type check
                else{
                    $theInfo.theType = TypeInfo.Error;
                    //System.exit(0);
                }
            }
	)* 
        ;


// done
multExpr 
returns [Info theInfo]
@init {theInfo = new Info();}
	: a = signExpr { $theInfo=$a.theInfo; }
	( '*' b = signExpr 
              {
			
			 // code generate
			 if (($a.theInfo.theType == TypeInfo.Integer) && ($b.theInfo.theType == TypeInfo.Integer)) {
                            TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
                            // Update arith_expression's theInfo.
                            $theInfo.theType = TypeInfo.Integer;
                            $theInfo.theVar.varIndex = varCount;
                            varCount++;
                        } 
                        else if (($a.theInfo.theType == TypeInfo.Integer) && ($b.theInfo.theType == TypeInfo.Const_int)) {
                           TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
					   
                           // Update arith_expression's theInfo.
                           $theInfo.theType = TypeInfo.Integer;
                           $theInfo.theVar.varIndex = varCount;
                           varCount++;
                        }
                        else if (($a.theInfo.theType == TypeInfo.Const_int) && ($b.theInfo.theType == TypeInfo.Const_int)) {
			   
                           $theInfo.theType = TypeInfo.Const_int;
                           $theInfo.theVar.iValue = a.theVar.iValue * b.theVar.iValue;
                    
                        }
                        else if(($a.theInfo.theType == TypeInfo.Float) && ($b.theInfo.theType == TypeInfo.Float)) {
                           TextCode.add("\%t" + varCount + " = fmul float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
                           // Update arith_expression's theInfo.
                           $theInfo.theType = TypeInfo.Float;
                           $theInfo.theVar.varIndex = varCount;
                           varCount++;
                        }
                        // float const 
                        else if(($a.theInfo.theType == TypeInfo.Float) && ($b.theInfo.theType == TypeInfo.Const_float)) {
                           // turn float to double
                           // Ex: \%a = fpext float \%b to double
                           int changToDouble = varCount;
                           TextCode.add("\%t" + changToDouble + " = fpext float \%t" + $theInfo.theVar.varIndex + " to double");
                           varCount++;
                           
                           // mul
                           int doublediv = varCount;
                           TextCode.add("\%t" + doublediv + " = fmul double \%t" + changToDouble + ", " + $b.theInfo.theVar.fValue);
                           varCount++;
                           
                           // convert to float
                           // EX: \%a = fptrunc double \%b to float
                           TextCode.add("\%t" + varCount + " = fptrunc double \%t" + doublediv + "to float");
                           
                           // Update arith_expression's theInfo.
                           $theInfo.theType = TypeInfo.Float;
                           $theInfo.theVar.varIndex = varCount;
                           varCount++;
                        }
                        else if(($a.theInfo.theType == TypeInfo.Const_float) && ($b.theInfo.theType == TypeInfo.Const_float)){
                           $theInfo.theType = TypeInfo.Const_float;
                           float floatconst = a.theVar.ftValue * b.theVar.ftValue;
                           double doubleConst = floatconst;
                           $theInfo.theVar.ftValue = floatconst;
                           long d2hex = Double.doubleToLongBits(doubleConst);
                           $theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
                         }
                        // type check
                        else{
                           $theInfo.theType = TypeInfo.Error;
                           //System.exit(0);
                        }
             }
	| '/' c = signExpr 
             {
                 
			 // code generate
			 if (($a.theInfo.theType == TypeInfo.Integer) && ($c.theInfo.theType == TypeInfo.Integer)) {
                            TextCode.add("\%t" + varCount + " = sdiv nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
					   
                            // Update arith_expression's theInfo.
                            $theInfo.theType = TypeInfo.Integer;
                            $theInfo.theVar.varIndex = varCount;
                            varCount++;
                        } 
                        else if (($a.theInfo.theType == TypeInfo.Integer) && ($c.theInfo.theType == TypeInfo.Const_int)) {
                           TextCode.add("\%t" + varCount + " = sdiv nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $c.theInfo.theVar.iValue);
					   
                           // Update arith_expression's theInfo.
                           $theInfo.theType = TypeInfo.Integer;
                           $theInfo.theVar.varIndex = varCount;
                           varCount++;
                        }
                        else if (($a.theInfo.theType == TypeInfo.Const_int) && ($c.theInfo.theType == TypeInfo.Const_int)) {
			   
                           $theInfo.theType = TypeInfo.Const_int;
                           $theInfo.theVar.iValue = a.theVar.iValue / c.theVar.iValue;
                    
                        }
                        else if(($a.theInfo.theType == TypeInfo.Float) && ($c.theInfo.theType == TypeInfo.Float)) {
                           TextCode.add("\%t" + varCount + " = fdiv float \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
					   
                           // Update arith_expression's theInfo.
                           $theInfo.theType = TypeInfo.Float;
                           $theInfo.theVar.varIndex = varCount;
                           varCount++;
                        }
                        // float const 
                        else if(($a.theInfo.theType == TypeInfo.Float) && ($c.theInfo.theType == TypeInfo.Const_float)) {
                           // turn float to double
                           // Ex: \%a = fpext float \%b to double
                           int changToDouble = varCount;
                           TextCode.add("\%t" + changToDouble + " = fpext float \%t" + $theInfo.theVar.varIndex + " to double");
                           varCount++;
                           
                           // div
                           int doublediv = varCount;
                           TextCode.add("\%t" + doublediv + " = fdiv double \%t" + changToDouble + ", " + $c.theInfo.theVar.fValue);
                           varCount++;
                           
                           // convert to float
                           // EX: \%a = fptrunc double \%b to float
                           TextCode.add("\%t" + varCount + " = fptrunc double \%t" + doublediv + "to float");
                           
                           // Update arith_expression's theInfo.
                           $theInfo.theType = TypeInfo.Float;
                           $theInfo.theVar.varIndex = varCount;
                           varCount++;
                        }
                        else if(($a.theInfo.theType == TypeInfo.Const_float) && ($c.theInfo.theType == TypeInfo.Const_float)){
                           $theInfo.theType = TypeInfo.Const_float;
                           float floatconst = a.theVar.ftValue / c.theVar.ftValue;
                           double doubleConst = floatconst;
                           $theInfo.theVar.ftValue = floatconst;
                           long d2hex = Double.doubleToLongBits(doubleConst);
                           $theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
                         }
                        // type check
                        else{
                           $theInfo.theType = TypeInfo.Error;
                           //System.exit(0);
                        }
             }
	)*
	;

// done
signExpr
returns [Info theInfo]
@init {theInfo = new Info();}
	: a = primaryExpr { $theInfo=$a.theInfo; }
	| '-' b = primaryExpr { $theInfo=$b.theInfo; }
	; 
	
	
// done	  
primaryExpr 
returns [Info theInfo]
@init {theInfo = new Info();}
	: DEC_NUM
	{
	    $theInfo.theType = TypeInfo.Const_int;
	    $theInfo.theVar.iValue = Integer.parseInt($DEC_NUM.text);
	}  
	| FLOAT_NUM
	{
	    $theInfo.theType = TypeInfo.Const_float;
	    float floatconst = Float.parseFloat($FLOAT_NUM.text);
	    double doubleConst = floatconst;
            $theInfo.theVar.ftValue = floatconst;
            long d2hex = Double.doubleToLongBits(doubleConst);
            $theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
	    
	}
	| IDENTIFIER 
        {
            // check whether the identifier exist 
            if (symtab.containsKey($IDENTIFIER.text)) {
            
                // get type information from symtab.
                TypeInfo the_type = symtab.get($IDENTIFIER.text).theType;
                $theInfo.theType = the_type;
                
                // get variable index from symtab.
                int vIndex = symtab.get($IDENTIFIER.text).theVar.varIndex;
                
                switch(the_type) {
                case Integer:
                    // get a new temporaty variable and load the variable into the temporary variable.
                    // Ex: \%tx = load i32, i32* \%ty, align 4.
                    TextCode.add("\%t" + varCount + " = load i32, i32* \%t" + vIndex + ", align 4");
				         
                    // Now, Identifier's value is at the temporary variable \%t[varCount]. Therefore, update it.
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                    break;
                case Float:
                    // Ex: \%tx = load float, float* \%ty, align 4.
                    TextCode.add("\%t" + varCount + " = load float, float* \%t" + vIndex + ", align 4");
				         
                    // Now, Identifier's value is at the temporary variable \%t[varCount]. Therefore, update it.
                    $theInfo.theVar.varIndex = varCount;
                    varCount++;
                    break;
                case Char:
                    break;
                }
			
            } 
            else { System.out.println("Error! " + $IDENTIFIER.getLine() + ": The identifier hadn't declared yet."); }
            
        }
        | '(' arith_expression ')' { $theInfo = $arith_expression.theInfo; }
	;
   




/*----------------------*/
/*   Reserved Keywords  */
/*----------------------*/
INT_TYPE  : 'int';
CHAR_TYPE : 'char';
VOID_TYPE : 'void';
FLOAT_TYPE: 'float';
BOOL_TYPE : 'bool';
DO        : 'do';
WHILE     : 'while';
FOR       : 'for';
IF        : 'if';
ELSE      : 'else';
CONST     : 'const';
MAIN      : 'main';
RETURN    : 'return';
SWITCH    : 'switch';
CASE      : 'case';
BREAK     : 'break';
CONTINUE  : 'continue';
TRUE      : 'true';
FALSE     : 'false';
INCLUDE   : 'include';
DEFINE    : 'define';


/*----------------------*/
/*      Operators       */
/*----------------------*/
BRACKET_R : ')';
BRACKET_L : '(';
COLON     : ':';
COMMA     : ',';
SEMICOLON : ';';
BEACE_L   : '{';
BEACE_R   : '}';
SQUARE_BRACKET_R : ']';
SQUARE_BRACKET_L : '[';
DOT       : '.';
ASSIGN    : '=';
PLUS      : '+';
MINUS     : '-';
MULTIPLE  : '*';
DIVIDED   : '/';
MOD       : '%';
GT_OP     : '>';
LT_OP     : '<';
NOT       : '!';
BITWISE_AND   : '&';
BITWISE_OR    : '|';



/*----------------------*/
/*  Compound Operators  */
/*----------------------*/
ADD_ASSIGN    : '+=';
SUB_ASSIGN    : '-=';
MUL_ASSIGN    : '*=';
DIV_ASSIGN    : '/=';
MOD_ASSIGN    : '%=';
EQ_OP : '==';
LE_OP : '<=';
GE_OP : '>=';
NE_OP : '!=';
PP_OP : '++';
MM_OP : '--'; 
RSHIFT_OP : '<<';
LSHIFT_OP : '>>';
LOGICAL_AND   : '&&';
LOGICAL_OR    : '||';


DEC_NUM : ('0' | ('1'..'9')(DIGIT)*);

IDENTIFIER : (LETTER)(LETTER | DIGIT)*;

FLOAT_NUM: FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3;
fragment FLOAT_NUM1: (DIGIT)+'.'(DIGIT)*;
fragment FLOAT_NUM2: '.'(DIGIT)+;
fragment FLOAT_NUM3: (DIGIT)+;

LITERAL : '"' (options{greedy=false;}: .)* '"';
 
fragment LETTER : 'a'..'z' | 'A'..'Z' | '_';
fragment DIGIT : '0'..'9';


/* Comments */
COMMENT1 : '//'(.)*'\n' {$channel=HIDDEN;};
COMMENT2 : '/*' (options{greedy=false;}: .)* '*/' {$channel=HIDDEN;};

WS  : (' '|'\r'|'\t'|'\n')+ {$channel=HIDDEN;};

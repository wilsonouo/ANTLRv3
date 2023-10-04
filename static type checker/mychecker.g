grammar mychecker;

options {
  language = Java;
}

@header {
    // import packages here.
    import java.util.HashMap;
}

@members {
    boolean TRACEON = true;
    HashMap<String,TypeInfo> symtab = new HashMap<String,TypeInfo>();
    
    public enum TypeInfo {
	Integer,
	Float,
	Char,
	Bool,
	Unknown,
	No_Exist,
	Error,
	Blank,
	Return
    }
}

program:INT_TYPE MAIN '(' ')' '{' declarations statements '}' 
        {if (TRACEON) System.out.println("INT_TYPE MAIN () {declarations statements}");}
        ;

declarations:type IDENTIFIER (assign_statements)? ';' declarations
             { 
               if (symtab.containsKey($IDENTIFIER.text)) { System.out.println("Error! " + $IDENTIFIER.getLine() + ": Redeclared identifier."); }
               else { symtab.put($IDENTIFIER.text, $type.attr_type); } 
             }
           |
           ;

type returns [TypeInfo attr_type]
   : INT_TYPE { $attr_type = TypeInfo.Integer;}
   | FLOAT_TYPE { $attr_type = TypeInfo.Float;}
   | CHAR_TYPE { $attr_type = TypeInfo.Char;}
   | BOOL_TYPE { $attr_type = TypeInfo.Bool;}
   ;

statements:statement statements
          |
          ;

arith_expression returns [TypeInfo attr_type]
	: a = multExpr { $attr_type = $a.attr_type; }
	( '+' b = multExpr 
		{ 
			if ($a.attr_type != $b.attr_type) { System.out.println("Error! " + $a.start.getLine() + ": Type mismatch for the operator '+' in an expression."); $attr_type = TypeInfo.Error; }
        	}
	| '-' c = multExpr 
		{ 
			if ($a.attr_type != $c.attr_type) { System.out.println("Error! " + $a.start.getLine() + ": Type mismatch for the operator '-' in an expression."); $attr_type = TypeInfo.Error; }
        	}
	)* 
        ;

multExpr returns [TypeInfo attr_type]
	: a = signExpr { $attr_type = $a.attr_type; }
	( '*' b = signExpr 
		{
			if ($a.attr_type != $b.attr_type) { System.out.println("Error! " + $a.start.getLine() + ": Type mismatch for the operator '*' in an expression."); $attr_type = TypeInfo.Error; }
		}
	| '/' c = signExpr 
		{
			if ($a.attr_type != $c.attr_type) { System.out.println("Error! " + $a.start.getLine() + ": Type mismatch for the operator '/' in an expression."); $attr_type = TypeInfo.Error; }
		}
	)*
	;

signExpr returns [TypeInfo attr_type]
	: primaryExpr { $attr_type = $primaryExpr.attr_type; }
	| '-' primaryExpr { $attr_type = $primaryExpr.attr_type; }
	; 
		  
primaryExpr returns [TypeInfo attr_type]
	: num { $attr_type = $num.attr_type; }
	| '(' arith_expression ')' { $attr_type = $arith_expression.attr_type; }
	| IDENTIFIER 
		{
			if (symtab.containsKey($IDENTIFIER.text)) { $attr_type = symtab.get($IDENTIFIER.text);} 
			else { System.out.println("Error! " + $IDENTIFIER.getLine() + ":  The identifier hadn't declared yet."); $attr_type = TypeInfo.Error;  }
	 	}
	;

num returns [TypeInfo attr_type]
   : DEC_NUM { $attr_type = TypeInfo.Integer; }
   | FLOAT_NUM { $attr_type = TypeInfo.Float; }
   ; 
   

statement returns [TypeInfo attr_type]
         : if_else_statements { $attr_type = $if_else_statements.attr_type; }
         | iden { $attr_type = $iden.attr_type; } ';'                   
         | for_loop           { $attr_type = $for_loop.attr_type; } 
         | while_loop         { $attr_type = $while_loop.attr_type; } 
         | return_            { $attr_type = TypeInfo.Return; } 
         ;

if_else_statements returns [TypeInfo attr_type]
                 : IF a = condition
                        {
                        	if($a.attr_type != TypeInfo.Bool) { System.out.println("Error! " + $a.start.getLine() + ": Type mismatch for the if condition,expecting type: bool."); $attr_type = TypeInfo.Error; }
                        }
                    then_statements (ELSE then_statements)?
                  ;

for_loop returns [TypeInfo attr_type]
        : FOR a = condition
          	{
                       if($a.attr_type != TypeInfo.Bool) { System.out.println("Error! " + $a.start.getLine() + ": Type mismatch for the if condition,expecting type: bool."); $attr_type = TypeInfo.Error;}
          	}
          then_statements
        ;

while_loop returns [TypeInfo attr_type]
          : WHILE a = condition 
            	{
                	if($a.attr_type != TypeInfo.Bool) { System.out.println("Error! " + $a.start.getLine() + ": Type mismatch for the while condition,expecting type: bool."); $attr_type = TypeInfo.Error; }
          	}
            then_statements
          ;

condition returns [TypeInfo attr_type]
         : '(' IDENTIFIER 
         	{
         		if (!symtab.containsKey($IDENTIFIER.text)) { $attr_type = TypeInfo.Error; }
		}
         (bool_expression 
         	{
			if(symtab.get($IDENTIFIER.text) != $bool_expression.attr_type && $bool_expression.attr_type != TypeInfo.Error) { System.out.println("Error! " + $IDENTIFIER.getLine() + ": Type mismatch for the bool condition,two side of the operand should be the same type." + symtab.get($IDENTIFIER.text) +" " + $bool_expression.attr_type); $attr_type = TypeInfo.Error;}
	 	}
         | for_condition
         	{
			if(symtab.get($IDENTIFIER.text) != $for_condition.attr_type && $for_condition.attr_type != TypeInfo.Error) { System.out.println("Error! " + $IDENTIFIER.getLine() + ": Type mismatch for the bool condition,two side of the operand should be the same type."); $attr_type = TypeInfo.Error;  }
	 	}
         
         ) 
         ')' { $attr_type = TypeInfo.Bool; }
         | 
         ;

bool_expression returns [TypeInfo attr_type]
               : compare (num { $attr_type = $num.attr_type;}
               | IDENTIFIER
               	{
         			if (!symtab.containsKey($IDENTIFIER.text)) { System.out.println("Error! " + $IDENTIFIER.getLine() + ": The identifier hadn't declared yet."); $attr_type = TypeInfo.Error; }
			}
               ) 
               ;

for_condition returns [TypeInfo attr_type]
             : '=' (DEC_NUM { $attr_type = TypeInfo.Integer; } |FLOAT_NUM { $attr_type = TypeInfo.Float; }) ';' 
             (a = IDENTIFIER
             	{
         		if (!symtab.containsKey($a.text)) { System.out.println("Error! " + $a.getLine() + ":  The identifier hadn't declared yet."); $attr_type = TypeInfo.Error; }
		}
              bool_expression
              	{ 
              		if(symtab.get($a.text) != $bool_expression.attr_type) { System.out.println("Error! " + $a.getLine() + ": Type mismatch for the if condition,two side of the operand should be the same type."); $attr_type = TypeInfo.Error; }
              	}
              )? ';' 
              (b = IDENTIFIER
              	{
              		if (!symtab.containsKey($b.text)) { System.out.println("Error! " + $b.getLine() + ":  The identifier hadn't declared yet."); $attr_type = TypeInfo.Error; }
              	}
              assign_statements
              	{ 
              		if($assign_statements.attr_type == TypeInfo.Blank && (symtab.get($b.text) != TypeInfo.Integer && symtab.get($b.text) != TypeInfo.Float) ) { System.out.println("Error! " + $b.getLine() + ": Type mismatch for the assign statements,before the operand, type should be INT or FLOAT."); $attr_type = TypeInfo.Error;} 
              		else if(symtab.get($b.text) != $assign_statements.attr_type && $assign_statements.attr_type != TypeInfo.Blank) { System.out.println("Error! " + $b.getLine() + ": Type mismatch for the if condition,two side of the operand should be the same type."); $attr_type = TypeInfo.Error; }
              	}
              )? 
             ;

compare: EQ_OP 
       | LE_OP
       | GE_OP
       | NE_OP
       | LOGICAL_AND
       | LOGICAL_OR
       | GT_OP
       | LT_OP
       ;

iden returns [TypeInfo attr_type]
    : IDENTIFIER 
    (assign_statements
    	{
    		if (!symtab.containsKey($IDENTIFIER.text)) {  System.out.println("Error! " + $IDENTIFIER.getLine() + ":  The identifier hadn't declared yet."); $attr_type = TypeInfo.Error; return $attr_type; } 
    		
    		if($assign_statements.attr_type == TypeInfo.Blank && (symtab.get($IDENTIFIER.text) != TypeInfo.Integer && symtab.get($IDENTIFIER.text) != TypeInfo.Float) ) { System.out.println("Error! " + $IDENTIFIER.getLine() + ": Type mismatch for the assign statements,before the operand, type should be INT or FLOAT."); $attr_type = TypeInfo.Error;}  
    		else if($assign_statements.attr_type != TypeInfo.Blank && symtab.get($IDENTIFIER.text) != $assign_statements.attr_type) { System.out.println("Error! " + $IDENTIFIER.getLine() + ": Type mismatch for the if condition,two side of the operand should be the same type."); $attr_type = TypeInfo.Error; }
    	}
    | function_statements) 
    ;

assign_statements returns [TypeInfo attr_type]
                 : assign arith_expression {$attr_type = $arith_expression.attr_type;} 
                 | MM_OP { $attr_type = TypeInfo.Blank; }
                 | PP_OP { $attr_type = TypeInfo.Blank; }
                 ;

assign: ADD_ASSIGN
      | SUB_ASSIGN
      | MUL_ASSIGN
      | DIV_ASSIGN
      | MOD_ASSIGN
      | '='
      ;
       

then_statements: statement
               | '{' statements '}'
               ;
                  
function_statements: '(' parameter_statements ')' {if (TRACEON) System.out.println("function_statements");}
                   ;

parameter_statements: (primaryExpr | LITERAL)? ( ',' primaryExpr | LITERAL)*
                    ;
     
return_: RETURN DEC_NUM ';' 
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

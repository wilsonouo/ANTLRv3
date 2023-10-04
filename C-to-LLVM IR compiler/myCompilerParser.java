// $ANTLR 3.5.3 myCompiler.g 2023-06-15 10:28:12

    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.lang.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCompilerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD_ASSIGN", "ASSIGN", "BEACE_L", 
		"BEACE_R", "BITWISE_AND", "BITWISE_OR", "BOOL_TYPE", "BRACKET_L", "BRACKET_R", 
		"BREAK", "CASE", "CHAR_TYPE", "COLON", "COMMA", "COMMENT1", "COMMENT2", 
		"CONST", "CONTINUE", "DEC_NUM", "DEFINE", "DIGIT", "DIVIDED", "DIV_ASSIGN", 
		"DO", "DOT", "ELSE", "EQ_OP", "FALSE", "FLOAT_NUM", "FLOAT_NUM1", "FLOAT_NUM2", 
		"FLOAT_NUM3", "FLOAT_TYPE", "FOR", "GE_OP", "GT_OP", "IDENTIFIER", "IF", 
		"INCLUDE", "INT_TYPE", "LETTER", "LE_OP", "LITERAL", "LOGICAL_AND", "LOGICAL_OR", 
		"LSHIFT_OP", "LT_OP", "MAIN", "MINUS", "MM_OP", "MOD", "MOD_ASSIGN", "MULTIPLE", 
		"MUL_ASSIGN", "NE_OP", "NOT", "PLUS", "PP_OP", "RETURN", "RSHIFT_OP", 
		"SEMICOLON", "SQUARE_BRACKET_L", "SQUARE_BRACKET_R", "SUB_ASSIGN", "SWITCH", 
		"TRUE", "VOID_TYPE", "WHILE", "WS"
	};
	public static final int EOF=-1;
	public static final int ADD_ASSIGN=4;
	public static final int ASSIGN=5;
	public static final int BEACE_L=6;
	public static final int BEACE_R=7;
	public static final int BITWISE_AND=8;
	public static final int BITWISE_OR=9;
	public static final int BOOL_TYPE=10;
	public static final int BRACKET_L=11;
	public static final int BRACKET_R=12;
	public static final int BREAK=13;
	public static final int CASE=14;
	public static final int CHAR_TYPE=15;
	public static final int COLON=16;
	public static final int COMMA=17;
	public static final int COMMENT1=18;
	public static final int COMMENT2=19;
	public static final int CONST=20;
	public static final int CONTINUE=21;
	public static final int DEC_NUM=22;
	public static final int DEFINE=23;
	public static final int DIGIT=24;
	public static final int DIVIDED=25;
	public static final int DIV_ASSIGN=26;
	public static final int DO=27;
	public static final int DOT=28;
	public static final int ELSE=29;
	public static final int EQ_OP=30;
	public static final int FALSE=31;
	public static final int FLOAT_NUM=32;
	public static final int FLOAT_NUM1=33;
	public static final int FLOAT_NUM2=34;
	public static final int FLOAT_NUM3=35;
	public static final int FLOAT_TYPE=36;
	public static final int FOR=37;
	public static final int GE_OP=38;
	public static final int GT_OP=39;
	public static final int IDENTIFIER=40;
	public static final int IF=41;
	public static final int INCLUDE=42;
	public static final int INT_TYPE=43;
	public static final int LETTER=44;
	public static final int LE_OP=45;
	public static final int LITERAL=46;
	public static final int LOGICAL_AND=47;
	public static final int LOGICAL_OR=48;
	public static final int LSHIFT_OP=49;
	public static final int LT_OP=50;
	public static final int MAIN=51;
	public static final int MINUS=52;
	public static final int MM_OP=53;
	public static final int MOD=54;
	public static final int MOD_ASSIGN=55;
	public static final int MULTIPLE=56;
	public static final int MUL_ASSIGN=57;
	public static final int NE_OP=58;
	public static final int NOT=59;
	public static final int PLUS=60;
	public static final int PP_OP=61;
	public static final int RETURN=62;
	public static final int RSHIFT_OP=63;
	public static final int SEMICOLON=64;
	public static final int SQUARE_BRACKET_L=65;
	public static final int SQUARE_BRACKET_R=66;
	public static final int SUB_ASSIGN=67;
	public static final int SWITCH=68;
	public static final int TRUE=69;
	public static final int VOID_TYPE=70;
	public static final int WHILE=71;
	public static final int WS=72;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public myCompilerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCompilerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return myCompilerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "myCompiler.g"; }


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
	    



	// $ANTLR start "program"
	// myCompiler.g:119:1: program : INT_TYPE MAIN '(' ')' '{' declarations statements '}' ;
	public final void program() throws RecognitionException {
		try {
			// myCompiler.g:119:8: ( INT_TYPE MAIN '(' ')' '{' declarations statements '}' )
			// myCompiler.g:119:9: INT_TYPE MAIN '(' ')' '{' declarations statements '}'
			{
			match(input,INT_TYPE,FOLLOW_INT_TYPE_in_program34); 
			match(input,MAIN,FOLLOW_MAIN_in_program36); 
			match(input,BRACKET_L,FOLLOW_BRACKET_L_in_program38); 
			match(input,BRACKET_R,FOLLOW_BRACKET_R_in_program40); 

			           /* Output function prologue */
			           prologue();
			        
			match(input,BEACE_L,FOLLOW_BEACE_L_in_program61); 
			pushFollow(FOLLOW_declarations_in_program63);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_statements_in_program65);
			statements();
			state._fsp--;

			match(input,BEACE_R,FOLLOW_BEACE_R_in_program67); 

			            if (TRACEON) System.out.println("INT_TYPE MAIN () {declarations statements}");
			            epilogue();
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "declarations"
	// myCompiler.g:131:1: declarations : ( type IDENTIFIER ';' declarations |);
	public final void declarations() throws RecognitionException {
		Token IDENTIFIER1=null;
		TypeInfo type2 =null;

		try {
			// myCompiler.g:131:13: ( type IDENTIFIER ';' declarations |)
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==CHAR_TYPE||LA1_0==FLOAT_TYPE||LA1_0==INT_TYPE) ) {
				alt1=1;
			}
			else if ( (LA1_0==BEACE_R||LA1_0==FOR||(LA1_0 >= IDENTIFIER && LA1_0 <= IF)||LA1_0==WHILE) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// myCompiler.g:131:14: type IDENTIFIER ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations93);
					type2=type();
					state._fsp--;

					IDENTIFIER1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declarations95); 
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations97); 
					pushFollow(FOLLOW_declarations_in_declarations99);
					declarations();
					state._fsp--;

					 
					               if (TRACEON)
					                  System.out.println("declarations: type Identifier : declarations");
					                  
					               if (symtab.containsKey((IDENTIFIER1!=null?IDENTIFIER1.getText():null))) { 
					                   // variable re-declared.
					                   System.out.println("Error! " + IDENTIFIER1.getLine() + ": Redeclared identifier.");
					                   //System.exit(0);
					               }
					               
					               
					               /* Add ID and its info into the symbol table. */
						       Info the_entry = new Info();
						       the_entry.theType = type2;
						       the_entry.theVar.varIndex = varCount;
						       varCount ++;
						       symtab.put((IDENTIFIER1!=null?IDENTIFIER1.getText():null), the_entry);

					               // issue the instruction.
						       // Ex: %a = alloca i32, align 4, (Integer)
					               if (type2 == TypeInfo.Integer) { 
					                  TextCode.add("%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
					               }
					               // Ex: %a = alloca float, align 4, (Float)
					               else if (type2 == TypeInfo.Float) { 
					                  TextCode.add("%t" + the_entry.theVar.varIndex + " = alloca float, align 4");
					               }
					               // Ex: %a = alloca i8, align 1, (Char)
					               else if (type2 == TypeInfo.Char) { 
					                  TextCode.add("%t" + the_entry.theVar.varIndex + " = alloca i8, align 1");
					               }
					               
					             
					}
					break;
				case 2 :
					// myCompiler.g:166:12: 
					{

					               if (TRACEON)
					                  System.out.println("declarations: ");
					           
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "type"
	// myCompiler.g:172:1: type returns [TypeInfo attr_type] : ( INT_TYPE | FLOAT_TYPE | CHAR_TYPE );
	public final TypeInfo type() throws RecognitionException {
		TypeInfo attr_type = null;


		try {
			// myCompiler.g:173:4: ( INT_TYPE | FLOAT_TYPE | CHAR_TYPE )
			int alt2=3;
			switch ( input.LA(1) ) {
			case INT_TYPE:
				{
				alt2=1;
				}
				break;
			case FLOAT_TYPE:
				{
				alt2=2;
				}
				break;
			case CHAR_TYPE:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// myCompiler.g:173:6: INT_TYPE
					{
					match(input,INT_TYPE,FOLLOW_INT_TYPE_in_type168); 
					 attr_type = TypeInfo.Integer; 
					}
					break;
				case 2 :
					// myCompiler.g:174:6: FLOAT_TYPE
					{
					match(input,FLOAT_TYPE,FOLLOW_FLOAT_TYPE_in_type177); 
					 attr_type = TypeInfo.Float; 
					}
					break;
				case 3 :
					// myCompiler.g:175:6: CHAR_TYPE
					{
					match(input,CHAR_TYPE,FOLLOW_CHAR_TYPE_in_type186); 
					 attr_type = TypeInfo.Char; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return attr_type;
	}
	// $ANTLR end "type"



	// $ANTLR start "statements"
	// myCompiler.g:178:1: statements : ( statement statements |);
	public final void statements() throws RecognitionException {
		try {
			// myCompiler.g:178:11: ( statement statements |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==FOR||(LA3_0 >= IDENTIFIER && LA3_0 <= IF)||LA3_0==WHILE) ) {
				alt3=1;
			}
			else if ( (LA3_0==BEACE_R) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// myCompiler.g:178:12: statement statements
					{
					pushFollow(FOLLOW_statement_in_statements198);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statements200);
					statements();
					state._fsp--;

					}
					break;
				case 2 :
					// myCompiler.g:180:11: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statements"



	// $ANTLR start "statement"
	// myCompiler.g:184:1: statement : ( if_statements | while_stmt | for_stmt | assign_statements ';' | func_no_return_stmt ';' );
	public final void statement() throws RecognitionException {
		try {
			// myCompiler.g:184:10: ( if_statements | while_stmt | for_stmt | assign_statements ';' | func_no_return_stmt ';' )
			int alt4=5;
			switch ( input.LA(1) ) {
			case IF:
				{
				alt4=1;
				}
				break;
			case WHILE:
				{
				alt4=2;
				}
				break;
			case FOR:
				{
				alt4=3;
				}
				break;
			case IDENTIFIER:
				{
				int LA4_4 = input.LA(2);
				if ( (LA4_4==BRACKET_L) ) {
					alt4=5;
				}
				else if ( ((LA4_4 >= ADD_ASSIGN && LA4_4 <= ASSIGN)||LA4_4==DIV_ASSIGN||LA4_4==MOD_ASSIGN||LA4_4==MUL_ASSIGN||LA4_4==SUB_ASSIGN) ) {
					alt4=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// myCompiler.g:184:12: if_statements
					{
					pushFollow(FOLLOW_if_statements_in_statement232);
					if_statements();
					state._fsp--;

					}
					break;
				case 2 :
					// myCompiler.g:185:12: while_stmt
					{
					pushFollow(FOLLOW_while_stmt_in_statement246);
					while_stmt();
					state._fsp--;

					}
					break;
				case 3 :
					// myCompiler.g:186:12: for_stmt
					{
					pushFollow(FOLLOW_for_stmt_in_statement259);
					for_stmt();
					state._fsp--;

					}
					break;
				case 4 :
					// myCompiler.g:187:12: assign_statements ';'
					{
					pushFollow(FOLLOW_assign_statements_in_statement272);
					assign_statements();
					state._fsp--;

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement274); 
					}
					break;
				case 5 :
					// myCompiler.g:188:12: func_no_return_stmt ';'
					{
					pushFollow(FOLLOW_func_no_return_stmt_in_statement287);
					func_no_return_stmt();
					state._fsp--;

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement289); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "for_stmt"
	// myCompiler.g:191:1: for_stmt : FOR '(' assign_statements ';' condition ';' assign_statements ')' then_statements ;
	public final void for_stmt() throws RecognitionException {
		Token FOR4=null;
		Info condition3 =null;

		String out_for_label = new String();
		String for_determine = new String();
		String for_body = new String();
		String for_assign = new String(); 
		try {
			// myCompiler.g:196:9: ( FOR '(' assign_statements ';' condition ';' assign_statements ')' then_statements )
			// myCompiler.g:196:10: FOR '(' assign_statements ';' condition ';' assign_statements ')' then_statements
			{
			FOR4=(Token)match(input,FOR,FOLLOW_FOR_in_for_stmt333); 
			match(input,BRACKET_L,FOLLOW_BRACKET_L_in_for_stmt335); 
			pushFollow(FOLLOW_assign_statements_in_for_stmt346);
			assign_statements();
			state._fsp--;


			            for_determine = newLabel();
			            TextCode.add("br label %" + for_determine);
			            TextCode.add(for_determine + ":");
			        
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_for_stmt366); 
			pushFollow(FOLLOW_condition_in_for_stmt376);
			condition3=condition();
			state._fsp--;


			            // parser check
			            if(condition3.theType != TypeInfo.Bool) {
			                System.out.println("Error! " + FOR4.getLine() + ": The expecting type: bool.");
			            }
			                          
			            for_body = newLabel();
			            for_assign = newLabel();
			            out_for_label = newLabel();
			            TextCode.add("br i1 %t" + condition3.theVar.varIndex + ", label %" + for_body + ", label %" + out_for_label);
			            TextCode.add(for_assign + ":");
			        
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_for_stmt396); 
			pushFollow(FOLLOW_assign_statements_in_for_stmt406);
			assign_statements();
			state._fsp--;


			            TextCode.add("br label %" + for_determine);
			            TextCode.add(for_body + ":");
			        
			match(input,BRACKET_R,FOLLOW_BRACKET_R_in_for_stmt426); 
			pushFollow(FOLLOW_then_statements_in_for_stmt436);
			then_statements();
			state._fsp--;


			            TextCode.add("br label %" + for_assign);
			            TextCode.add(out_for_label + ":");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "for_stmt"



	// $ANTLR start "while_stmt"
	// myCompiler.g:231:1: while_stmt : WHILE '(' condition ')' then_statements ;
	public final void while_stmt() throws RecognitionException {
		Token WHILE6=null;
		Info condition5 =null;

		String out_while_label = new String();
		String while_determine = new String(); 
		try {
			// myCompiler.g:234:11: ( WHILE '(' condition ')' then_statements )
			// myCompiler.g:234:12: WHILE '(' condition ')' then_statements
			{
			WHILE6=(Token)match(input,WHILE,FOLLOW_WHILE_in_while_stmt477); 

			              while_determine = newLabel();
			              TextCode.add("br label %" + while_determine);
			              TextCode.add(while_determine + ":");
			          
			match(input,BRACKET_L,FOLLOW_BRACKET_L_in_while_stmt501); 
			pushFollow(FOLLOW_condition_in_while_stmt513);
			condition5=condition();
			state._fsp--;


			              // parser check
			              if(condition5.theType != TypeInfo.Bool) {
			                  System.out.println("Error! " + WHILE6.getLine() + ": The expecting type: bool.");
			              }
			                          
			              String while_body = new String();
			              while_body = newLabel();
			              out_while_label = newLabel();
			              TextCode.add("br i1 %t" + condition5.theVar.varIndex + ", label %" + while_body + ", label %" + out_while_label);
			              TextCode.add(while_body + ":");
			          
			match(input,BRACKET_R,FOLLOW_BRACKET_R_in_while_stmt537); 
			pushFollow(FOLLOW_then_statements_in_while_stmt549);
			then_statements();
			state._fsp--;


			              TextCode.add("br label %" + while_determine);
			              TextCode.add(out_while_label + ":");
			          
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "while_stmt"



	// $ANTLR start "if_statements"
	// myCompiler.g:264:1: if_statements : if_then_statements if_else_statements[label_if] ;
	public final void if_statements() throws RecognitionException {
		String if_then_statements7 =null;

		 String label_if = new String(); 
		try {
			// myCompiler.g:266:14: ( if_then_statements if_else_statements[label_if] )
			// myCompiler.g:266:15: if_then_statements if_else_statements[label_if]
			{
			pushFollow(FOLLOW_if_then_statements_in_if_statements608);
			if_then_statements7=if_then_statements();
			state._fsp--;


			                 label_if = if_then_statements7;
			             
			pushFollow(FOLLOW_if_else_statements_in_if_statements638);
			if_else_statements(label_if);
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_statements"



	// $ANTLR start "if_then_statements"
	// myCompiler.g:273:1: if_then_statements returns [String else_label] : IF '(' condition ')' then_statements ;
	public final String if_then_statements() throws RecognitionException {
		String else_label = null;


		Token IF9=null;
		Info condition8 =null;

		else_label = new String();
		try {
			// myCompiler.g:276:19: ( IF '(' condition ')' then_statements )
			// myCompiler.g:276:20: IF '(' condition ')' then_statements
			{
			IF9=(Token)match(input,IF,FOLLOW_IF_in_if_then_statements700); 
			match(input,BRACKET_L,FOLLOW_BRACKET_L_in_if_then_statements702); 
			pushFollow(FOLLOW_condition_in_if_then_statements704);
			condition8=condition();
			state._fsp--;


			                      // parser check
			                      if(condition8.theType != TypeInfo.Bool) {
			                          System.out.println("Error! " + IF9.getLine() + ": The expecting type: bool.");
			                      }
			                      String true_stmt = new String();
			                      true_stmt = newLabel();
			                      String false_stmt = new String();
			                      else_label = newLabel();
			                      TextCode.add("br i1 %t" + condition8.theVar.varIndex + ", label %" + true_stmt + ", label %" + else_label);
			                      TextCode.add(true_stmt + ":");
			                     
			                  
			match(input,BRACKET_R,FOLLOW_BRACKET_R_in_if_then_statements744); 
			pushFollow(FOLLOW_then_statements_in_if_then_statements746);
			then_statements();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return else_label;
	}
	// $ANTLR end "if_then_statements"



	// $ANTLR start "if_else_statements"
	// myCompiler.g:293:1: if_else_statements[String else_stmt] : ( ELSE then_statements |);
	public final void if_else_statements(String else_stmt) throws RecognitionException {
		String jump_label = new String();
		try {
			// myCompiler.g:295:19: ( ELSE then_statements |)
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ELSE) ) {
				alt5=1;
			}
			else if ( (LA5_0==BEACE_R||LA5_0==FOR||(LA5_0 >= IDENTIFIER && LA5_0 <= IF)||LA5_0==WHILE) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// myCompiler.g:295:20: ELSE then_statements
					{
					match(input,ELSE,FOLLOW_ELSE_in_if_else_statements796); 

					                      jump_label = newLabel();
					                      TextCode.add("br label %" + jump_label);
					                      TextCode.add(else_stmt + ":");
					                      
					                  
					pushFollow(FOLLOW_then_statements_in_if_else_statements836);
					then_statements();
					state._fsp--;


					                      TextCode.add("br label %" + jump_label);
					                      TextCode.add(jump_label + ":");
					                      
					                  
					}
					break;
				case 2 :
					// myCompiler.g:309:19: 
					{

					                      TextCode.add("br label %" + else_stmt);
					                      TextCode.add(else_stmt + ":");
					                  
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_else_statements"



	// $ANTLR start "condition"
	// myCompiler.g:317:1: condition returns [Info theInfo] : a= arith_expression ( compare b= arith_expression )* ;
	public final Info condition() throws RecognitionException {
		Info theInfo = null;


		Info a =null;
		Info b =null;
		ParserRuleReturnScope compare10 =null;

		theInfo = new Info();
		try {
			// myCompiler.g:320:10: (a= arith_expression ( compare b= arith_expression )* )
			// myCompiler.g:320:12: a= arith_expression ( compare b= arith_expression )*
			{
			pushFollow(FOLLOW_arith_expression_in_condition947);
			a=arith_expression();
			state._fsp--;

			 theInfo = a; 
			// myCompiler.g:321:10: ( compare b= arith_expression )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==EQ_OP||(LA6_0 >= GE_OP && LA6_0 <= GT_OP)||LA6_0==LE_OP||(LA6_0 >= LOGICAL_AND && LA6_0 <= LOGICAL_OR)||LA6_0==LT_OP||LA6_0==NE_OP) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// myCompiler.g:321:11: compare b= arith_expression
					{
					pushFollow(FOLLOW_compare_in_condition961);
					compare10=compare();
					state._fsp--;

					pushFollow(FOLLOW_arith_expression_in_condition967);
					b=arith_expression();
					state._fsp--;

					}
					break;

				default :
					break loop6;
				}
			}


			             if(b == null) {
			                 theInfo.theType = TypeInfo.Error;
			                 //System.exit(0);
			             }
			             
			             
			             String CMPcode = new String();
			             String Liden = new String();
			             
			             // code generate
			             if(a.theType == TypeInfo.Integer){
			             
			                 CMPcode = "icmp ";
			             
			                 switch((compare10!=null?input.toString(compare10.start,compare10.stop):null)){
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
			                 
			                 Liden = " i32 %t" + String.valueOf(a.theVar.varIndex) + ", ";
			                 if(b.theType == TypeInfo.Integer) {
			                     Liden += "%t" + String.valueOf(b.theVar.varIndex);
			                 }
			                 else if(b.theType == TypeInfo.Const_int) {
			                     Liden += String.valueOf(b.theVar.iValue);
			                 }
			                 
			             }
			             else if(a.theType == TypeInfo.Float){
			             
			                 CMPcode = "fcmp ";
			             
			                 switch((compare10!=null?input.toString(compare10.start,compare10.stop):null)){
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
			                 
			                 
			                 if(b.theType == TypeInfo.Float) {
			                     Liden = " float %t" + String.valueOf(a.theVar.varIndex) + ", ";
			                     Liden += "%t" + String.valueOf(b.theVar.varIndex);
			                 }
			                 else if(b.theType == TypeInfo.Const_float) {
			                     int convert2double = varCount;
			                     TextCode.add("%t" + convert2double + " = " + "fpext float %t" + a.theVar.varIndex + " to double");
			                     varCount++;
			                     Liden = " double %t" + String.valueOf(convert2double) + ", ";
			                     Liden += b.theVar.fValue;
			                 }
			             }
			             
			             
			             TextCode.add("%t" + varCount + " = " + CMPcode + Liden);
			             
			             
			             // set info
			             theInfo.theType = TypeInfo.Bool;
			             theInfo.theVar.varIndex = varCount;
			             varCount++;
			             
			         
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "condition"


	public static class compare_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "compare"
	// myCompiler.g:421:1: compare : ( EQ_OP | LE_OP | GE_OP | NE_OP | LOGICAL_AND | LOGICAL_OR | GT_OP | LT_OP );
	public final myCompilerParser.compare_return compare() throws RecognitionException {
		myCompilerParser.compare_return retval = new myCompilerParser.compare_return();
		retval.start = input.LT(1);

		try {
			// myCompiler.g:421:8: ( EQ_OP | LE_OP | GE_OP | NE_OP | LOGICAL_AND | LOGICAL_OR | GT_OP | LT_OP )
			// myCompiler.g:
			{
			if ( input.LA(1)==EQ_OP||(input.LA(1) >= GE_OP && input.LA(1) <= GT_OP)||input.LA(1)==LE_OP||(input.LA(1) >= LOGICAL_AND && input.LA(1) <= LOGICAL_OR)||input.LA(1)==LT_OP||input.LA(1)==NE_OP ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "compare"



	// $ANTLR start "assign_statements"
	// myCompiler.g:432:1: assign_statements : IDENTIFIER assign arith_expression ;
	public final void assign_statements() throws RecognitionException {
		Token IDENTIFIER11=null;
		Info arith_expression12 =null;

		try {
			// myCompiler.g:432:18: ( IDENTIFIER assign arith_expression )
			// myCompiler.g:432:20: IDENTIFIER assign arith_expression
			{
			IDENTIFIER11=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assign_statements1092); 
			pushFollow(FOLLOW_assign_in_assign_statements1094);
			assign();
			state._fsp--;

			pushFollow(FOLLOW_arith_expression_in_assign_statements1096);
			arith_expression12=arith_expression();
			state._fsp--;


			                     // check whether the identifier declare 
			                     if (!symtab.containsKey((IDENTIFIER11!=null?IDENTIFIER11.getText():null))) {  System.out.println("Error! " + IDENTIFIER11.getLine() + ":  The identifier hadn't declared yet."); }
			                     
			                     // code 
			                     Info theRHS = arith_expression12;
			                     Info theLHS = symtab.get((IDENTIFIER11!=null?IDENTIFIER11.getText():null)); 
					      
					      // int
			                     if ((theLHS.theType == TypeInfo.Integer) && (theRHS.theType == TypeInfo.Integer)) {		   
			                         // issue store insruction.
			                         // Ex: store i32 %tx, i32* %ty, align 4
			                         TextCode.add("store i32 %t" + theRHS.theVar.varIndex + ", i32* %t" + theLHS.theVar.varIndex + ", align 4");
			                     } 
			                     else if ((theLHS.theType == TypeInfo.Integer) && (theRHS.theType == TypeInfo.Const_int)) {
			                         // issue store insruction.
			                         // Ex: store i32 value, i32* %ty, align 4
			                         TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* %t" + theLHS.theVar.varIndex + ", align 4");				
			                     }
			                     // float
			                     else if ((theLHS.theType == TypeInfo.Float) && (theRHS.theType == TypeInfo.Float)) {		   
			                         // issue store insruction.
			                         // Ex: store i32 %tx, i32* %ty, align 4
			                         TextCode.add("store float %t" + theRHS.theVar.varIndex + ", float* %t" + theLHS.theVar.varIndex + ", align 4");
			                     } 
			                     else if ((theLHS.theType == TypeInfo.Float) && (theRHS.theType == TypeInfo.Const_float)) {
			                         // issue store insruction.
			                         // Ex: store i32 value, i32* %ty
			                         TextCode.add("store float " + theRHS.theVar.fValue + ", float* %t" + theLHS.theVar.varIndex + ", align 4");				
			                     }  
			                     // type error   
			                     else{
			                         System.out.println("Error! " + IDENTIFIER11.getLine() + ": Expecting the same type of the assign!");
			                     }      
			    		
			                 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assign_statements"



	// $ANTLR start "assign"
	// myCompiler.g:472:1: assign : ( ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | MOD_ASSIGN | '=' );
	public final void assign() throws RecognitionException {
		try {
			// myCompiler.g:472:7: ( ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | MOD_ASSIGN | '=' )
			// myCompiler.g:
			{
			if ( (input.LA(1) >= ADD_ASSIGN && input.LA(1) <= ASSIGN)||input.LA(1)==DIV_ASSIGN||input.LA(1)==MOD_ASSIGN||input.LA(1)==MUL_ASSIGN||input.LA(1)==SUB_ASSIGN ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assign"



	// $ANTLR start "then_statements"
	// myCompiler.g:483:1: then_statements : '{' statements '}' ;
	public final void then_statements() throws RecognitionException {
		try {
			// myCompiler.g:483:16: ( '{' statements '}' )
			// myCompiler.g:483:17: '{' statements '}'
			{
			match(input,BEACE_L,FOLLOW_BEACE_L_in_then_statements1214); 
			pushFollow(FOLLOW_statements_in_then_statements1216);
			statements();
			state._fsp--;

			match(input,BEACE_R,FOLLOW_BEACE_R_in_then_statements1218); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "then_statements"



	// $ANTLR start "func_no_return_stmt"
	// myCompiler.g:487:1: func_no_return_stmt : IDENTIFIER '(' argument ')' ;
	public final void func_no_return_stmt() throws RecognitionException {
		String argument13 =null;

		try {
			// myCompiler.g:487:20: ( IDENTIFIER '(' argument ')' )
			// myCompiler.g:487:22: IDENTIFIER '(' argument ')'
			{
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_no_return_stmt1242); 
			match(input,BRACKET_L,FOLLOW_BRACKET_L_in_func_no_return_stmt1244); 
			pushFollow(FOLLOW_argument_in_func_no_return_stmt1246);
			argument13=argument();
			state._fsp--;

			match(input,BRACKET_R,FOLLOW_BRACKET_R_in_func_no_return_stmt1248); 

			                       TextCode.add("%t" + varCount + " = call i32 (i8*, ...) @printf(" + argument13 + ")");
			                       varCount++;
			                   
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "func_no_return_stmt"



	// $ANTLR start "argument"
	// myCompiler.g:495:1: argument returns [String argValue] : a= arg ( ',' b= arg )* ;
	public final String argument() throws RecognitionException {
		String argValue = null;


		Info a =null;
		Info b =null;

		 argValue = new String(); 
		try {
			// myCompiler.g:498:9: (a= arg ( ',' b= arg )* )
			// myCompiler.g:498:11: a= arg ( ',' b= arg )*
			{
			pushFollow(FOLLOW_arg_in_argument1319);
			a=arg();
			state._fsp--;


			            argValue = "i8* getelementptr inbounds (" + a.theVar.strType + ", " + a.theVar.strType + "* " + a.theVar.strIndex + ", i64 0, i64 0)";
			        
			// myCompiler.g:502:9: ( ',' b= arg )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMA) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// myCompiler.g:502:10: ',' b= arg
					{
					match(input,COMMA,FOLLOW_COMMA_in_argument1341); 
					pushFollow(FOLLOW_arg_in_argument1347);
					b=arg();
					state._fsp--;


					            switch(b.theType) {
					                case Integer:
					                    argValue +=  ", i32 %t" + b.theVar.varIndex;
					                    break;
					                case Float:
					                    int floatConvert = varCount;
					                    varCount++;
					                    TextCode.add("%t" + floatConvert + " = fpext float %t" + b.theVar.varIndex + " to double");
					                    argValue += ", double %t" + floatConvert;
					                    break;
					                default:
					            }
					        
					}
					break;

				default :
					break loop7;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return argValue;
	}
	// $ANTLR end "argument"



	// $ANTLR start "arg"
	// myCompiler.g:521:1: arg returns [Info theInfo] : ( arith_expression | LITERAL );
	public final Info arg() throws RecognitionException {
		Info theInfo = null;


		Token LITERAL15=null;
		Info arith_expression14 =null;

		theInfo = new Info();
		try {
			// myCompiler.g:524:4: ( arith_expression | LITERAL )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==BRACKET_L||LA8_0==DEC_NUM||LA8_0==FLOAT_NUM||LA8_0==IDENTIFIER||LA8_0==MINUS) ) {
				alt8=1;
			}
			else if ( (LA8_0==LITERAL) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// myCompiler.g:524:6: arith_expression
					{
					pushFollow(FOLLOW_arith_expression_in_arg1398);
					arith_expression14=arith_expression();
					state._fsp--;


					       theInfo = arith_expression14;
					   
					}
					break;
				case 2 :
					// myCompiler.g:528:6: LITERAL
					{
					LITERAL15=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_arg1410); 

					       theInfo.theType = TypeInfo.Literal;
					       String tempStr = new String();
					       
					       // strIndex
					       tempStr = "@.str" + String.valueOf(strCount);
					       strCount++;
					       theInfo.theVar.strIndex = tempStr;
					       
					       tempStr += " = private unnamed_addr constant ";
					       
					       // input str generate
					       String s = new String((LITERAL15!=null?LITERAL15.getText():null));
					       s = s.replace("\"", "");
					       int sTemplength = s.length();
					       s = s.replace("\\n", "\\0A");
					       int slength = sTemplength - (s.length() - sTemplength) + 1;
					       s = "\"" + s + "\\00\"";
					       // end of input str generate
					       
					       // String type
					       String tempStrType = new String();
					       tempStrType = "[" + String.valueOf(slength) + " x i8]";
					       theInfo.theVar.strType = tempStrType;
					       
					       tempStr += tempStrType + " c" + s + ", align 1";
					       StrTextCode.add(tempStr);
					   
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "arg"



	// $ANTLR start "arith_expression"
	// myCompiler.g:561:1: arith_expression returns [Info theInfo] : a= multExpr ( '+' b= multExpr | '-' c= multExpr )* ;
	public final Info arith_expression() throws RecognitionException {
		Info theInfo = null;


		Info a =null;
		Info b =null;
		Info c =null;

		theInfo = new Info();
		try {
			// myCompiler.g:564:2: (a= multExpr ( '+' b= multExpr | '-' c= multExpr )* )
			// myCompiler.g:564:4: a= multExpr ( '+' b= multExpr | '-' c= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_arith_expression1450);
			a=multExpr();
			state._fsp--;

			 theInfo = a; 
			// myCompiler.g:565:2: ( '+' b= multExpr | '-' c= multExpr )*
			loop9:
			while (true) {
				int alt9=3;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==PLUS) ) {
					alt9=1;
				}
				else if ( (LA9_0==MINUS) ) {
					alt9=2;
				}

				switch (alt9) {
				case 1 :
					// myCompiler.g:565:4: '+' b= multExpr
					{
					match(input,PLUS,FOLLOW_PLUS_in_arith_expression1457); 
					pushFollow(FOLLOW_multExpr_in_arith_expression1463);
					b=multExpr();
					state._fsp--;

					 
						        
						        // code generate
						        if ((a.theType == TypeInfo.Integer) && (b.theType == TypeInfo.Integer)) {
					                    TextCode.add("%t" + varCount + " = add nsw i32 %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
										   
					                    // Update arith_expression's theInfo.
					                    theInfo.theType = TypeInfo.Integer;
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                } 
					                else if ((a.theType == TypeInfo.Integer) && (b.theType == TypeInfo.Const_int)) {
					                    TextCode.add("%t" + varCount + " = add nsw i32 %t" + theInfo.theVar.varIndex + ", " + b.theVar.iValue);
										   
					                    // Update arith_expression's theInfo.
					                    theInfo.theType = TypeInfo.Integer;
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                }
					                else if ((a.theType == TypeInfo.Const_int) && (b.theType == TypeInfo.Const_int)) {
								   
					                    theInfo.theType = TypeInfo.Const_int;
					                    theInfo.theVar.iValue = a.theVar.iValue + b.theVar.iValue;
					                    
					                }
					                else if((a.theType == TypeInfo.Float) && (b.theType == TypeInfo.Float)) {
					                    TextCode.add("%t" + varCount + " = fadd float %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
										   
					                    // Update arith_expression's theInfo.
					                    theInfo.theType = TypeInfo.Float;
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                }
					                // float const 
					                else if((a.theType == TypeInfo.Float) && (b.theType == TypeInfo.Const_float)) {
					                           
					                    // turn float to double
					                    // Ex: %a = fpext float %b to double
					                    int changToDouble = varCount;
					                    TextCode.add("%t" + changToDouble + " = fpext float %t" + theInfo.theVar.varIndex + " to double");
					                    varCount++;
					                           
					                    // add
					                    int doublediv = varCount;
					                    TextCode.add("%t" + doublediv + " = fadd double %t" + changToDouble + ", " + b.theVar.fValue);
					                    varCount++;
					                           
					                    // convert to float
					                    // EX: %a = fptrunc double %b to float
					                    TextCode.add("%t" + varCount + " = fptrunc double %t" + doublediv + "to float");
					                           
					                    // Update arith_expression's theInfo.
					                    theInfo.theType = TypeInfo.Float;
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                }
					                else if((a.theType == TypeInfo.Const_float) && (b.theType == TypeInfo.Const_float)){
					                    theInfo.theType = TypeInfo.Const_float;
					                    float floatconst = a.theVar.ftValue + b.theVar.ftValue;
					                    double doubleConst = floatconst;
					                    theInfo.theVar.ftValue = floatconst;
					                    long d2hex = Double.doubleToLongBits(doubleConst);
					                    theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
					                }
					                // type check
					                else{
					                    theInfo.theType = TypeInfo.Error;
					                    //System.exit(0);
					                }
					            
					}
					break;
				case 2 :
					// myCompiler.g:636:4: '-' c= multExpr
					{
					match(input,MINUS,FOLLOW_MINUS_in_arith_expression1476); 
					pushFollow(FOLLOW_multExpr_in_arith_expression1482);
					c=multExpr();
					state._fsp--;


						        
						        // code generate
						        if ((a.theType == TypeInfo.Integer) && (c.theType == TypeInfo.Integer)) {
					                    TextCode.add("%t" + varCount + " = sub nsw i32 %t" + theInfo.theVar.varIndex + ", %t" + c.theVar.varIndex);
										   
					                    // Update arith_expression's theInfo.
					                    theInfo.theType = TypeInfo.Integer;
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                } 
					                else if ((a.theType == TypeInfo.Integer) && (c.theType == TypeInfo.Const_int)) {
					                    TextCode.add("%t" + varCount + " = sub nsw i32 %t" + theInfo.theVar.varIndex + ", " + c.theVar.iValue);
										   
					                    // Update arith_expression's theInfo.
					                    theInfo.theType = TypeInfo.Integer;
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                }
					                else if ((a.theType == TypeInfo.Const_int) && (c.theType == TypeInfo.Const_int)) {
								   
					                    theInfo.theType = TypeInfo.Const_int;
					                    theInfo.theVar.iValue = a.theVar.iValue - c.theVar.iValue;
					                    
					                }
					                else if((a.theType == TypeInfo.Float) && (c.theType == TypeInfo.Float)) {
					                    TextCode.add("%t" + varCount + " = fsub float %t" + theInfo.theVar.varIndex + ", %t" + c.theVar.varIndex);
										   
					                    // Update arith_expression's theInfo.
					                    theInfo.theType = TypeInfo.Float;
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                }
					                // float const 
					                else if((a.theType == TypeInfo.Float) && (b.theType == TypeInfo.Const_float)) {
					                    // turn float to double
					                    // Ex: %a = fpext float %b to double
					                    int changToDouble = varCount;
					                    TextCode.add("%t" + changToDouble + " = fpext float %t" + theInfo.theVar.varIndex + " to double");
					                    varCount++;
					                           
					                    // div
					                    int doublediv = varCount;
					                    TextCode.add("%t" + doublediv + " = fsub double %t" + changToDouble + ", " + c.theVar.fValue);
					                    varCount++;
					                           
					                    // convert to float
					                    // EX: %a = fptrunc double %b to float
					                    TextCode.add("%t" + varCount + " = fptrunc double %t" + doublediv + "to float");
					                           
					                    // Update arith_expression's theInfo.
					                    theInfo.theType = TypeInfo.Float;
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                }
					                else if((a.theType == TypeInfo.Const_float) && (c.theType == TypeInfo.Const_float)){
					                    theInfo.theType = TypeInfo.Const_float;
					                    float floatconst = a.theVar.ftValue - c.theVar.ftValue;
					                    double doubleConst = floatconst;
					                    theInfo.theVar.ftValue = floatconst;
					                    long d2hex = Double.doubleToLongBits(doubleConst);
					                    theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
					                }
					                // type check
					                else{
					                    theInfo.theType = TypeInfo.Error;
					                    //System.exit(0);
					                }
					            
					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "arith_expression"



	// $ANTLR start "multExpr"
	// myCompiler.g:711:1: multExpr returns [Info theInfo] : a= signExpr ( '*' b= signExpr | '/' c= signExpr )* ;
	public final Info multExpr() throws RecognitionException {
		Info theInfo = null;


		Info a =null;
		Info b =null;
		Info c =null;

		theInfo = new Info();
		try {
			// myCompiler.g:714:2: (a= signExpr ( '*' b= signExpr | '/' c= signExpr )* )
			// myCompiler.g:714:4: a= signExpr ( '*' b= signExpr | '/' c= signExpr )*
			{
			pushFollow(FOLLOW_signExpr_in_multExpr1529);
			a=signExpr();
			state._fsp--;

			 theInfo =a; 
			// myCompiler.g:715:2: ( '*' b= signExpr | '/' c= signExpr )*
			loop10:
			while (true) {
				int alt10=3;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==MULTIPLE) ) {
					alt10=1;
				}
				else if ( (LA10_0==DIVIDED) ) {
					alt10=2;
				}

				switch (alt10) {
				case 1 :
					// myCompiler.g:715:4: '*' b= signExpr
					{
					match(input,MULTIPLE,FOLLOW_MULTIPLE_in_multExpr1536); 
					pushFollow(FOLLOW_signExpr_in_multExpr1542);
					b=signExpr();
					state._fsp--;


								
								 // code generate
								 if ((a.theType == TypeInfo.Integer) && (b.theType == TypeInfo.Integer)) {
					                            TextCode.add("%t" + varCount + " = mul nsw i32 %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
										   
					                            // Update arith_expression's theInfo.
					                            theInfo.theType = TypeInfo.Integer;
					                            theInfo.theVar.varIndex = varCount;
					                            varCount++;
					                        } 
					                        else if ((a.theType == TypeInfo.Integer) && (b.theType == TypeInfo.Const_int)) {
					                           TextCode.add("%t" + varCount + " = mul nsw i32 %t" + theInfo.theVar.varIndex + ", " + b.theVar.iValue);
										   
					                           // Update arith_expression's theInfo.
					                           theInfo.theType = TypeInfo.Integer;
					                           theInfo.theVar.varIndex = varCount;
					                           varCount++;
					                        }
					                        else if ((a.theType == TypeInfo.Const_int) && (b.theType == TypeInfo.Const_int)) {
								   
					                           theInfo.theType = TypeInfo.Const_int;
					                           theInfo.theVar.iValue = a.theVar.iValue * b.theVar.iValue;
					                    
					                        }
					                        else if((a.theType == TypeInfo.Float) && (b.theType == TypeInfo.Float)) {
					                           TextCode.add("%t" + varCount + " = fmul float %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
										   
					                           // Update arith_expression's theInfo.
					                           theInfo.theType = TypeInfo.Float;
					                           theInfo.theVar.varIndex = varCount;
					                           varCount++;
					                        }
					                        // float const 
					                        else if((a.theType == TypeInfo.Float) && (b.theType == TypeInfo.Const_float)) {
					                           // turn float to double
					                           // Ex: %a = fpext float %b to double
					                           int changToDouble = varCount;
					                           TextCode.add("%t" + changToDouble + " = fpext float %t" + theInfo.theVar.varIndex + " to double");
					                           varCount++;
					                           
					                           // mul
					                           int doublediv = varCount;
					                           TextCode.add("%t" + doublediv + " = fmul double %t" + changToDouble + ", " + b.theVar.fValue);
					                           varCount++;
					                           
					                           // convert to float
					                           // EX: %a = fptrunc double %b to float
					                           TextCode.add("%t" + varCount + " = fptrunc double %t" + doublediv + "to float");
					                           
					                           // Update arith_expression's theInfo.
					                           theInfo.theType = TypeInfo.Float;
					                           theInfo.theVar.varIndex = varCount;
					                           varCount++;
					                        }
					                        else if((a.theType == TypeInfo.Const_float) && (b.theType == TypeInfo.Const_float)){
					                           theInfo.theType = TypeInfo.Const_float;
					                           float floatconst = a.theVar.ftValue * b.theVar.ftValue;
					                           double doubleConst = floatconst;
					                           theInfo.theVar.ftValue = floatconst;
					                           long d2hex = Double.doubleToLongBits(doubleConst);
					                           theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
					                         }
					                        // type check
					                        else{
					                           theInfo.theType = TypeInfo.Error;
					                           //System.exit(0);
					                        }
					             
					}
					break;
				case 2 :
					// myCompiler.g:785:4: '/' c= signExpr
					{
					match(input,DIVIDED,FOLLOW_DIVIDED_in_multExpr1564); 
					pushFollow(FOLLOW_signExpr_in_multExpr1570);
					c=signExpr();
					state._fsp--;


					                 
								 // code generate
								 if ((a.theType == TypeInfo.Integer) && (c.theType == TypeInfo.Integer)) {
					                            TextCode.add("%t" + varCount + " = sdiv nsw i32 %t" + theInfo.theVar.varIndex + ", %t" + c.theVar.varIndex);
										   
					                            // Update arith_expression's theInfo.
					                            theInfo.theType = TypeInfo.Integer;
					                            theInfo.theVar.varIndex = varCount;
					                            varCount++;
					                        } 
					                        else if ((a.theType == TypeInfo.Integer) && (c.theType == TypeInfo.Const_int)) {
					                           TextCode.add("%t" + varCount + " = sdiv nsw i32 %t" + theInfo.theVar.varIndex + ", " + c.theVar.iValue);
										   
					                           // Update arith_expression's theInfo.
					                           theInfo.theType = TypeInfo.Integer;
					                           theInfo.theVar.varIndex = varCount;
					                           varCount++;
					                        }
					                        else if ((a.theType == TypeInfo.Const_int) && (c.theType == TypeInfo.Const_int)) {
								   
					                           theInfo.theType = TypeInfo.Const_int;
					                           theInfo.theVar.iValue = a.theVar.iValue / c.theVar.iValue;
					                    
					                        }
					                        else if((a.theType == TypeInfo.Float) && (c.theType == TypeInfo.Float)) {
					                           TextCode.add("%t" + varCount + " = fdiv float %t" + theInfo.theVar.varIndex + ", %t" + c.theVar.varIndex);
										   
					                           // Update arith_expression's theInfo.
					                           theInfo.theType = TypeInfo.Float;
					                           theInfo.theVar.varIndex = varCount;
					                           varCount++;
					                        }
					                        // float const 
					                        else if((a.theType == TypeInfo.Float) && (c.theType == TypeInfo.Const_float)) {
					                           // turn float to double
					                           // Ex: %a = fpext float %b to double
					                           int changToDouble = varCount;
					                           TextCode.add("%t" + changToDouble + " = fpext float %t" + theInfo.theVar.varIndex + " to double");
					                           varCount++;
					                           
					                           // div
					                           int doublediv = varCount;
					                           TextCode.add("%t" + doublediv + " = fdiv double %t" + changToDouble + ", " + c.theVar.fValue);
					                           varCount++;
					                           
					                           // convert to float
					                           // EX: %a = fptrunc double %b to float
					                           TextCode.add("%t" + varCount + " = fptrunc double %t" + doublediv + "to float");
					                           
					                           // Update arith_expression's theInfo.
					                           theInfo.theType = TypeInfo.Float;
					                           theInfo.theVar.varIndex = varCount;
					                           varCount++;
					                        }
					                        else if((a.theType == TypeInfo.Const_float) && (c.theType == TypeInfo.Const_float)){
					                           theInfo.theType = TypeInfo.Const_float;
					                           float floatconst = a.theVar.ftValue / c.theVar.ftValue;
					                           double doubleConst = floatconst;
					                           theInfo.theVar.ftValue = floatconst;
					                           long d2hex = Double.doubleToLongBits(doubleConst);
					                           theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
					                         }
					                        // type check
					                        else{
					                           theInfo.theType = TypeInfo.Error;
					                           //System.exit(0);
					                        }
					             
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "signExpr"
	// myCompiler.g:859:1: signExpr returns [Info theInfo] : (a= primaryExpr | '-' b= primaryExpr );
	public final Info signExpr() throws RecognitionException {
		Info theInfo = null;


		Info a =null;
		Info b =null;

		theInfo = new Info();
		try {
			// myCompiler.g:862:2: (a= primaryExpr | '-' b= primaryExpr )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==BRACKET_L||LA11_0==DEC_NUM||LA11_0==FLOAT_NUM||LA11_0==IDENTIFIER) ) {
				alt11=1;
			}
			else if ( (LA11_0==MINUS) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// myCompiler.g:862:4: a= primaryExpr
					{
					pushFollow(FOLLOW_primaryExpr_in_signExpr1615);
					a=primaryExpr();
					state._fsp--;

					 theInfo =a; 
					}
					break;
				case 2 :
					// myCompiler.g:863:4: '-' b= primaryExpr
					{
					match(input,MINUS,FOLLOW_MINUS_in_signExpr1622); 
					pushFollow(FOLLOW_primaryExpr_in_signExpr1628);
					b=primaryExpr();
					state._fsp--;

					 theInfo =b; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "signExpr"



	// $ANTLR start "primaryExpr"
	// myCompiler.g:868:1: primaryExpr returns [Info theInfo] : ( DEC_NUM | FLOAT_NUM | IDENTIFIER | '(' arith_expression ')' );
	public final Info primaryExpr() throws RecognitionException {
		Info theInfo = null;


		Token DEC_NUM16=null;
		Token FLOAT_NUM17=null;
		Token IDENTIFIER18=null;
		Info arith_expression19 =null;

		theInfo = new Info();
		try {
			// myCompiler.g:871:2: ( DEC_NUM | FLOAT_NUM | IDENTIFIER | '(' arith_expression ')' )
			int alt12=4;
			switch ( input.LA(1) ) {
			case DEC_NUM:
				{
				alt12=1;
				}
				break;
			case FLOAT_NUM:
				{
				alt12=2;
				}
				break;
			case IDENTIFIER:
				{
				alt12=3;
				}
				break;
			case BRACKET_L:
				{
				alt12=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// myCompiler.g:871:4: DEC_NUM
					{
					DEC_NUM16=(Token)match(input,DEC_NUM,FOLLOW_DEC_NUM_in_primaryExpr1656); 

						    theInfo.theType = TypeInfo.Const_int;
						    theInfo.theVar.iValue = Integer.parseInt((DEC_NUM16!=null?DEC_NUM16.getText():null));
						
					}
					break;
				case 2 :
					// myCompiler.g:876:4: FLOAT_NUM
					{
					FLOAT_NUM17=(Token)match(input,FLOAT_NUM,FOLLOW_FLOAT_NUM_in_primaryExpr1666); 

						    theInfo.theType = TypeInfo.Const_float;
						    float floatconst = Float.parseFloat((FLOAT_NUM17!=null?FLOAT_NUM17.getText():null));
						    double doubleConst = floatconst;
					            theInfo.theVar.ftValue = floatconst;
					            long d2hex = Double.doubleToLongBits(doubleConst);
					            theInfo.theVar.fValue = "0x" + Long.toHexString(d2hex);
						    
						
					}
					break;
				case 3 :
					// myCompiler.g:886:4: IDENTIFIER
					{
					IDENTIFIER18=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primaryExpr1674); 

					            // check whether the identifier exist 
					            if (symtab.containsKey((IDENTIFIER18!=null?IDENTIFIER18.getText():null))) {
					            
					                // get type information from symtab.
					                TypeInfo the_type = symtab.get((IDENTIFIER18!=null?IDENTIFIER18.getText():null)).theType;
					                theInfo.theType = the_type;
					                
					                // get variable index from symtab.
					                int vIndex = symtab.get((IDENTIFIER18!=null?IDENTIFIER18.getText():null)).theVar.varIndex;
					                
					                switch(the_type) {
					                case Integer:
					                    // get a new temporaty variable and load the variable into the temporary variable.
					                    // Ex: %tx = load i32, i32* %ty, align 4.
					                    TextCode.add("%t" + varCount + " = load i32, i32* %t" + vIndex + ", align 4");
									         
					                    // Now, Identifier's value is at the temporary variable %t[varCount]. Therefore, update it.
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                    break;
					                case Float:
					                    // Ex: %tx = load float, float* %ty, align 4.
					                    TextCode.add("%t" + varCount + " = load float, float* %t" + vIndex + ", align 4");
									         
					                    // Now, Identifier's value is at the temporary variable %t[varCount]. Therefore, update it.
					                    theInfo.theVar.varIndex = varCount;
					                    varCount++;
					                    break;
					                case Char:
					                    break;
					                }
								
					            } 
					            else { System.out.println("Error! " + IDENTIFIER18.getLine() + ": The identifier hadn't declared yet."); }
					            
					        
					}
					break;
				case 4 :
					// myCompiler.g:924:11: '(' arith_expression ')'
					{
					match(input,BRACKET_L,FOLLOW_BRACKET_L_in_primaryExpr1697); 
					pushFollow(FOLLOW_arith_expression_in_primaryExpr1699);
					arith_expression19=arith_expression();
					state._fsp--;

					match(input,BRACKET_R,FOLLOW_BRACKET_R_in_primaryExpr1701); 
					 theInfo = arith_expression19; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "primaryExpr"

	// Delegated rules



	public static final BitSet FOLLOW_INT_TYPE_in_program34 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_MAIN_in_program36 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_BRACKET_L_in_program38 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_BRACKET_R_in_program40 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BEACE_L_in_program61 = new BitSet(new long[]{0x00000B3000008080L,0x0000000000000080L});
	public static final BitSet FOLLOW_declarations_in_program63 = new BitSet(new long[]{0x0000032000000080L,0x0000000000000080L});
	public static final BitSet FOLLOW_statements_in_program65 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEACE_R_in_program67 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations93 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declarations95 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_SEMICOLON_in_declarations97 = new BitSet(new long[]{0x0000081000008000L});
	public static final BitSet FOLLOW_declarations_in_declarations99 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_TYPE_in_type168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_TYPE_in_type177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_TYPE_in_type186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements198 = new BitSet(new long[]{0x0000032000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_statements_in_statements200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_statements_in_statement232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stmt_in_statement246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stmt_in_statement259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_statements_in_statement272 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_no_return_stmt_in_statement287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_SEMICOLON_in_statement289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_for_stmt333 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_BRACKET_L_in_for_stmt335 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_assign_statements_in_for_stmt346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_SEMICOLON_in_for_stmt366 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_condition_in_for_stmt376 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_SEMICOLON_in_for_stmt396 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_assign_statements_in_for_stmt406 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_BRACKET_R_in_for_stmt426 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_then_statements_in_for_stmt436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_while_stmt477 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_BRACKET_L_in_while_stmt501 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_condition_in_while_stmt513 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_BRACKET_R_in_while_stmt537 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_then_statements_in_while_stmt549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_then_statements_in_if_statements608 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_if_else_statements_in_if_statements638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_then_statements700 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_BRACKET_L_in_if_then_statements702 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_condition_in_if_then_statements704 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_BRACKET_R_in_if_then_statements744 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_then_statements_in_if_then_statements746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_if_else_statements796 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_then_statements_in_if_else_statements836 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arith_expression_in_condition947 = new BitSet(new long[]{0x0405A0C040000002L});
	public static final BitSet FOLLOW_compare_in_condition961 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_arith_expression_in_condition967 = new BitSet(new long[]{0x0405A0C040000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_assign_statements1092 = new BitSet(new long[]{0x0280000004000030L,0x0000000000000008L});
	public static final BitSet FOLLOW_assign_in_assign_statements1094 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_arith_expression_in_assign_statements1096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEACE_L_in_then_statements1214 = new BitSet(new long[]{0x0000032000000080L,0x0000000000000080L});
	public static final BitSet FOLLOW_statements_in_then_statements1216 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEACE_R_in_then_statements1218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_func_no_return_stmt1242 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_BRACKET_L_in_func_no_return_stmt1244 = new BitSet(new long[]{0x0010410100400800L});
	public static final BitSet FOLLOW_argument_in_func_no_return_stmt1246 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_BRACKET_R_in_func_no_return_stmt1248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_in_argument1319 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_COMMA_in_argument1341 = new BitSet(new long[]{0x0010410100400800L});
	public static final BitSet FOLLOW_arg_in_argument1347 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_arith_expression_in_arg1398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LITERAL_in_arg1410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression1450 = new BitSet(new long[]{0x1010000000000002L});
	public static final BitSet FOLLOW_PLUS_in_arith_expression1457 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression1463 = new BitSet(new long[]{0x1010000000000002L});
	public static final BitSet FOLLOW_MINUS_in_arith_expression1476 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression1482 = new BitSet(new long[]{0x1010000000000002L});
	public static final BitSet FOLLOW_signExpr_in_multExpr1529 = new BitSet(new long[]{0x0100000002000002L});
	public static final BitSet FOLLOW_MULTIPLE_in_multExpr1536 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_signExpr_in_multExpr1542 = new BitSet(new long[]{0x0100000002000002L});
	public static final BitSet FOLLOW_DIVIDED_in_multExpr1564 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_signExpr_in_multExpr1570 = new BitSet(new long[]{0x0100000002000002L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr1615 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_signExpr1622 = new BitSet(new long[]{0x0000010100400800L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr1628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEC_NUM_in_primaryExpr1656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_NUM_in_primaryExpr1666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_primaryExpr1674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BRACKET_L_in_primaryExpr1697 = new BitSet(new long[]{0x0010010100400800L});
	public static final BitSet FOLLOW_arith_expression_in_primaryExpr1699 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_BRACKET_R_in_primaryExpr1701 = new BitSet(new long[]{0x0000000000000002L});
}

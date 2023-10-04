// $ANTLR 3.5.3 myCompiler.g 2023-06-15 10:28:12

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCompilerLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public myCompilerLexer() {} 
	public myCompilerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCompilerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "myCompiler.g"; }

	// $ANTLR start "INT_TYPE"
	public final void mINT_TYPE() throws RecognitionException {
		try {
			int _type = INT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:934:11: ( 'int' )
			// myCompiler.g:934:13: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT_TYPE"

	// $ANTLR start "CHAR_TYPE"
	public final void mCHAR_TYPE() throws RecognitionException {
		try {
			int _type = CHAR_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:935:11: ( 'char' )
			// myCompiler.g:935:13: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR_TYPE"

	// $ANTLR start "VOID_TYPE"
	public final void mVOID_TYPE() throws RecognitionException {
		try {
			int _type = VOID_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:936:11: ( 'void' )
			// myCompiler.g:936:13: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID_TYPE"

	// $ANTLR start "FLOAT_TYPE"
	public final void mFLOAT_TYPE() throws RecognitionException {
		try {
			int _type = FLOAT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:937:11: ( 'float' )
			// myCompiler.g:937:13: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_TYPE"

	// $ANTLR start "BOOL_TYPE"
	public final void mBOOL_TYPE() throws RecognitionException {
		try {
			int _type = BOOL_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:938:11: ( 'bool' )
			// myCompiler.g:938:13: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL_TYPE"

	// $ANTLR start "DO"
	public final void mDO() throws RecognitionException {
		try {
			int _type = DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:939:11: ( 'do' )
			// myCompiler.g:939:13: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DO"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:940:11: ( 'while' )
			// myCompiler.g:940:13: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:941:11: ( 'for' )
			// myCompiler.g:941:13: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:942:11: ( 'if' )
			// myCompiler.g:942:13: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:943:11: ( 'else' )
			// myCompiler.g:943:13: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "CONST"
	public final void mCONST() throws RecognitionException {
		try {
			int _type = CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:944:11: ( 'const' )
			// myCompiler.g:944:13: 'const'
			{
			match("const"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONST"

	// $ANTLR start "MAIN"
	public final void mMAIN() throws RecognitionException {
		try {
			int _type = MAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:945:11: ( 'main' )
			// myCompiler.g:945:13: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:946:11: ( 'return' )
			// myCompiler.g:946:13: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "SWITCH"
	public final void mSWITCH() throws RecognitionException {
		try {
			int _type = SWITCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:947:11: ( 'switch' )
			// myCompiler.g:947:13: 'switch'
			{
			match("switch"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SWITCH"

	// $ANTLR start "CASE"
	public final void mCASE() throws RecognitionException {
		try {
			int _type = CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:948:11: ( 'case' )
			// myCompiler.g:948:13: 'case'
			{
			match("case"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CASE"

	// $ANTLR start "BREAK"
	public final void mBREAK() throws RecognitionException {
		try {
			int _type = BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:949:11: ( 'break' )
			// myCompiler.g:949:13: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BREAK"

	// $ANTLR start "CONTINUE"
	public final void mCONTINUE() throws RecognitionException {
		try {
			int _type = CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:950:11: ( 'continue' )
			// myCompiler.g:950:13: 'continue'
			{
			match("continue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONTINUE"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:951:11: ( 'true' )
			// myCompiler.g:951:13: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:952:11: ( 'false' )
			// myCompiler.g:952:13: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "INCLUDE"
	public final void mINCLUDE() throws RecognitionException {
		try {
			int _type = INCLUDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:953:11: ( 'include' )
			// myCompiler.g:953:13: 'include'
			{
			match("include"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INCLUDE"

	// $ANTLR start "DEFINE"
	public final void mDEFINE() throws RecognitionException {
		try {
			int _type = DEFINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:954:11: ( 'define' )
			// myCompiler.g:954:13: 'define'
			{
			match("define"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFINE"

	// $ANTLR start "BRACKET_R"
	public final void mBRACKET_R() throws RecognitionException {
		try {
			int _type = BRACKET_R;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:960:11: ( ')' )
			// myCompiler.g:960:13: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRACKET_R"

	// $ANTLR start "BRACKET_L"
	public final void mBRACKET_L() throws RecognitionException {
		try {
			int _type = BRACKET_L;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:961:11: ( '(' )
			// myCompiler.g:961:13: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRACKET_L"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:962:11: ( ':' )
			// myCompiler.g:962:13: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:963:11: ( ',' )
			// myCompiler.g:963:13: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:964:11: ( ';' )
			// myCompiler.g:964:13: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "BEACE_L"
	public final void mBEACE_L() throws RecognitionException {
		try {
			int _type = BEACE_L;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:965:11: ( '{' )
			// myCompiler.g:965:13: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BEACE_L"

	// $ANTLR start "BEACE_R"
	public final void mBEACE_R() throws RecognitionException {
		try {
			int _type = BEACE_R;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:966:11: ( '}' )
			// myCompiler.g:966:13: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BEACE_R"

	// $ANTLR start "SQUARE_BRACKET_R"
	public final void mSQUARE_BRACKET_R() throws RecognitionException {
		try {
			int _type = SQUARE_BRACKET_R;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:967:18: ( ']' )
			// myCompiler.g:967:20: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SQUARE_BRACKET_R"

	// $ANTLR start "SQUARE_BRACKET_L"
	public final void mSQUARE_BRACKET_L() throws RecognitionException {
		try {
			int _type = SQUARE_BRACKET_L;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:968:18: ( '[' )
			// myCompiler.g:968:20: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SQUARE_BRACKET_L"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:969:11: ( '.' )
			// myCompiler.g:969:13: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:970:11: ( '=' )
			// myCompiler.g:970:13: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:971:11: ( '+' )
			// myCompiler.g:971:13: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:972:11: ( '-' )
			// myCompiler.g:972:13: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MULTIPLE"
	public final void mMULTIPLE() throws RecognitionException {
		try {
			int _type = MULTIPLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:973:11: ( '*' )
			// myCompiler.g:973:13: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTIPLE"

	// $ANTLR start "DIVIDED"
	public final void mDIVIDED() throws RecognitionException {
		try {
			int _type = DIVIDED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:974:11: ( '/' )
			// myCompiler.g:974:13: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIVIDED"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:975:11: ( '%' )
			// myCompiler.g:975:13: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "GT_OP"
	public final void mGT_OP() throws RecognitionException {
		try {
			int _type = GT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:976:11: ( '>' )
			// myCompiler.g:976:13: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT_OP"

	// $ANTLR start "LT_OP"
	public final void mLT_OP() throws RecognitionException {
		try {
			int _type = LT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:977:11: ( '<' )
			// myCompiler.g:977:13: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT_OP"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:978:11: ( '!' )
			// myCompiler.g:978:13: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "BITWISE_AND"
	public final void mBITWISE_AND() throws RecognitionException {
		try {
			int _type = BITWISE_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:979:15: ( '&' )
			// myCompiler.g:979:17: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BITWISE_AND"

	// $ANTLR start "BITWISE_OR"
	public final void mBITWISE_OR() throws RecognitionException {
		try {
			int _type = BITWISE_OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:980:15: ( '|' )
			// myCompiler.g:980:17: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BITWISE_OR"

	// $ANTLR start "ADD_ASSIGN"
	public final void mADD_ASSIGN() throws RecognitionException {
		try {
			int _type = ADD_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:987:15: ( '+=' )
			// myCompiler.g:987:17: '+='
			{
			match("+="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD_ASSIGN"

	// $ANTLR start "SUB_ASSIGN"
	public final void mSUB_ASSIGN() throws RecognitionException {
		try {
			int _type = SUB_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:988:15: ( '-=' )
			// myCompiler.g:988:17: '-='
			{
			match("-="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUB_ASSIGN"

	// $ANTLR start "MUL_ASSIGN"
	public final void mMUL_ASSIGN() throws RecognitionException {
		try {
			int _type = MUL_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:989:15: ( '*=' )
			// myCompiler.g:989:17: '*='
			{
			match("*="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUL_ASSIGN"

	// $ANTLR start "DIV_ASSIGN"
	public final void mDIV_ASSIGN() throws RecognitionException {
		try {
			int _type = DIV_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:990:15: ( '/=' )
			// myCompiler.g:990:17: '/='
			{
			match("/="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV_ASSIGN"

	// $ANTLR start "MOD_ASSIGN"
	public final void mMOD_ASSIGN() throws RecognitionException {
		try {
			int _type = MOD_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:991:15: ( '%=' )
			// myCompiler.g:991:17: '%='
			{
			match("%="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD_ASSIGN"

	// $ANTLR start "EQ_OP"
	public final void mEQ_OP() throws RecognitionException {
		try {
			int _type = EQ_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:992:7: ( '==' )
			// myCompiler.g:992:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ_OP"

	// $ANTLR start "LE_OP"
	public final void mLE_OP() throws RecognitionException {
		try {
			int _type = LE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:993:7: ( '<=' )
			// myCompiler.g:993:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE_OP"

	// $ANTLR start "GE_OP"
	public final void mGE_OP() throws RecognitionException {
		try {
			int _type = GE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:994:7: ( '>=' )
			// myCompiler.g:994:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GE_OP"

	// $ANTLR start "NE_OP"
	public final void mNE_OP() throws RecognitionException {
		try {
			int _type = NE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:995:7: ( '!=' )
			// myCompiler.g:995:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NE_OP"

	// $ANTLR start "PP_OP"
	public final void mPP_OP() throws RecognitionException {
		try {
			int _type = PP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:996:7: ( '++' )
			// myCompiler.g:996:9: '++'
			{
			match("++"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PP_OP"

	// $ANTLR start "MM_OP"
	public final void mMM_OP() throws RecognitionException {
		try {
			int _type = MM_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:997:7: ( '--' )
			// myCompiler.g:997:9: '--'
			{
			match("--"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MM_OP"

	// $ANTLR start "RSHIFT_OP"
	public final void mRSHIFT_OP() throws RecognitionException {
		try {
			int _type = RSHIFT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:998:11: ( '<<' )
			// myCompiler.g:998:13: '<<'
			{
			match("<<"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RSHIFT_OP"

	// $ANTLR start "LSHIFT_OP"
	public final void mLSHIFT_OP() throws RecognitionException {
		try {
			int _type = LSHIFT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:999:11: ( '>>' )
			// myCompiler.g:999:13: '>>'
			{
			match(">>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LSHIFT_OP"

	// $ANTLR start "LOGICAL_AND"
	public final void mLOGICAL_AND() throws RecognitionException {
		try {
			int _type = LOGICAL_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1000:15: ( '&&' )
			// myCompiler.g:1000:17: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOGICAL_AND"

	// $ANTLR start "LOGICAL_OR"
	public final void mLOGICAL_OR() throws RecognitionException {
		try {
			int _type = LOGICAL_OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1001:15: ( '||' )
			// myCompiler.g:1001:17: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOGICAL_OR"

	// $ANTLR start "DEC_NUM"
	public final void mDEC_NUM() throws RecognitionException {
		try {
			int _type = DEC_NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1004:9: ( ( '0' | ( '1' .. '9' ) ( DIGIT )* ) )
			// myCompiler.g:1004:11: ( '0' | ( '1' .. '9' ) ( DIGIT )* )
			{
			// myCompiler.g:1004:11: ( '0' | ( '1' .. '9' ) ( DIGIT )* )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='0') ) {
				alt2=1;
			}
			else if ( ((LA2_0 >= '1' && LA2_0 <= '9')) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// myCompiler.g:1004:12: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// myCompiler.g:1004:18: ( '1' .. '9' ) ( DIGIT )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// myCompiler.g:1004:28: ( DIGIT )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// myCompiler.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop1;
						}
					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEC_NUM"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1006:12: ( ( LETTER ) ( LETTER | DIGIT )* )
			// myCompiler.g:1006:14: ( LETTER ) ( LETTER | DIGIT )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// myCompiler.g:1006:22: ( LETTER | DIGIT )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "FLOAT_NUM"
	public final void mFLOAT_NUM() throws RecognitionException {
		try {
			int _type = FLOAT_NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1008:10: ( FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3 )
			int alt4=3;
			alt4 = dfa4.predict(input);
			switch (alt4) {
				case 1 :
					// myCompiler.g:1008:12: FLOAT_NUM1
					{
					mFLOAT_NUM1(); 

					}
					break;
				case 2 :
					// myCompiler.g:1008:25: FLOAT_NUM2
					{
					mFLOAT_NUM2(); 

					}
					break;
				case 3 :
					// myCompiler.g:1008:38: FLOAT_NUM3
					{
					mFLOAT_NUM3(); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM"

	// $ANTLR start "FLOAT_NUM1"
	public final void mFLOAT_NUM1() throws RecognitionException {
		try {
			// myCompiler.g:1009:20: ( ( DIGIT )+ '.' ( DIGIT )* )
			// myCompiler.g:1009:22: ( DIGIT )+ '.' ( DIGIT )*
			{
			// myCompiler.g:1009:22: ( DIGIT )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			match('.'); 
			// myCompiler.g:1009:33: ( DIGIT )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop6;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM1"

	// $ANTLR start "FLOAT_NUM2"
	public final void mFLOAT_NUM2() throws RecognitionException {
		try {
			// myCompiler.g:1010:20: ( '.' ( DIGIT )+ )
			// myCompiler.g:1010:22: '.' ( DIGIT )+
			{
			match('.'); 
			// myCompiler.g:1010:25: ( DIGIT )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM2"

	// $ANTLR start "FLOAT_NUM3"
	public final void mFLOAT_NUM3() throws RecognitionException {
		try {
			// myCompiler.g:1011:20: ( ( DIGIT )+ )
			// myCompiler.g:1011:22: ( DIGIT )+
			{
			// myCompiler.g:1011:22: ( DIGIT )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM3"

	// $ANTLR start "LITERAL"
	public final void mLITERAL() throws RecognitionException {
		try {
			int _type = LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1013:9: ( '\"' ( options {greedy=false; } : . )* '\"' )
			// myCompiler.g:1013:11: '\"' ( options {greedy=false; } : . )* '\"'
			{
			match('\"'); 
			// myCompiler.g:1013:15: ( options {greedy=false; } : . )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0=='\"') ) {
					alt9=2;
				}
				else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '!')||(LA9_0 >= '#' && LA9_0 <= '\uFFFF')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// myCompiler.g:1013:40: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop9;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LITERAL"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// myCompiler.g:1015:17: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
			// myCompiler.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// myCompiler.g:1016:16: ( '0' .. '9' )
			// myCompiler.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "COMMENT1"
	public final void mCOMMENT1() throws RecognitionException {
		try {
			int _type = COMMENT1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1020:10: ( '//' ( . )* '\\n' )
			// myCompiler.g:1020:12: '//' ( . )* '\\n'
			{
			match("//"); 

			// myCompiler.g:1020:16: ( . )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0=='\n') ) {
					alt10=2;
				}
				else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\uFFFF')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// myCompiler.g:1020:17: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop10;
				}
			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT1"

	// $ANTLR start "COMMENT2"
	public final void mCOMMENT2() throws RecognitionException {
		try {
			int _type = COMMENT2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1021:10: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// myCompiler.g:1021:12: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// myCompiler.g:1021:17: ( options {greedy=false; } : . )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='*') ) {
					int LA11_1 = input.LA(2);
					if ( (LA11_1=='/') ) {
						alt11=2;
					}
					else if ( ((LA11_1 >= '\u0000' && LA11_1 <= '.')||(LA11_1 >= '0' && LA11_1 <= '\uFFFF')) ) {
						alt11=1;
					}

				}
				else if ( ((LA11_0 >= '\u0000' && LA11_0 <= ')')||(LA11_0 >= '+' && LA11_0 <= '\uFFFF')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// myCompiler.g:1021:42: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop11;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT2"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1023:5: ( ( ' ' | '\\r' | '\\t' | '\\n' )+ )
			// myCompiler.g:1023:7: ( ' ' | '\\r' | '\\t' | '\\n' )+
			{
			// myCompiler.g:1023:7: ( ' ' | '\\r' | '\\t' | '\\n' )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '\t' && LA12_0 <= '\n')||LA12_0=='\r'||LA12_0==' ') ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// myCompiler.g:1:8: ( INT_TYPE | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | BOOL_TYPE | DO | WHILE | FOR | IF | ELSE | CONST | MAIN | RETURN | SWITCH | CASE | BREAK | CONTINUE | TRUE | FALSE | INCLUDE | DEFINE | BRACKET_R | BRACKET_L | COLON | COMMA | SEMICOLON | BEACE_L | BEACE_R | SQUARE_BRACKET_R | SQUARE_BRACKET_L | DOT | ASSIGN | PLUS | MINUS | MULTIPLE | DIVIDED | MOD | GT_OP | LT_OP | NOT | BITWISE_AND | BITWISE_OR | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | MOD_ASSIGN | EQ_OP | LE_OP | GE_OP | NE_OP | PP_OP | MM_OP | RSHIFT_OP | LSHIFT_OP | LOGICAL_AND | LOGICAL_OR | DEC_NUM | IDENTIFIER | FLOAT_NUM | LITERAL | COMMENT1 | COMMENT2 | WS )
		int alt13=64;
		alt13 = dfa13.predict(input);
		switch (alt13) {
			case 1 :
				// myCompiler.g:1:10: INT_TYPE
				{
				mINT_TYPE(); 

				}
				break;
			case 2 :
				// myCompiler.g:1:19: CHAR_TYPE
				{
				mCHAR_TYPE(); 

				}
				break;
			case 3 :
				// myCompiler.g:1:29: VOID_TYPE
				{
				mVOID_TYPE(); 

				}
				break;
			case 4 :
				// myCompiler.g:1:39: FLOAT_TYPE
				{
				mFLOAT_TYPE(); 

				}
				break;
			case 5 :
				// myCompiler.g:1:50: BOOL_TYPE
				{
				mBOOL_TYPE(); 

				}
				break;
			case 6 :
				// myCompiler.g:1:60: DO
				{
				mDO(); 

				}
				break;
			case 7 :
				// myCompiler.g:1:63: WHILE
				{
				mWHILE(); 

				}
				break;
			case 8 :
				// myCompiler.g:1:69: FOR
				{
				mFOR(); 

				}
				break;
			case 9 :
				// myCompiler.g:1:73: IF
				{
				mIF(); 

				}
				break;
			case 10 :
				// myCompiler.g:1:76: ELSE
				{
				mELSE(); 

				}
				break;
			case 11 :
				// myCompiler.g:1:81: CONST
				{
				mCONST(); 

				}
				break;
			case 12 :
				// myCompiler.g:1:87: MAIN
				{
				mMAIN(); 

				}
				break;
			case 13 :
				// myCompiler.g:1:92: RETURN
				{
				mRETURN(); 

				}
				break;
			case 14 :
				// myCompiler.g:1:99: SWITCH
				{
				mSWITCH(); 

				}
				break;
			case 15 :
				// myCompiler.g:1:106: CASE
				{
				mCASE(); 

				}
				break;
			case 16 :
				// myCompiler.g:1:111: BREAK
				{
				mBREAK(); 

				}
				break;
			case 17 :
				// myCompiler.g:1:117: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 18 :
				// myCompiler.g:1:126: TRUE
				{
				mTRUE(); 

				}
				break;
			case 19 :
				// myCompiler.g:1:131: FALSE
				{
				mFALSE(); 

				}
				break;
			case 20 :
				// myCompiler.g:1:137: INCLUDE
				{
				mINCLUDE(); 

				}
				break;
			case 21 :
				// myCompiler.g:1:145: DEFINE
				{
				mDEFINE(); 

				}
				break;
			case 22 :
				// myCompiler.g:1:152: BRACKET_R
				{
				mBRACKET_R(); 

				}
				break;
			case 23 :
				// myCompiler.g:1:162: BRACKET_L
				{
				mBRACKET_L(); 

				}
				break;
			case 24 :
				// myCompiler.g:1:172: COLON
				{
				mCOLON(); 

				}
				break;
			case 25 :
				// myCompiler.g:1:178: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 26 :
				// myCompiler.g:1:184: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 27 :
				// myCompiler.g:1:194: BEACE_L
				{
				mBEACE_L(); 

				}
				break;
			case 28 :
				// myCompiler.g:1:202: BEACE_R
				{
				mBEACE_R(); 

				}
				break;
			case 29 :
				// myCompiler.g:1:210: SQUARE_BRACKET_R
				{
				mSQUARE_BRACKET_R(); 

				}
				break;
			case 30 :
				// myCompiler.g:1:227: SQUARE_BRACKET_L
				{
				mSQUARE_BRACKET_L(); 

				}
				break;
			case 31 :
				// myCompiler.g:1:244: DOT
				{
				mDOT(); 

				}
				break;
			case 32 :
				// myCompiler.g:1:248: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 33 :
				// myCompiler.g:1:255: PLUS
				{
				mPLUS(); 

				}
				break;
			case 34 :
				// myCompiler.g:1:260: MINUS
				{
				mMINUS(); 

				}
				break;
			case 35 :
				// myCompiler.g:1:266: MULTIPLE
				{
				mMULTIPLE(); 

				}
				break;
			case 36 :
				// myCompiler.g:1:275: DIVIDED
				{
				mDIVIDED(); 

				}
				break;
			case 37 :
				// myCompiler.g:1:283: MOD
				{
				mMOD(); 

				}
				break;
			case 38 :
				// myCompiler.g:1:287: GT_OP
				{
				mGT_OP(); 

				}
				break;
			case 39 :
				// myCompiler.g:1:293: LT_OP
				{
				mLT_OP(); 

				}
				break;
			case 40 :
				// myCompiler.g:1:299: NOT
				{
				mNOT(); 

				}
				break;
			case 41 :
				// myCompiler.g:1:303: BITWISE_AND
				{
				mBITWISE_AND(); 

				}
				break;
			case 42 :
				// myCompiler.g:1:315: BITWISE_OR
				{
				mBITWISE_OR(); 

				}
				break;
			case 43 :
				// myCompiler.g:1:326: ADD_ASSIGN
				{
				mADD_ASSIGN(); 

				}
				break;
			case 44 :
				// myCompiler.g:1:337: SUB_ASSIGN
				{
				mSUB_ASSIGN(); 

				}
				break;
			case 45 :
				// myCompiler.g:1:348: MUL_ASSIGN
				{
				mMUL_ASSIGN(); 

				}
				break;
			case 46 :
				// myCompiler.g:1:359: DIV_ASSIGN
				{
				mDIV_ASSIGN(); 

				}
				break;
			case 47 :
				// myCompiler.g:1:370: MOD_ASSIGN
				{
				mMOD_ASSIGN(); 

				}
				break;
			case 48 :
				// myCompiler.g:1:381: EQ_OP
				{
				mEQ_OP(); 

				}
				break;
			case 49 :
				// myCompiler.g:1:387: LE_OP
				{
				mLE_OP(); 

				}
				break;
			case 50 :
				// myCompiler.g:1:393: GE_OP
				{
				mGE_OP(); 

				}
				break;
			case 51 :
				// myCompiler.g:1:399: NE_OP
				{
				mNE_OP(); 

				}
				break;
			case 52 :
				// myCompiler.g:1:405: PP_OP
				{
				mPP_OP(); 

				}
				break;
			case 53 :
				// myCompiler.g:1:411: MM_OP
				{
				mMM_OP(); 

				}
				break;
			case 54 :
				// myCompiler.g:1:417: RSHIFT_OP
				{
				mRSHIFT_OP(); 

				}
				break;
			case 55 :
				// myCompiler.g:1:427: LSHIFT_OP
				{
				mLSHIFT_OP(); 

				}
				break;
			case 56 :
				// myCompiler.g:1:437: LOGICAL_AND
				{
				mLOGICAL_AND(); 

				}
				break;
			case 57 :
				// myCompiler.g:1:449: LOGICAL_OR
				{
				mLOGICAL_OR(); 

				}
				break;
			case 58 :
				// myCompiler.g:1:460: DEC_NUM
				{
				mDEC_NUM(); 

				}
				break;
			case 59 :
				// myCompiler.g:1:468: IDENTIFIER
				{
				mIDENTIFIER(); 

				}
				break;
			case 60 :
				// myCompiler.g:1:479: FLOAT_NUM
				{
				mFLOAT_NUM(); 

				}
				break;
			case 61 :
				// myCompiler.g:1:489: LITERAL
				{
				mLITERAL(); 

				}
				break;
			case 62 :
				// myCompiler.g:1:497: COMMENT1
				{
				mCOMMENT1(); 

				}
				break;
			case 63 :
				// myCompiler.g:1:506: COMMENT2
				{
				mCOMMENT2(); 

				}
				break;
			case 64 :
				// myCompiler.g:1:515: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA4 dfa4 = new DFA4(this);
	protected DFA13 dfa13 = new DFA13(this);
	static final String DFA4_eotS =
		"\1\uffff\1\4\3\uffff";
	static final String DFA4_eofS =
		"\5\uffff";
	static final String DFA4_minS =
		"\2\56\3\uffff";
	static final String DFA4_maxS =
		"\2\71\3\uffff";
	static final String DFA4_acceptS =
		"\2\uffff\1\2\1\1\1\3";
	static final String DFA4_specialS =
		"\5\uffff}>";
	static final String[] DFA4_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1",
			"",
			"",
			""
	};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	protected class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}
		@Override
		public String getDescription() {
			return "1008:1: FLOAT_NUM : ( FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3 );";
		}
	}

	static final String DFA13_eotS =
		"\1\uffff\14\44\11\uffff\1\72\1\75\1\100\1\103\1\105\1\111\1\113\1\116"+
		"\1\121\1\123\1\125\1\127\2\130\3\uffff\1\44\1\134\11\44\1\146\7\44\37"+
		"\uffff\1\130\1\156\1\44\1\uffff\5\44\1\166\3\44\1\uffff\7\44\1\uffff\1"+
		"\44\1\u0082\2\44\1\u0085\1\u0086\1\44\1\uffff\1\44\1\u0089\3\44\1\u008d"+
		"\1\u008e\2\44\1\u0091\1\44\1\uffff\1\u0093\1\44\2\uffff\1\u0095\1\u0096"+
		"\1\uffff\1\u0097\1\44\1\u0099\2\uffff\2\44\1\uffff\1\44\1\uffff\1\44\3"+
		"\uffff\1\u009e\1\uffff\1\u009f\1\u00a0\1\u00a1\1\44\4\uffff\1\u00a3\1"+
		"\uffff";
	static final String DFA13_eofS =
		"\u00a4\uffff";
	static final String DFA13_minS =
		"\1\11\1\146\1\141\1\157\1\141\1\157\1\145\1\150\1\154\1\141\1\145\1\167"+
		"\1\162\11\uffff\1\60\1\75\1\53\1\55\1\75\1\52\2\75\1\74\1\75\1\46\1\174"+
		"\2\56\3\uffff\1\143\1\60\1\141\1\156\1\163\1\151\1\157\1\162\1\154\1\157"+
		"\1\145\1\60\1\146\1\151\1\163\1\151\1\164\1\151\1\165\37\uffff\1\56\1"+
		"\60\1\154\1\uffff\1\162\1\163\1\145\1\144\1\141\1\60\1\163\1\154\1\141"+
		"\1\uffff\1\151\1\154\1\145\1\156\1\165\1\164\1\145\1\uffff\1\165\1\60"+
		"\1\164\1\151\2\60\1\164\1\uffff\1\145\1\60\1\153\1\156\1\145\2\60\1\162"+
		"\1\143\1\60\1\144\1\uffff\1\60\1\156\2\uffff\2\60\1\uffff\1\60\1\145\1"+
		"\60\2\uffff\1\156\1\150\1\uffff\1\145\1\uffff\1\165\3\uffff\1\60\1\uffff"+
		"\3\60\1\145\4\uffff\1\60\1\uffff";
	static final String DFA13_maxS =
		"\1\175\1\156\3\157\1\162\1\157\1\150\1\154\1\141\1\145\1\167\1\162\11"+
		"\uffff\1\71\6\75\1\76\2\75\1\46\1\174\2\71\3\uffff\1\164\1\172\1\141\1"+
		"\156\1\163\1\151\1\157\1\162\1\154\1\157\1\145\1\172\1\146\1\151\1\163"+
		"\1\151\1\164\1\151\1\165\37\uffff\1\71\1\172\1\154\1\uffff\1\162\1\164"+
		"\1\145\1\144\1\141\1\172\1\163\1\154\1\141\1\uffff\1\151\1\154\1\145\1"+
		"\156\1\165\1\164\1\145\1\uffff\1\165\1\172\1\164\1\151\2\172\1\164\1\uffff"+
		"\1\145\1\172\1\153\1\156\1\145\2\172\1\162\1\143\1\172\1\144\1\uffff\1"+
		"\172\1\156\2\uffff\2\172\1\uffff\1\172\1\145\1\172\2\uffff\1\156\1\150"+
		"\1\uffff\1\145\1\uffff\1\165\3\uffff\1\172\1\uffff\3\172\1\145\4\uffff"+
		"\1\172\1\uffff";
	static final String DFA13_acceptS =
		"\15\uffff\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\16\uffff\1\73\1"+
		"\75\1\100\23\uffff\1\37\1\74\1\60\1\40\1\53\1\64\1\41\1\54\1\65\1\42\1"+
		"\55\1\43\1\56\1\76\1\77\1\44\1\57\1\45\1\62\1\67\1\46\1\61\1\66\1\47\1"+
		"\63\1\50\1\70\1\51\1\71\1\52\1\72\3\uffff\1\11\11\uffff\1\6\7\uffff\1"+
		"\1\7\uffff\1\10\13\uffff\1\2\2\uffff\1\17\1\3\2\uffff\1\5\3\uffff\1\12"+
		"\1\14\2\uffff\1\22\1\uffff\1\13\1\uffff\1\4\1\23\1\20\1\uffff\1\7\4\uffff"+
		"\1\25\1\15\1\16\1\24\1\uffff\1\21";
	static final String DFA13_specialS =
		"\u00a4\uffff}>";
	static final String[] DFA13_transitionS = {
			"\2\46\2\uffff\1\46\22\uffff\1\46\1\37\1\45\2\uffff\1\34\1\40\1\uffff"+
			"\1\16\1\15\1\32\1\30\1\20\1\31\1\26\1\33\1\42\11\43\1\17\1\21\1\36\1"+
			"\27\1\35\2\uffff\32\44\1\25\1\uffff\1\24\1\uffff\1\44\1\uffff\1\44\1"+
			"\5\1\2\1\6\1\10\1\4\2\44\1\1\3\44\1\11\4\44\1\12\1\13\1\14\1\44\1\3\1"+
			"\7\3\44\1\22\1\41\1\23",
			"\1\50\7\uffff\1\47",
			"\1\53\6\uffff\1\51\6\uffff\1\52",
			"\1\54",
			"\1\57\12\uffff\1\55\2\uffff\1\56",
			"\1\60\2\uffff\1\61",
			"\1\63\11\uffff\1\62",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\73",
			"\1\74",
			"\1\77\21\uffff\1\76",
			"\1\102\17\uffff\1\101",
			"\1\104",
			"\1\110\4\uffff\1\107\15\uffff\1\106",
			"\1\112",
			"\1\114\1\115",
			"\1\120\1\117",
			"\1\122",
			"\1\124",
			"\1\126",
			"\1\73\1\uffff\12\73",
			"\1\73\1\uffff\12\131",
			"",
			"",
			"",
			"\1\133\20\uffff\1\132",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\143",
			"\1\144",
			"\1\145",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\73\1\uffff\12\131",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\157",
			"",
			"\1\160",
			"\1\161\1\162",
			"\1\163",
			"\1\164",
			"\1\165",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\167",
			"\1\170",
			"\1\171",
			"",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"",
			"\1\u0081",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0083",
			"\1\u0084",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0087",
			"",
			"\1\u0088",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u008f",
			"\1\u0090",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0092",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0094",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0098",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"\1\u009a",
			"\1\u009b",
			"",
			"\1\u009c",
			"",
			"\1\u009d",
			"",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u00a2",
			"",
			"",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			""
	};

	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;

	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	protected class DFA13 extends DFA {

		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( INT_TYPE | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | BOOL_TYPE | DO | WHILE | FOR | IF | ELSE | CONST | MAIN | RETURN | SWITCH | CASE | BREAK | CONTINUE | TRUE | FALSE | INCLUDE | DEFINE | BRACKET_R | BRACKET_L | COLON | COMMA | SEMICOLON | BEACE_L | BEACE_R | SQUARE_BRACKET_R | SQUARE_BRACKET_L | DOT | ASSIGN | PLUS | MINUS | MULTIPLE | DIVIDED | MOD | GT_OP | LT_OP | NOT | BITWISE_AND | BITWISE_OR | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | MOD_ASSIGN | EQ_OP | LE_OP | GE_OP | NE_OP | PP_OP | MM_OP | RSHIFT_OP | LSHIFT_OP | LOGICAL_AND | LOGICAL_OR | DEC_NUM | IDENTIFIER | FLOAT_NUM | LITERAL | COMMENT1 | COMMENT2 | WS );";
		}
	}

}

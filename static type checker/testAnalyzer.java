import org.antlr.runtime.*;


public class testAnalyzer {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try {
		   /* test1 output */
	           CharStream input1 = new ANTLRFileStream(args[0]);
	           mycheckerLexer lexer1 = new mycheckerLexer(input1);
	           CommonTokenStream token1 = new CommonTokenStream(lexer1);
	           System.out.println("// File1 token output //");
	           
	           mycheckerParser parser1 = new mycheckerParser(token1);
	           parser1.program();
	           
	           /* test2 output */
	           CharStream input2 = new ANTLRFileStream(args[1]);
	           mycheckerLexer lexer2 = new mycheckerLexer(input2);
	           CommonTokenStream token2 = new CommonTokenStream(lexer2);
	           System.out.println("// File2 token output //");
	           
	           mycheckerParser parser2 = new mycheckerParser(token2);
	           parser2.program();
	           
	           /* test3 output */
	           CharStream input3 = new ANTLRFileStream(args[2]);
	           mycheckerLexer lexer3 = new mycheckerLexer(input3);
	           CommonTokenStream token3 = new CommonTokenStream(lexer3);
	           System.out.println("// File3 token output //");
		   
		   mycheckerParser parser3 = new mycheckerParser(token3);
	           parser3.program();
	        } catch(Throwable t) {
	           System.out.println("Exception: "+t);
	           t.printStackTrace();
	        }
	}

}

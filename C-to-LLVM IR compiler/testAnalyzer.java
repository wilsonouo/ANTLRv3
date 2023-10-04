import org.antlr.runtime.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;  
import java.io.FileWriter;  
import java.io.IOException; 
import java.io.File;

public class testAnalyzer {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try {
		   /* test1 output */
	           CharStream input1 = new ANTLRFileStream(args[0]);
	           myCompilerLexer lexer1 = new myCompilerLexer(input1);
	           CommonTokenStream token1 = new CommonTokenStream(lexer1);
	           System.out.println("// File1 token output //");
	           
	           myCompilerParser parser1 = new myCompilerParser(token1);
	           parser1.program();
	           
                   List<String> text_code = parser1.getTextCode();
                   List<String> str_code = parser1.getStrTextCode();
                   
                   /*Output file */
                   FileWriter file1 = new FileWriter("test1.ll");
                   BufferedWriter output1 = new BufferedWriter(file1);
                   for (int i=0; i < str_code.size(); i++){
                       output1.write(str_code.get(i));
                       output1.newLine();
                       /* Output text section */
                       System.out.println(str_code.get(i));
                   }
                   for(int i = 0; i < text_code.size(); i++) {
                       output1.write(text_code.get(i));
                       output1.newLine();
                       /* Output text section */
                       System.out.println(text_code.get(i));
                    }
                    output1.flush();
                    output1.close();
                
	           /* test2 output */
	           CharStream input2 = new ANTLRFileStream(args[1]);
	           myCompilerLexer lexer2 = new myCompilerLexer(input2);
	           CommonTokenStream token2 = new CommonTokenStream(lexer2);
	           System.out.println("// File2 token output //");
	           
	           
	           myCompilerParser parser2 = new myCompilerParser(token2);
	           parser2.program();
	           
                   List<String> text_code2 = parser2.getTextCode();
                   List<String> str_code2 = parser2.getStrTextCode();
                   
                   /*Output file */
                   FileWriter file2 = new FileWriter("test2.ll");
                   BufferedWriter output2 = new BufferedWriter(file2);
                   for (int i=0; i < str_code2.size(); i++){
                       output2.write(str_code2.get(i));
                       output2.newLine();
                       /* Output text section */
                       System.out.println(str_code2.get(i));
                   }
                   for(int i = 0; i < text_code2.size(); i++) {
                       output2.write(text_code2.get(i));
                       output2.newLine();
                       /* Output text section */
                       System.out.println(text_code2.get(i));
                    }
                    output2.flush();
                    output2.close();
	           
	           /* test3 output */
	           CharStream input3 = new ANTLRFileStream(args[2]);
	           myCompilerLexer lexer3 = new myCompilerLexer(input3);
	           CommonTokenStream token3 = new CommonTokenStream(lexer3);
	           System.out.println("// File3 token output //");
		   
		   myCompilerParser parser3 = new myCompilerParser(token3);
	           parser3.program();
	           
	           List<String> text_code3 = parser3.getTextCode();
	           List<String> str_code3 = parser3.getStrTextCode();
	           
                   /*Output file */
                   FileWriter file3 = new FileWriter("test3.ll");
                   BufferedWriter output3 = new BufferedWriter(file3);
                   for (int i=0; i < str_code3.size(); i++){
                       output3.write(str_code3.get(i));
                       output3.newLine();
                       /* Output text section */
                       System.out.println(str_code3.get(i));
                   }
                   for(int i = 0; i < text_code3.size(); i++) {
                       output3.write(text_code3.get(i));
                       output3.newLine();
                       /* Output text section */
                       System.out.println(text_code3.get(i));
                    }
                    output3.flush();
                    output3.close();
                   
                   
	        } catch(Throwable t) {
	           System.out.println("Exception: "+t);
	           t.printStackTrace();
	        }
	}

}

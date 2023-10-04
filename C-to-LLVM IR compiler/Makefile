JFLAGS1 = -cp
JFLAGS2 = -jar
JAR1 = antlr-3.5.3-complete-no-st3.jar:.	
JAR2 = antlr-3.5.3-complete-no-st3.jar
RUN = testAnalyzer test1.c test2.c test3.c
JC = javac
JVM = java
RM = rm -f
.SUFFIXES: .java .class

testAnalyzer: testAnalyzer.java myParser.java 
	$(JC) $(JFLAGS1) $(JAR1) testAnalyzer.java

myParser.java: myCompiler.g
	$(JVM) $(JFLAGS2) $(JAR2) myCompiler.g 

run: 
	$(JVM) $(JFLAGS1) $(JAR1) $(RUN)

clean:
	$(RM) *.class
	$(RM) myCompilerLexer.java
	$(RM) myCompilerParser.java
	$(RM) myCompiler.tokens
	$(RM) *.ll

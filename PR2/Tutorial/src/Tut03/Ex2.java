package Tut03;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import exer.chap03.TextIOPlus;

public class Ex2 {
    public static void main(String[] args) {
        // program text
        String progText = TextIOPlus.readTextFileContent(Ex2.class,"Hello.j");

        // parse the program text
        CompilationUnit codeUnit = JavaParser.parse(progText);

        // obtain the generated source code
        System.out.println(codeUnit);
    }
}

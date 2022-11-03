package Tut03;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import exer.chap03.TextIOPlus;

public class Ex3 {
    public static void main(String[] args) {
        // program text
        String progText = TextIOPlus.readTextFromURL("https://sites.google.com/site/lemduc/home/ppl/Hello.j?attredirects=0&d=1");

        // parse the program text
        CompilationUnit codeUnit = JavaParser.parse(progText);

        // obtain the generated source code
        System.out.println(codeUnit);
    }
}

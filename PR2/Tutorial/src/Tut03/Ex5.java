package Tut03;

import exer.chap03.TextIOPlus;
import exer.chap03.ast.ASTPrinter;

public class Ex5 {
    public static void main(String[] args) {
        String progText = TextIOPlus.readTextFileContent(Ex5.class,"Hello.j");

        ASTPrinter.print(progText);
    }
}

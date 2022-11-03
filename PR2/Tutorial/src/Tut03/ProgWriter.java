package Tut03;

import exer.chap03.TextIOPlus;

import java.util.Scanner;

public class ProgWriter {
    public static String ProgWriter(String className, String gettingText) {
        String progText = TextIOPlus.readTextFileContent(ProgWriter.class, "template");

        progText = progText.replaceAll("_ClassName_", className);
        progText = progText.replaceAll("_Getting_", "\"" + gettingText + "\"");

        return progText;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Class Name: ");
        String className = scanner.nextLine();
        System.out.print("Enter Getting Text: ");
        String gettingText = scanner.nextLine();

        scanner.close();

        System.out.print(ProgWriter(className, gettingText));
    }
}

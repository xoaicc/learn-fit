package PR1Tutorial.Tut09;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Act1 {
    public static void main(String[] args) throws IOException {
        try {
            PrintWriter file = new PrintWriter("hello.txt");
            file.println("Hello, world!");
            file.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        try {
            File file = new File("hello.txt");
            Scanner input = new Scanner(file);
            String message = input.nextLine();
            System.out.println(message);
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
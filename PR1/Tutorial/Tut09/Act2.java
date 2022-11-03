package PR1Tutorial.Tut09;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

class Act2 {
    public static void main(String[] args) throws IOException {
        try {
            File fileIn = new File("input.txt");
            Scanner input = new Scanner(fileIn);
            PrintWriter fileOut = new PrintWriter("output.txt");
            while (input.hasNextLine()) {
                String message = input.nextLine();
                if (!message.isEmpty()) fileOut.println(message);
            }
            input.close();
            fileOut.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
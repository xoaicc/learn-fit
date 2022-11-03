package PR1Tutorial.Tut09;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

class Act3 {
    public static void main(String[] args) throws IOException {
        try {
            File fileIn = new File("mary.txt");
            Scanner input = new Scanner(fileIn);
            PrintWriter fileOut = new PrintWriter("mary2.txt");
            int countLine = 0;
            while (input.hasNextLine()) {
                String message = input.nextLine();
                countLine++;
                if (!message.isEmpty())
                    if (input.hasNextLine()) fileOut.println(countLine + ". " + message);
                    else fileOut.print(countLine + ". " + message);
            }
            input.close();
            fileOut.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
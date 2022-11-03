package NPRTutorial.Tut02;

import java.util.Scanner;
import java.io.*;

public class TypingKey {
    public static void main(String[] args) throws IOException {
        // Read text from keyboard
        Scanner inText = new Scanner(System.in);
        System.out.print("Enter text: ");
        String Text = inText.nextLine();
 
        // Create file output
        File file = new File("keyboard.txt");
        file.createNewFile();
  
        // Print text to file output
        PrintWriter outText = new PrintWriter("keyboard.txt");
        outText.println(Text);
        outText.close();
    }
}
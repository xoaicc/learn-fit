package PR1Tutorial.Tut10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Act2 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strInput = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the string " + (i+1) + ": ");
            strInput.add(input.nextLine());
        }
        input.close();
        File f = new File("data.bin");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(strInput);
        oos.close();
    }
}
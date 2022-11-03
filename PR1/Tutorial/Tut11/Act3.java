package PR1Tutorial.Tut11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

class Act3 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<Integer, String> list = new HashMap<Integer, String>();
        File file = new File("English.txt");
        Scanner input = new Scanner(file);
        int stt = 0;
        while (input.hasNextLine()) {
            String sentence = input.nextLine();
            for (String i : sentence.toLowerCase().split(" ")) {
                if (!list.containsValue(i)) {
                    list.put(stt, i);
                    stt++;
                }
            }
        }
        input.close();
        System.out.print("The words list are: ");
        for (int i = 0; i < stt; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
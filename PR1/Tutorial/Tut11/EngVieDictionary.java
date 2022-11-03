package PR1Tutorial.Tut11;

import java.util.HashMap;
import java.util.Scanner;

class EngVieDictionary {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("English", "Tieng Anh");
        dictionary.put("Hello", "Xin chao");
        dictionary.put("Good afternoon", "Chao buoi chieu");
        dictionary.put("Goodbye", "Chao tam biet");

        Scanner input = new Scanner(System.in);
        int end;
        do {
            System.out.print("Enter word to look up: ");
            String word = input.nextLine();
            int s = 0;
            for (String i : dictionary.keySet()) {
                s++;
                if (word.equals(i)) {
                    System.out.println("The meaning of " + word + " is: " + dictionary.get(i));
                    break;
                }
                if (s == dictionary.size()) System.out.println("Meaning not found!");
            }
            System.out.print("Do want to look up more? (1: yes/2: no) > ");
            end = input.nextInt();
            input.nextLine();
        } while (end == 1);
        input.close();
    }   
}
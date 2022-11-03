package PR1Tutorial.Tut05;

import java.util.Scanner;

public class Act3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String word = input.nextLine();
        //a
        System.out.print("All chars is uppercase: ");
        
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)) == true)
                System.out.print(word.charAt(i) + " ");
        }
        //b
        System.out.print("\nAll chars is a second letter: ");
        int j = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i)) == true) {
                if ((j % 2) == 0)
                    System.out.print(word.charAt(i) + " ");
                j++;         
            }     
        }
        //c
        String[] vowels = {"u", "e", "o", "a", "i", "U", "E", "O", "A", "I"};
        System.out.print("\nAll chars after replacing: ");
        int count = 0;
        int[] position = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            for (j = 0; j < 10; j++) {
                if (word.charAt(i) == vowels[j].charAt(0)) {
                    word = word.replaceFirst(vowels[j], "_");
                    position[count] = i;
                    count ++;
                }     
            }     
        }
        
        System.out.println(word);
        //d
        System.out.println("The number of vowels in the string " + count);
        //e
        System.out.print("The positions of all vowels in the string ");
        System.out.print(position[0] + " ");
        
        for (int i = 1; i < word.length(); i++)
            if (position[i] != 0)
                System.out.print(position[i] + " ");
    }
}
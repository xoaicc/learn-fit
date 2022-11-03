package PR1Tutorial.Tut11;

import java.util.HashMap;
import java.util.Scanner;

class ScoreChecker {
    public static void main(String[] args) {
        HashMap<String, Double> scoreList = new HashMap<String, Double>();
        scoreList.put("Vuong", 10.0);
        scoreList.put("Huong", 9.0);
        scoreList.put("Duong", 8.0);
        scoreList.put("Tuong", 7.0);

        Scanner input = new Scanner(System.in);
        int end;
        do {
            System.out.print("Enter your name to look up: ");
            String name = input.nextLine();
            int s = 0;
            for (String i : scoreList.keySet()) {
                s++;
                if (name.equals(i)) {
                    System.out.println("The score of " + name + " is: " + scoreList.get(i));
                    break;
                }
                if (s == scoreList.size()) System.out.println("Score not found!");
            }
            System.out.print("Do want to look up more? (1: yes/2: no) > ");
            end = input.nextInt();
            input.nextLine();
        } while (end == 1);
        input.close();
    }   
}
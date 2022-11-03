package PR1Tutorial.Tut08;

import java.util.Random;

public class Act1 {
    static int num;
    static int count = 0;
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            do {
                num = random.nextInt(1000);
            } while (num < 2);

            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    count ++;
                    break;
                }
            }
        }
        System.out.println("The percentage of prime numbers is " + count + "%");
    }
}
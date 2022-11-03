package PR1Tutorial.Tut04;

public class printPrime {
    public static void main(String[] args) {
        for (int i = 1000; i < 2000; i++) {
            for (int j = 2; j <= (int)Math.sqrt(i); j++) {
                if ((i % j) == 0) {
                    break;
                }
                if (j == (int)Math.sqrt(i)) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
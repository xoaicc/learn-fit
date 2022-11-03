package PR1Tutorial.Tut04;

public class printArmstrong {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int n = i;
            int a = 0;
            for (int j = 100; j > 0; j /= 10) {
                a += Math.pow(n / j, 3);
                n %= j;
            }
            if (a == i) {
                System.out.print(i + " ");
            }
        }
    }
}
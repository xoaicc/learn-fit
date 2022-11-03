package PR1Tutorial.Tut02;

public class Act4 {
    public static void main(String[] args) {
        double n = -0.5;
        if (n == 0) {
            System.out.println("(" + n + ") The number is zero.");
        } else if (n > 0) {
            if (n < 1) {
                System.out.println("(" + n + ") A small positive number.");
            }
            else if (n < 1000000){
                System.out.println("(" + n + ") A positive number.");
            } else {
                System.out.println("(" + n + ") A large positive number.");
            }
        } else {
            if (n > -1) {
                System.out.println("(" + n + ") A small negative number.");
            }
            else if (n > -1000000){
                System.out.println("(" + n + ") A negative number.");
            } else {
                System.out.println("(" + n + ") A large negative number.");
            }
        }
    }
}
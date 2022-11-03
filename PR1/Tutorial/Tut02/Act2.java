package PR1Tutorial.Tut02;

public class Act2 {
    public static void main(String[] args) {
        int a = 3;
        int b = 6;
        int c = 2;
        int max;
        max = (a >= b) ? a : b;
        max = (c > max) ? c : max;
        System.out.println("Among " + a + ", " + b + " and " + c + ", the largest is " + max);
    }
}
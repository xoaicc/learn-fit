package PR1Tutorial.Tut02;

public class Act3 {
    public static void main(String[] args) {
        int have = 483274;
        System.out.println((have/10000) + " quan, " + ((have%10000)/100) + " dong, " + (((have%10000)%100)/10) + " hao, " + ((((have%10000)%100)%10)%10) + " xu");
    }
}
package PR1Tutorial.Tut02;

public class Act1 {
    public static void main(String[] args) {
        double wei = 51.0;
        double hei = 1.63;
        System.out.println("My weight: " + wei + " (kg)");
        System.out.println("My height: " + hei + " (m)");
        System.out.println("My BMI: " + (wei/hei/hei) + " (kg/m2)");
    }
}
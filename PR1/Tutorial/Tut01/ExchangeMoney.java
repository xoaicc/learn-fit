package PR1Tutorial.Tut01;

public class ExchangeMoney {
    public static void main(String[] args) {
        long VND = 1200000;
        int rate = 207;
        System.out.println("The amount of JPY for " + VND + " VND is: " + (VND / rate) + " JPY");
    }
}

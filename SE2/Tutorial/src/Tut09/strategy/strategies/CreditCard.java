package Tut09.strategy.strategies;

/**
 * Dummy credit card class.
 */
public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    //TO-DO: Implement the setAmount() method
    public void setAmount(int amount) {
         this.amount = amount;
    }

    //TO-DO: Implement the getAmount() method
    public int getAmount() {
        return amount;
    }
}
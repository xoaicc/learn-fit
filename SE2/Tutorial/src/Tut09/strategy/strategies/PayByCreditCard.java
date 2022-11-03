package Tut09.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    /**
     * Collect credit card data.
     */
    @Override
    public void collectPaymentDetails() {
    	//TO-DO: Add 'try-catch' block to catch the IO error
        try {
    	    //TO-DO: Ask for card number, expiration date, CVV code then save them to suitable variables
            System.out.print("Enter card number: ");
            String number = READER.readLine();
            System.out.print("Enter expiration date: ");
            String date = READER.readLine();
            System.out.print("Enter CVV: ");
            String cvv = READER.readLine();
        
    	    //TO-DO: Create new CreditCard instance with given information
            CreditCard creditCard = new CreditCard(number, date, cvv);

            //TO-DO: Validate credit card number...
            if (number.length() < 10 || number.length() > 14)
                System.out.println("Your credit card number is incorrect!");
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    //TO-DO: Implement the pay() method
    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
    	/*if 'cardIsPresent' => display a message 
    	to show that customer is paying with Credit Card with money amount
    	then reduce the card amount with that number
    	finally return true else return false */
        if (!cardIsPresent()) return false;
        else {
            System.out.println("You are paying with PayPal for " + paymentAmount);
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}

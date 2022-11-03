package tutes.oop1;

public class Pizza {
    private String pizzaSize;
    private int cheeseToppings;
    private int pepperoniToppings;
    private int hamToppings;

    public Pizza(String pizzaSize, int cheeseToppings, int pepperoniToppings, int hamToppings) {
        this.pizzaSize = pizzaSize;
        this.cheeseToppings = cheeseToppings;
        this.pepperoniToppings = pepperoniToppings;
        this.hamToppings = hamToppings;
    }

    public double calcCost() {
        double total = 0;
        if (pizzaSize.equals("small")) total = 10;
        if (pizzaSize.equals("medium")) total = 12;
        if (pizzaSize.equals("large")) total = 14;

        total += (cheeseToppings + pepperoniToppings + hamToppings) * 2;

        return total;
    }

    public String getDescription() {
        return "A " + pizzaSize + " pizza with " + cheeseToppings + " cheese, "
        + pepperoniToppings + " pepperoni and " + hamToppings 
        + " ham toppings should cost a total of $" + calcCost();
    }
}
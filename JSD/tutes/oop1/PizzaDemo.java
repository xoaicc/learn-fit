package tutes.oop1;

public class PizzaDemo {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("large", 5, 2, 3);
        Pizza pizza2 = new Pizza("small", 2, 1, 4);
        PizzaOrder order = new PizzaOrder();
        order.setNumPizzas(2);
        order.setPizza1(pizza1);
        order.setPizza2(pizza2);
        double total = order.calcTotal();
    }
}
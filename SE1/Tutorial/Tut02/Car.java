package SE1Tutorial.Tut02;

public class Car extends Vehicle {
    private String carSymbol = "\uD83D\uDE97 ";
    public Car(String name, double width, double height, double length, double weight, int seatingCapacity, String registrationNumber) {
        super(name, width, height, length, weight, seatingCapacity, registrationNumber);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    public boolean validateWeight(double w) {
        return w >= 1000.0 && w < 2000.0;
    }
    public boolean validateLength(double l) {
        return l >= 1.5 && l <= 3.5;
    }
    boolean validaterRegistrationNumber(String r) {
        return r.length() <= 7;
    }
    public void travel(String a, String b, int passengers ) {
        if ((this.getSeatingCapacity() >= passengers)) {
            System.out.println("Type of vehicle: " + carSymbol + " from " + a + " to " + b + ". Number of passengers : " + passengers);
        } else {
            System.out.println("Passengers : " + passengers + ". Over seatingCapacity: " + this.getSeatingCapacity());
        }
    }
    public String getCarSymbol() {
        return carSymbol;
    }
}
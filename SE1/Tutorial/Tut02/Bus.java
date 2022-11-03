package SE1Tutorial.Tut02;

public class Bus extends Vehicle {
    private String busSymbol = "\uD83D\uDE8C";
    public Bus(String name, double width, double height, double length, double weight, int seatingCapacity, String registrationNumber) {
        super(name, width, height, length, weight, seatingCapacity, registrationNumber);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    public boolean validateWeight(double w) {
        return w >= 5000.0 && w < 20000.0;
    }
    public boolean validateLength(double l) {
        return l >= 4.0 && l <= 10.0;
    }
    boolean validaterRegistrationNumber(String r) {
        return r.length() <= 9;
    }
    public void travel(String a, String b, int passengers) {
        if ((this.getSeatingCapacity() >= passengers)) {
            System.out.println("Vehicle type: " + busSymbol + " from " + a + " to " + b + ". Number of passengers : " + passengers);
        } else {
            System.out.println("Passengers : " + passengers + ". Over seatingCapacity: " + this.getSeatingCapacity());
        }    
    }
    public String getBusSymbol() {
        return busSymbol;
    }
}
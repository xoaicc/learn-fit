package SE1Tutorial.Tut02;

public class Boat extends Vehicle {
    private double capacity;
    private double thickness;

    public Boat(String name, double width, double height, double length, double weight, double thickness, int seatingCapacity, String registrationNumber, int capacity) {
        super(name, width, height, length, weight, seatingCapacity, registrationNumber);
        this.capacity = capacity;
        this.thickness = thickness;
    }

    public double getThickness() {
        return thickness;
    }
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    public boolean validateWeight(double w) {
        return w >= 500.0 && w < 50000.0;
    }
    public boolean validateLength(double l) {
        return l >= 2.0 && l <= 300.0;
    }
    public boolean validateThickness(int c) {
        return c >= 0.1 && c<= 1;
    }
    boolean validaterRegistrationNumber(String r) {
        return r.length() <= 3000;
    }
}
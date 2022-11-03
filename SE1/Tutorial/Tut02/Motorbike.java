package SE1Tutorial.Tut02;

public class Motorbike extends Vehicle {
    private int capacity;

    public Motorbike(String name, double width, double height, double length, double weight, int seatingCapacity, String registrationNumber, int capacity) {
        super(name, width, height, length, weight, seatingCapacity, registrationNumber);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public boolean validateWeight(double w) {
        return w >= 100.0 && w < 200.0;
    }

    public boolean validateLength(double l) {
        return l >= 1.5 && l <= 2.0;
    }

    public boolean validateCapacity(int c) {
        return c >= 50 && c<= 300;
    }

    boolean validaterRegistrationNumber(String r) {
        return r.length() <= 2;
    }
}
package SE1Tutorial.Tut01;

public class Bus extends Vehicle {
    public Bus(String name, double width, double height, double length, double weight, int seatingCapacity, String registrationNumber) {
        super(name, width, height, length, weight, seatingCapacity, registrationNumber);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    @Override
    public boolean validateWeight(double w) {
        return w >= 5000.0 && w < 20000.0;
    }

    public boolean validateLength(double l) {
        return l >= 4.0 && l <= 10.0;
    }

    @Override
    boolean validaterRegistrationNumber(String r) {
        return r.length() <= 9;
    }
}

package SE1Tutorial.Tut01;

public class Car extends Vehicle {
    public Car(String name, double width, double height, double length, double weight, int seatingCapacity, String registrationNumber) {
        super(name, width, height, length, weight, seatingCapacity, registrationNumber);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    @Override
    public boolean validateWeight(double w) {
        return w>=1000.0 && w<2000.0;
    }

    public boolean validateLength(double l) {
        return l>=1.5 && l<=3.5;
    }

    @Override
    boolean validaterRegistrationNumber(String r) {
        return r.length()<=7;
    }
}

package PR1Tutorial.Tut06;

public class CarDemo {
    public static void main(String[] args) {
        Car myHybrid = new Car(20);

        // Show features
        System.out.println("The certain fuel efficiency of this vehicle is " + myHybrid.getEff() + " km/liter");
        System.out.println("The certain amount of fuel in the tank after adding is " + myHybrid.addGas(10) + " liters");
        System.out.println("The certain amount of fuel consumed is " + myHybrid.drive(100) + " liters");
        System.out.println("The certain amount of fuel left in the tank is " + myHybrid.getGasInTank() + " liters");
    }
}
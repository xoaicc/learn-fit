package SE1Tutorial.Tut02;

public class IronSuit extends Vehicle {
    private String model;

    public IronSuit(String name, double width, double height, double length, double weight, int seatingCapacity, String registrationNumber, String model) {
        super(name, width, height, length, weight, seatingCapacity, registrationNumber);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    private boolean validateModel() {
        return true;
    }

    public void fly(String a, String b, int distance){
        int millies = 300;
        System.out.print(a);
        for (int i = 0; i < distance; i++) {
            try {
                Thread.sleep(millies);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(b);
    }
}
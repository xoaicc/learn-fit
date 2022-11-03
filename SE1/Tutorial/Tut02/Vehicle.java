package SE1Tutorial.Tut02;

import java.security.InvalidParameterException;

public class Vehicle {
    private String name;
    private double width;
    private double height;
    private double length;
    private double weight;
    private int seatingCapacity;
    private String registrationNumber;
    private String symbol;

    public Vehicle(String name, double width, double height, double length, double weight, int seatingCapacity,String registrationNumber) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;

        if(!validateWeight(weight)){
        } else {
            this.weight = weight;
        }
        if(!validateSeatingCapacity(seatingCapacity)){
             System.out.println("invalid seatingCapacity");
        }else {
            this.seatingCapacity = seatingCapacity;
        }
        if(!validateRegistrationNumber(registrationNumber)){
            System.out.println("invalid registrationNumber");
        } else {
            this.registrationNumber = registrationNumber;
        }
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public void travel() {
    }

    @Override
    public String toString() {
        String className = this.getClass().getSimpleName();
        return  className +
                "name = " + name + ", width = " + width + ", height = " + height + ", length = " + length + ", weight = " + weight + ", seatingCapacity = " + seatingCapacity + ", registrationNumber = " + registrationNumber;
    }
    /**
     * @effects
     * if weight is a valid c.weight
     *   return true
     * else
     *   return false
     */
    protected boolean validateWeight(double weight){
        return true;
    }
    /**
     * @effects
     * if seatingCapacity is a valid c.seatingCapacity
     *   return true
     * else
     *   return false
     */
    protected boolean validateSeatingCapacity(int seatingCapacity) {
        return seatingCapacity >= 1 && seatingCapacity <= 13;
    }
    /**
     * @effects
     * if registrationNumber is a valid c.registrationNumber
     *   return true
     * else
     *   return false
     */
    protected boolean validateRegistrationNumber(String registrationNumber) {
        return registrationNumber.length() < 13;
    }
    /**
     * @effects
     * if name is a valid c.name
     *   return true
     * else
     *   return false
     */
    protected boolean validateName(String name) {
        return name != null || name.length() > 0;
    }
    /**
     * @effects
     * if width is a valid c.width
     *   return true
     * else
     *   return false
     */
    protected boolean validateWidth(double width) {
        return width > 0;
    }
    /**
     * @effects
     * if height is a valid c.height
     *   return true
     * else
     *   return false
     */
    protected boolean validateHeight(double height) {
        return height > 0;
    }
    /**
     * @effects
     * if length is a valid c.length
     *   return true
     * else
     *   return false
     */
    protected boolean validateLength(double length) {
        return length > 0;
    }
    /**
     * @effects
     * if this satisfies rep invariant
     *   return true
     * else
     *   return false
     */
    protected boolean repOk() {
        return validateName(name) && validateWidth(width) & validateHeight(height) && validateLength(length) && validateWeight(weight) && validateSeatingCapacity(seatingCapacity);
    }
    /**
     * @effects
     *  travel from a to b
     */
    public void travel(String a, String b, int passengers) {
        if (this.getSeatingCapacity() >= passengers) {
            System.out.println("Vehicle type: " + symbol + " from " + a + " to " + b + ". Number of passengers : " + passengers);
        } else {
            System.out.println("Passengers: " + passengers + ". Over seatingCapacity: " + this.getSeatingCapacity());
        }
    }
}
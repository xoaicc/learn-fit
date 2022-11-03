package SE1Tutorial.Tut01;

import java.security.InvalidParameterException;

public class Vehicle {
    private String name;
    private double width;
    private double height;
    private double length;
    private double weight;
    private int seatingCapacity;
    private String registrationNumber;

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
        if(!validaterRegistrationNumber(registrationNumber)){
            System.out.println("invalid registrationNumber");
        } else {
            this.registrationNumber = registrationNumber;
        }
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


    @Override
    public String toString() {
        return this.toString();
    }

    boolean validateWeight(double w){
        return false;
    }

    boolean validateSeatingCapacity(int c){
        return c >= 1 && c <= 13;
    }

    boolean validaterRegistrationNumber(String r){
        return r.length()<13;
    }
}

package Tut06.b;

public class MobilePhone {
    public void recordName(String manName) {
        this.manName = manName;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String manName;
    private String model;
    private char color;
    private int year;
    private boolean guaranteed;

    public MobilePhone(String manName, String model, char color, int year, boolean guaranteed) {
        this.manName = manName;
        this.model = model;
        this.color = color;
        this.year = year;
        this.guaranteed = guaranteed;
    }
}

package Tut12;

public class Boa {
    private String name;
    private int length;
    private String favoriteFood;

    public Boa(String name, int length, String favoriteFood) {
        this.name = name;
        this.length = length;
        this.favoriteFood = favoriteFood;
    }

    public boolean isHealthy() {
        return this.favoriteFood.equals("granola bars");
    }

    public boolean fitsInCage(int caseLength) {
        return this.length < caseLength;
    }

    public int lengthInInches() {
        return (int)(length * 0.39370);
    }
}

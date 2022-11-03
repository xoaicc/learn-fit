package PR1Tutorial.Tut01;

public class PrintMyAge {
    public static void main(String[] args) {
        int birth_year = 2001;
        int now_year = 2021;
        System.out.println("I was born in " + birth_year + ". This year is " + now_year + ".\nTherefore, my age is: " + (now_year - birth_year));
    }
}
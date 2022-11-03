package PR1Tutorial.Tut07;

public class Employee {
    String name;
    double currentSalary;

    public Employee(String employeeName, double currentSalary) {
        this.name = employeeName;
        this.currentSalary = currentSalary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return currentSalary;
    }

    public void raiseSalary(double byPercent) {
        System.out.println(currentSalary * byPercent);
    }
}
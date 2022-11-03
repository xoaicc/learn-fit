package Tut10.MandKind;

public class Worker extends Human {

    private double weekSalary;
    private int workHoursPerDay;
    private double salaryPerHour;

    public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkHoursPerDay(workHoursPerDay);
        setSalaryPerHour();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(String.format("""
                                        First Name: %s
                                        Last Name: %s
                                        Week Salary: %.2f
                                        Hours per day: %d
                                        Salary per hour: %.2f""",
                                this.getFirstName(),
                                this.getLastName(),
                                this.getWeekSalary(),
                                this.getHoursPerDay(),
                                this.getSalaryPerHour()));
        return sb.toString();
    }

    protected double getWeekSalary() {
        return weekSalary;
    }

    protected void setWeekSalary(double weekSalary) {
        if (weekSalary < 10)
            throw new IllegalArgumentException("Expected value mismatch! Argument: weekSalary");
        this.weekSalary = weekSalary;
    }

    protected int getHoursPerDay() {
        return workHoursPerDay;
    }

    protected void setWorkHoursPerDay(int workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12)
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        this.workHoursPerDay = workHoursPerDay;
    }

    protected double getSalaryPerHour() {
        return salaryPerHour;
    }

    protected void setSalaryPerHour() {
        this.salaryPerHour = weekSalary/7/workHoursPerDay;
    }
}

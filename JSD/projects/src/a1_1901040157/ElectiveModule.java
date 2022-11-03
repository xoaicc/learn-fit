package a1_1901040157;

public class ElectiveModule extends Module {
    private final String department;

    public ElectiveModule(String name, int semester, int credits, String department) {
        super(name, semester, credits);
        generateCode(semester);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "ElectiveModule{" +
                "code:'" + getCode() + '\'' +
                ", name:'" + getName() + '\'' +
                ", semester:" + getSemester() +
                ", credits:" + getCredits() +
                ", department:'" + getDepartment() + '\'' +
                '}';
    }
}

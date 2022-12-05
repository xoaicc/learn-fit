package asm2.a2_1901040247;

public class ElectiveModule extends Module {
    private final String department;

    public ElectiveModule(String name, int semester, int credits, String department) {
        super(name, semester, credits);
        generateCode(semester);
        this.department = department;
    }

    @Override
    public String toString() {
        return "ElectiveModule{" +
                "code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", semester=" + getSemester() +
                ", credits=" + getCredits() +
                ", department='" + department + '\'' +
                '}';
    }
}

package a1_1901040157;

public class CompulsoryModule extends Module {
    public CompulsoryModule(String name, int semester, int credits) {
        super(name, semester, credits);
        generateCode(semester);
    }

    @Override
    public String toString() {
        return "CompulsoryModule{" +
                "code:'" + getCode() + '\'' +
                ", name:'" + getName() + '\'' +
                ", semester:" + getSemester() +
                ", credits:" + getCredits() +
                '}';
    }
}
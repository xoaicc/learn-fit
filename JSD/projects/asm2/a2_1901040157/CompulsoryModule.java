package a2_1901040157;

import java.sql.SQLException;

public class CompulsoryModule extends Module {
    public CompulsoryModule(String name, int semester, int credits) throws SQLException {
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
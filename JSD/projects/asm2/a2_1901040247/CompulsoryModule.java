package a2_1901040247;

import java.sql.SQLException;

public class CompulsoryModule extends Module {
    public CompulsoryModule(String name, int semester, int credits) throws SQLException {
        super(name, semester, credits);
        generateCode(semester);
    }
}
package a2_1901040247;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

abstract class Module {
    private static AtomicInteger count1 = new AtomicInteger(100);
    private static AtomicInteger count2 = new AtomicInteger(200);
    private static AtomicInteger count3 = new AtomicInteger(300);
    private String code;
    private final String name;
    private final int semester;
    private final int credits;
    Connection conn = DriverManager.getConnection("jdbc:sqlite:src/a2_1901040247/database.sqlite3");

    public Module(String name, int semester, int credits) throws SQLException {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
        checkCodeInDatabase();
    }

    private void checkCodeInDatabase() {
        String[] moduleCodeList = null;
        try {
            String sql = "SELECT Module_Code FROM MODULES;";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            String moduleCodes = "";
            while (rs.next()) {
                moduleCodes += rs.getString("Module_Code") + ",";
            }
            if (!moduleCodes.equals("")) moduleCodeList = moduleCodes.split(",");
        } catch (SQLException ignored) {}

        if (moduleCodeList != null) {
            boolean c1 = false, c2 = false, c3 = false;

            for (int i = moduleCodeList.length - 1; i >= 0; i--) {
                if (moduleCodeList[i].contains("M1") && !c1) {
                    count1 = new AtomicInteger(
                            Integer.parseInt(moduleCodeList[i].substring(1)));
                    c1 = true;
                }
                if (moduleCodeList[i].contains("M2") && !c2) {
                    count2 = new AtomicInteger(
                            Integer.parseInt(moduleCodeList[i].substring(1)));
                    c2 = true;
                }
                if (moduleCodeList[i].contains("M3") && !c3) {
                    count3 = new AtomicInteger(
                            Integer.parseInt(moduleCodeList[i].substring(1)));
                    c3 = true;
                }
            }
        }
    }

    public void generateCode(int semester) {
        if (semester == 1) {
            count1.incrementAndGet();
            code = "M" + count1;
        }if (semester == 2) {
            count2.incrementAndGet();
            code = "M" + count2;
        }if (semester == 3) {
            count3.incrementAndGet();
            code = "M" + count3;
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public int getCredits() {
        return credits;
    }
}

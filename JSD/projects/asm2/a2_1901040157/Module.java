package a2_1901040157;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

abstract class Module {
    private String code;
    private final String name;
    private final int seme;
    private final int cred;
    private static AtomicInteger c1 = new AtomicInteger(100);
    private static AtomicInteger c2 = new AtomicInteger(200);
    private static AtomicInteger c3 = new AtomicInteger(300);
    Connection conn = DriverManager.getConnection("jdbc:sqlite:src/a2_1901040157/database.sqlite3");

    public Module(String name, int semester, int credits) throws SQLException {
        this.name = name;
        this.seme = semester;
        this.cred = credits;
        getLastCode();
    }

    private void getLastCode() {
        String[] modCodeList = null;
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT ModuleCode FROM MODULES;");
            StringBuilder modCodes = new StringBuilder();
            while (rs.next()) {
                modCodes.append(rs.getString("ModuleCode")).append(" ");
            }
            if (!modCodes.toString().equals("")) modCodeList = modCodes.toString().split(" ");
        } catch (SQLException ignored) {}

        if (modCodeList != null) {
            boolean m1 = false;
            boolean m2 = false;
            boolean m3 = false;

            for (int i = modCodeList.length - 1; i >= 0; i--) {
                if (modCodeList[i].contains("M1") && !m1) {
                    c1 = new AtomicInteger(
                            Integer.parseInt(modCodeList[i].substring(1)));
                    m1 = true;
                }
                if (modCodeList[i].contains("M2") && !m2) {
                    c2 = new AtomicInteger(
                            Integer.parseInt(modCodeList[i].substring(1)));
                    m2 = true;
                }
                if (modCodeList[i].contains("M3") && !m3) {
                    c3 = new AtomicInteger(
                            Integer.parseInt(modCodeList[i].substring(1)));
                    m3 = true;
                }
            }
        }
    }

    public void generateCode(int semester) {
        if (semester == 1) {
            c1.incrementAndGet();
            code = "M" + c1;
        } else if (semester == 2) {
            c2.incrementAndGet();
            code = "M" + c2;
        } else {
            c3.incrementAndGet();
            code = "M" + c3;
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return seme;
    }

    public int getCredits() {
        return cred;
    }
}

package a2_1901040157;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Calendar;

public class Student {
    private final String id;
    private final String name;
    private final int dob;
    private final String addr;
    private final String email;
    private static AtomicInteger count = new AtomicInteger(Calendar.getInstance().get(Calendar.YEAR));
    Connection conn = DriverManager.getConnection("jdbc:sqlite:src/a2_1901040157/database.sqlite3");

    public Student(String name, int dob, String address, String email) throws SQLException {
        getLastID();
        id = "S" + count.getAndIncrement();
        this.name = name;
        this.dob = dob;
        this.addr = address;
        this.email = email;
    }

    private void getLastID() {
        String[] stuIDList = null;
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT StudentID FROM STUDENTS;");
            StringBuilder stuIDs = new StringBuilder();
            while (rs.next()) {
                stuIDs.append(rs.getString("StudentID")).append(" ");
            }
            if (!stuIDs.toString().equals("")) stuIDList = stuIDs.toString().split(" ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (stuIDList != null) {
            count = new AtomicInteger(Integer.parseInt(stuIDList[stuIDList.length-1].substring(1))+1);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDob() {
        return dob;
    }

    public String getAddr() {
        return addr;
    }

    public String getEmail() {
        return email;
    }
}
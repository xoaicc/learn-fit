package a2_1901040247;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private static AtomicInteger count = new AtomicInteger(
            Calendar.getInstance().get(Calendar.YEAR));
    private final String id;
    private final String name;
    private final int dob;
    private final String address;
    private final String email;
    Connection conn = DriverManager.getConnection("jdbc:sqlite:src/a2_1901040247/database.sqlite3");

    public Student(String name, int dob, String address, String email) throws SQLException {
        checkCodeInDatabase();
        id = "S" + count.getAndIncrement();
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
    }

    private void checkCodeInDatabase() {
        String[] studentIDList = null;
        try {
            String sql = "SELECT Student_ID FROM STUDENTS;";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            String studentIDs = "";
            while (rs.next()) {
                studentIDs += rs.getString("Student_ID") + ",";
            }
            if (!studentIDs.equals("")) studentIDList = studentIDs.split(",");
        } catch (SQLException ignored) {}

        if (studentIDList != null) {
            count = new AtomicInteger(
                    Integer.parseInt(studentIDList[studentIDList.length-1].substring(1))+1);
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

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
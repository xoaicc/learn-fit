package a2_1901040247;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.Vector;

public class CourseManProg {
    Connection conn;
    String sql;

    public CourseManProg() throws SQLException, IOException {
        conn = DriverManager.getConnection("jdbc:sqlite:src/a2_1901040247/database.sqlite3");
        showMainGUI();
    }

    private void showMainGUI() throws IOException {
        JFrame mainF = new JFrame("Course Manager");

        // setup file menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> mainF.dispose());
        fileMenu.add(exit);

        // setup student menu
        JMenu studentMenu = new JMenu("Student");

        JMenuItem newStudent = new JMenuItem("New student");
        newStudent.addActionListener(e -> showAddGUI(1));
        studentMenu.add(newStudent);

        JMenuItem listStudent = new JMenuItem("List students");
        listStudent.addActionListener(e -> showListGUI(1));
        studentMenu.add(listStudent);

        // setup module menu
        JMenu moduleMenu = new JMenu("Module");

        JMenuItem newModule = new JMenuItem("New module");
        newModule.addActionListener(e -> showAddGUI(2));
        moduleMenu.add(newModule);

        JMenuItem listModule = new JMenuItem("List modules");
        listModule.addActionListener(e -> showListGUI(2));
        moduleMenu.add(listModule);

        // setup module menu
        JMenu enrolmentMenu = new JMenu("Enrolment");

        JMenuItem newEnrolment = new JMenuItem("New enrolment");
        newEnrolment.addActionListener(e -> showAddGUI(3));
        enrolmentMenu.add(newEnrolment);

        JMenuItem iniReport = new JMenuItem("Initial report");
        iniReport.addActionListener(e -> showReportGUI(1));
        enrolmentMenu.add(iniReport);

        JMenuItem assReport = new JMenuItem("Assessment report");
        assReport.addActionListener(e -> showReportGUI(2));
        enrolmentMenu.add(assReport);

        // setup menu bar
        JMenuBar bar = new JMenuBar();
        bar.add(fileMenu);
        bar.add(studentMenu);
        bar.add(moduleMenu);
        bar.add(enrolmentMenu);
        mainF.setJMenuBar(bar);

        // add header panel
        JPanel header = new JPanel();
        JLabel title = new JLabel("Welcome to Course Manager Program! " +
                "Please use menu to perform the operations in this program.");
        header.add(title);
        header.setBackground(Color.cyan);
        mainF.add(header, BorderLayout.NORTH);

        // add body panel
        JPanel body = new JPanel();
        BufferedImage img = ImageIO.read(new File("src/a2_1901040247/course-manager.png"));
        JLabel picLabel = new JLabel(new ImageIcon(img));
        body.add(picLabel);
        body.setBackground(Color.WHITE);
        mainF.add(body);

        // add footer panel
        JPanel footer = new JPanel();
        JLabel copyright = new JLabel("© 2022 CourseManProg by Vuong IT");
        footer.add(copyright);
        footer.setBackground(Color.LIGHT_GRAY);
        mainF.add(footer, BorderLayout.SOUTH);

        // setup window
        mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainF.pack();
        mainF.setVisible(true);
    }

    private void showAddGUI(int opt) {
        JFrame addF = new JFrame();
        JPanel header = new JPanel();
        JLabel title = new JLabel("Enter details");
        header.add(title);
        addF.add(header, BorderLayout.NORTH);

        JPanel body;
        JTextField sName = new JTextField(20);
        JTextField mName = new JTextField(20);
        JTextField dob = new JTextField(10);
        JTextField addr = new JTextField(30);
        JTextField email = new JTextField(30);
        JTextField ses = new JTextField(10);;
        JTextField cred = new JTextField(30);
        JTextField dep = new JTextField(20);
        JTextField iMark = new JTextField(20);
        JTextField eMark = new JTextField(20);

        final String[] moduleType = {""};
        final String[] studentID = {""};
        final String[] moduleCODE = {""};

        if (opt == 1) {
            addF.setTitle("Add Student");
            body = new JPanel(new GridLayout(4, 2));

            body.add(new JLabel("Student Name"));
            body.add(sName);

            body.add(new JLabel("Date of Birth"));
            body.add(dob);

            body.add(new JLabel("Address"));
            body.add(addr);

            body.add(new JLabel("Email"));
            body.add(email);
        } else if (opt == 2) {
            addF.setTitle("Add Module");
            body = new JPanel(new GridLayout(5, 2));

            body.add(new JLabel("Module Name"));
            body.add(mName);

            body.add(new JLabel("Semester"));
            body.add(ses);

            body.add(new JLabel("Credits"));
            body.add(cred);

            body.add(new JLabel("Module Type"));

            String[] moduleTypes = {"Compulsory module", "Elective module"};
            JComboBox typeList = new JComboBox(moduleTypes);
            typeList.setSelectedIndex(0);
            body.add(typeList);

            body.add(new JLabel("Department"));
            body.add(dep);
            dep.setVisible(false);

            // handle combo box event
            typeList.addActionListener(e -> {
                moduleType[0] = (String) ((JComboBox) e.getSource()).getSelectedItem();
                dep.setVisible(moduleType[0].equals("Elective module"));
            });
        } else {
            addF.setTitle("Add Enrolment");
            body = new JPanel(new GridLayout(4, 2));

            body.add(new JLabel("Student to Add"));
            String[] students = null;
            try {
                sql = "SELECT Student_ID FROM STUDENTS;";
                ResultSet rs = conn.createStatement().executeQuery(sql);
                String studentIDs = "";
                while (rs.next()) {
                    studentIDs += rs.getString("Student_ID") + ",";
                }
                students = studentIDs.split(",");
            } catch (SQLException ignored) {}
            JComboBox studentList = new JComboBox(students);
            studentList.setSelectedIndex(0);
            studentID[0] = students[0];

            // handle combo box event
            studentList.addActionListener(e -> {
                studentID[0] = (String) ((JComboBox) e.getSource()).getSelectedItem();
            });
            body.add(studentList);

            body.add(new JLabel("Module to Add"));
            String[] modules = {""};
            try {
                sql = "SELECT Module_Code FROM MODULES;";
                ResultSet rs = conn.createStatement().executeQuery(sql);
                String moduleCODEs = "";
                while (rs.next()) {
                    moduleCODEs += rs.getString("Module_Code") + ",";
                }
                modules = moduleCODEs.split(",");
            } catch (SQLException ignored) {}
            JComboBox moduleList = new JComboBox(modules);
            moduleList.setSelectedIndex(0);
            moduleCODE[0] = modules[0];

            // handle combo box event
            moduleList.addActionListener(e -> {
                moduleCODE[0] = (String) ((JComboBox) e.getSource()).getSelectedItem();
            });
            body.add(moduleList);

            body.add(new JLabel("Internal Mark"));
            body.add(iMark);

            body.add(new JLabel("Exam Mark"));
            body.add(eMark);
        }
        body.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        addF.add(body);

        JPanel footer = new JPanel();

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> {
            if (opt == 1) {
                Student stu = null;
                try {
                    stu = new Student(
                            sName.getText(),
                            Integer.parseInt(dob.getText()),
                            addr.getText(),
                            email.getText());
                } catch (SQLException ignored) {}

                try {
                    sql = "INSERT INTO STUDENTS " + "VALUES ('" + stu.getId() +
                            "', '" + stu.getName() + "', " + stu.getDob() +
                            ", '" + stu.getAddress() + "', '" + stu.getEmail() + "');";
                    conn.createStatement().executeQuery(sql);
                } catch (SQLException ignored) {}

                sName.setText("");
                dob.setText("");
                addr.setText("");
                email.setText("");
            } else if (opt == 2) {
                if (moduleType[0].equals("Compulsory module")) {
                    CompulsoryModule mod = null;
                    try {
                        mod = new CompulsoryModule(
                                mName.getText(),
                                Integer.parseInt(ses.getText()),
                                Integer.parseInt(cred.getText())
                        );
                    } catch (SQLException ignored) {}

                    try {
                        sql = "INSERT INTO MODULES (Module_Code, Module_Name, Semester, Credits) " +
                                "VALUES ('" + mod.getCode() +
                                "', '" + mod.getName() + "', " + mod.getSemester() +
                                ", " + mod.getCredits() + ");";
                        conn.createStatement().executeQuery(sql);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    ElectiveModule mod = null;
                    try {
                        mod = new ElectiveModule(
                                mName.getText(),
                                Integer.parseInt(ses.getText()),
                                Integer.parseInt(cred.getText()),
                                dep.getText()
                        );
                    } catch (SQLException ignored) {}

                    try {
                        sql = "INSERT INTO MODULES " + "VALUES ('" + mod.getCode() +
                                "', '" + mod.getName() + "', " + mod.getSemester() +
                                ", " + mod.getCredits() + ", '" + mod.getDepartment() + "');";
                        conn.createStatement().executeQuery(sql);
                    } catch (SQLException ignored) {}
                }

                mName.setText("");
                ses.setText("");
                cred.setText("");
                dep.setText("");
            } else {
                Enrolment enrol = new Enrolment(studentID[0], moduleCODE[0]);
                enrol.setInternalMark(Double.parseDouble(iMark.getText()));
                enrol.setExamMark(Double.parseDouble(eMark.getText()));

                try {
                    sql = "INSERT INTO ENROLMENTS (Student_ID, Module_Code, Internal_Mark, " +
                            "Exam_Mark, Final_Grade) " + "VALUES ('" +
                            enrol.getStudentID() + "', '" +
                            enrol.getModuleCODE() + "', " +
                            iMark.getText() + ", " +
                            eMark.getText() + ", '" +
                            enrol.getFinalGrade() + "');";
                    conn.createStatement().executeQuery(sql);
                } catch (SQLException ignored) {}
                iMark.setText("");
                eMark.setText("");
            }
            addF.dispose();
        });

        JButton addCancelBtn = new JButton("Cancel");
        addCancelBtn.addActionListener(e -> addF.dispose());

        footer.add(addBtn);
        footer.add(addCancelBtn);
        addF.add(footer, BorderLayout.SOUTH);

        addF.pack();
        addF.setVisible(true);
    }

    private void showListGUI(int opt) {
        JFrame listF = new JFrame();

        if (opt == 1) {
            listF.setTitle("List Students");
            JPanel header = new JPanel();
            JLabel title = new JLabel("Student List");
            header.add(title);
            listF.add(header, BorderLayout.NORTH);

            JPanel body = new JPanel();
            JTable table = null;

            try {
                sql = "SELECT * FROM STUDENTS;";
                ResultSet rs = conn.createStatement().executeQuery(sql);
                table = new JTable(buildTable(rs));
            } catch (SQLException ignored) {}

            JScrollPane scroll = new JScrollPane(table);
            body.add(scroll);
            listF.add(body);
        } else {
            listF.setTitle("List Modules");
            JPanel header = new JPanel();
            JLabel title = new JLabel("Module List");
            header.add(title);
            listF.add(header, BorderLayout.NORTH);

            JPanel body = new JPanel();
            JTable table = null;

            try {
                sql = "SELECT * FROM MODULES;";
                ResultSet rs = conn.createStatement().executeQuery(sql);
                table = new JTable(buildTable(rs));
            } catch (SQLException ignored) {}

            JScrollPane scroll = new JScrollPane(table);
            body.add(scroll);
            listF.add(body);
        }

        JPanel footer = new JPanel();

        JButton addCloseBtn = new JButton("Close");
        addCloseBtn.addActionListener(e -> listF.dispose());

        footer.add(addCloseBtn);
        listF.add(footer, BorderLayout.SOUTH);

        listF.pack();
        listF.setVisible(true);
    }

    private void showReportGUI(int opt) {
        JFrame listF = new JFrame();

        if (opt == 1) {
            listF.setTitle("Initial Report");
            JPanel header = new JPanel();
            JLabel title = new JLabel("Initial report");
            header.add(title);
            listF.add(header, BorderLayout.NORTH);

            JPanel body = new JPanel();
            JTable table = null;

            try {
                sql = "SELECT ENROLMENTS.ID, STUDENTS.Student_ID, " +
                        "STUDENTS.Student_Name, MODULES.Module_Code, MODULES.Module_Name\n" +
                        "  FROM ENROLMENTS\n" +
                        "  INNER JOIN STUDENTS\n" +
                        "  ON ENROLMENTS.Student_ID = STUDENTS.Student_ID\n" +
                        "  INNER JOIN MODULES\n" +
                        "  ON ENROLMENTS.Module_Code = MODULES.Module_Code;";
                ResultSet rs = conn.createStatement().executeQuery(sql);
                table = new JTable(buildTable(rs));
            } catch (SQLException ignored) {}

            JScrollPane scroll = new JScrollPane(table);
            body.add(scroll);
            listF.add(body);
        } else {
            listF.setTitle("Assessment Report");
            JPanel header = new JPanel();
            JLabel title = new JLabel("Assessment report");
            header.add(title);
            listF.add(header, BorderLayout.NORTH);

            JPanel body = new JPanel();
            JTable table = null;

            try {
                sql = "SELECT * FROM ENROLMENTS;";
                ResultSet rs = conn.createStatement().executeQuery(sql);
                table = new JTable(buildTable(rs));
            } catch (SQLException ignored) {}

            JScrollPane scroll = new JScrollPane(table);
            body.add(scroll);
            listF.add(body);
        }

        JPanel footer = new JPanel();

        JButton addCloseBtn = new JButton("Close");
        addCloseBtn.addActionListener(e -> listF.dispose());

        footer.add(addCloseBtn);
        listF.add(footer, BorderLayout.SOUTH);

        listF.pack();
        listF.setVisible(true);
    }

    public static DefaultTableModel buildTable(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    public static void main(String[] args) throws IOException, SQLException {
        new CourseManProg();
    }
}

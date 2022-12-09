package a2_1901040157;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.Vector;

public class CourseManProg {
    Connection conn = DriverManager.getConnection("jdbc:sqlite:src/a2_1901040157/database.sqlite3");

    public CourseManProg() throws SQLException {
    }

    private void createMainGUI() throws IOException {
        // initialize main gui
        JFrame mainGUI = new JFrame("Course Manager");

        // create file menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener((e) -> mainGUI.dispose());
        fileMenu.add(exit);

        // create student menu
        JMenu stuMenu = new JMenu("Student");
        JMenuItem newStu = new JMenuItem("New student");
        JMenuItem listStu = new JMenuItem("List students");
        newStu.addActionListener((e) -> createAddGUI("Student"));
        listStu.addActionListener((e) -> createListGUI("Student"));
        stuMenu.add(newStu);
        stuMenu.add(listStu);

        // create module menu
        JMenu modMenu = new JMenu("Module");
        JMenuItem newMod = new JMenuItem("New module");
        JMenuItem listMod = new JMenuItem("List modules");
        newMod.addActionListener((e) -> createAddGUI("Module"));
        listMod.addActionListener((e) -> createListGUI("Module"));
        modMenu.add(newMod);
        modMenu.add(listMod);

        // create enrolment menu
        JMenu enrolMenu = new JMenu("Enrolment");
        JMenuItem newEnrol = new JMenuItem("New enrolment");
        JMenuItem iniReport = new JMenuItem("Initial report");
        JMenuItem assReport = new JMenuItem("Assessment report");
        newEnrol.addActionListener((e) -> createAddGUI("Enrol"));
        iniReport.addActionListener((e) -> createListGUI("Report1"));
        assReport.addActionListener((e) -> createListGUI("Report2"));
        enrolMenu.add(newEnrol);
        enrolMenu.add(iniReport);
        enrolMenu.add(assReport);

        // create menu bar
        JMenuBar bar = new JMenuBar();
        bar.add(fileMenu);
        bar.add(stuMenu);
        bar.add(modMenu);
        bar.add(enrolMenu);
        mainGUI.setJMenuBar(bar);

        // create header in main gui
        JPanel header = new JPanel();
        JLabel title = new JLabel("Important! This program needs to use the menu to perform the functions.");
        header.add(title);
        mainGUI.add(header, BorderLayout.NORTH);
        header.setBackground(Color.ORANGE);

        // create body in main gui
        JPanel body = new JPanel();
        BufferedImage img = ImageIO.read(new File("src/a2_1901040157/app-pic.png"));
        JLabel imgLab = new JLabel(new ImageIcon(img));
        body.add(imgLab);
        mainGUI.add(body);
        body.setPreferredSize(new Dimension(700, 500));

        // create footer in main gui
        JPanel footer = new JPanel();
        JLabel cr = new JLabel("Author by Ngan Phuc.");
        footer.add(cr);
        mainGUI.add(footer, BorderLayout.SOUTH);
        footer.setBackground(Color.MAGENTA);

        // setup for main gui
        mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainGUI.pack();
        mainGUI.setVisible(true);
    }

    private void createAddGUI(String obj) {
        // initialize add gui
        JFrame addGUI = new JFrame();

        // create header in add gui
        JPanel header = new JPanel();
        JLabel title = new JLabel("Enter details");
        header.add(title);
        header.setBackground(Color.ORANGE);
        addGUI.add(header, BorderLayout.NORTH);

        // create body in add gui
        JPanel body;
        JTextField stuName = new JTextField(30);
        JTextField modName = new JTextField(30);
        JTextField dob = new JTextField(30);
        JTextField addr = new JTextField(30);
        JTextField email = new JTextField(30);
        JTextField seme = new JTextField(30);
        JTextField cred = new JTextField(30);
        JTextField dept = new JTextField(30);
        JTextField iniMark = new JTextField(30);
        JTextField exaMark = new JTextField(30);

        final String[] modType = {""};
        final String[] stuID = {""};
        final String[] modCode = {""};

        if (obj.equals("Student")) {
            body = new JPanel(new GridLayout(4, 2));

            body.add(new JLabel("Student Name"));
            body.add(stuName);

            body.add(new JLabel("Date of Birth"));
            body.add(dob);

            body.add(new JLabel("Address"));
            body.add(addr);

            body.add(new JLabel("Email"));
            body.add(email);

            addGUI.setTitle("Add Student");
        } else if (obj.equals("Module")) {
            body = new JPanel(new GridLayout(5, 2));

            body.add(new JLabel("Module Name"));
            body.add(modName);

            body.add(new JLabel("Semester"));
            body.add(seme);

            body.add(new JLabel("Credits"));
            body.add(cred);

            body.add(new JLabel("Module Type"));

            String[] modTypes = {"Compulsory module", "Elective module"};
            JComboBox modTypeList = new JComboBox(modTypes);
            modTypeList.setSelectedIndex(0);
            body.add(modTypeList);

            body.add(new JLabel("Department"));
            body.add(dept);
            dept.setVisible(false);

            modTypeList.addActionListener((e) -> {
                modType[0] = (String) ((JComboBox) e.getSource()).getSelectedItem();
                dept.setVisible(modType[0].equals("Elective module"));
            });

            addGUI.setTitle("Add Module");
        } else {
            body = new JPanel(new GridLayout(4, 2));

            body.add(new JLabel("Choose a Student"));
            String[] stus = null;
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT StudentID FROM STUDENTS;");
                StringBuilder stuIDs = new StringBuilder();
                while (rs.next()) {
                    stuIDs.append(rs.getString("StudentID")).append(" ");
                }
                stus = stuIDs.toString().split(" ");
            } catch (SQLException ex) {}

            assert stus != null;
            JComboBox stuList = new JComboBox(stus);
            stuList.setSelectedIndex(0);
            stuList.addActionListener((e) -> {
                stuID[0] = (String) ((JComboBox) e.getSource()).getSelectedItem();
            });
            body.add(stuList);
            stuID[0] = stus[0];

            body.add(new JLabel("Choose a Module"));
            String[] mods = {""};
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT ModuleCode FROM MODULES;");
                StringBuilder modCodes = new StringBuilder();
                while (rs.next()) {
                    modCodes.append(rs.getString("ModuleCode")).append(" ");
                }
                mods = modCodes.toString().split(" ");
            } catch (SQLException ex) {}
            JComboBox modList = new JComboBox(mods);
            modList.setSelectedIndex(0);
            modList.addActionListener(e -> {
                modCode[0] = (String) ((JComboBox) e.getSource()).getSelectedItem();
            });
            body.add(modList);
            modCode[0] = mods[0];

            body.add(new JLabel("Internal Mark"));
            body.add(iniMark);

            body.add(new JLabel("Exam Mark"));
            body.add(exaMark);

            addGUI.setTitle("Add Enrolment");
        }
        body.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        addGUI.add(body);

        JPanel footer = new JPanel();

        JButton addBtn = new JButton("Add");
        addBtn.setBackground(Color.MAGENTA);
        addBtn.addActionListener(e -> {
            if (obj.equals("Student")) {
                Student stu;
                try {
                    stu = new Student(stuName.getText(),
                            Integer.parseInt(dob.getText()),
                            addr.getText(),
                            email.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    conn.createStatement().executeQuery("INSERT INTO STUDENTS " + "VALUES ('" + stu.getId() +
                            "', '" + stu.getName() + "', " + stu.getDob() +
                            ", '" + stu.getAddr() + "', '" + stu.getEmail() + "');");
                } catch (SQLException ex) {}

                stuName.setText("");
                dob.setText("");
                addr.setText("");
                email.setText("");
            } else if (obj.equals("Module")) {
                if (modType[0].equals("Compulsory module")) {
                    CompulsoryModule mod;
                    try {
                        mod = new CompulsoryModule(modName.getText(),
                                Integer.parseInt(seme.getText()),
                                Integer.parseInt(cred.getText())
                        );
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        conn.createStatement().executeQuery("INSERT INTO MODULES (ModuleCode, Module_Name, Semester, Credits) " +
                                "VALUES ('" + mod.getCode() + "', '" + mod.getName() +
                                "', " + mod.getSemester() + ", " + mod.getCredits() + ");");
                    } catch (SQLException ex) {}
                } else {
                    ElectiveModule mod;
                    try {
                        mod = new ElectiveModule(modName.getText(),
                                Integer.parseInt(seme.getText()),
                                Integer.parseInt(cred.getText()),
                                dept.getText()
                        );
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        conn.createStatement().executeQuery("INSERT INTO MODULES " + "VALUES ('" + mod.getCode() +
                                "', '" + mod.getName() + "', " + mod.getSemester() +
                                ", " + mod.getCredits() + ", '" + mod.getDepartment() + "');");
                    } catch (SQLException ignored) {}
                }

                modName.setText("");
                seme.setText("");
                cred.setText("");
                dept.setText("");
            } else {
                Enrolment erm = new Enrolment(stuID[0], modCode[0]);
                erm.setInternalMark(Double.parseDouble(iniMark.getText()));
                erm.setExamMark(Double.parseDouble(exaMark.getText()));

                try {
                    conn.createStatement().executeQuery("INSERT INTO ENROLMENTS (StudentID, ModuleCode, Internal_Mark, " +
                            "Exam_Mark, Final_Grade) " + "VALUES ('" +
                            erm.getStuID() + "', '" +
                            erm.getModCode() + "', " +
                            erm.getInMark() + ", " +
                            erm.getExMark() + ", '" +
                            erm.getFiGrade() + "');");
                } catch (SQLException ex) {}

                iniMark.setText("");
                exaMark.setText("");
            }
            addGUI.dispose();
        });

        JButton addCancelBtn = new JButton("Cancel");
        addCancelBtn.addActionListener((e) -> addGUI.dispose());

        footer.add(addBtn);
        footer.add(addCancelBtn);
        addGUI.add(footer, BorderLayout.SOUTH);

        addGUI.pack();
        addGUI.setVisible(true);
    }

    private void createListGUI(String obj) {
        JFrame listGUI = new JFrame();
        JPanel header = new JPanel();

        switch (obj) {
            case "Student" -> {
                JLabel title = new JLabel("Student List");
                header.add(title);
                header.setBackground(Color.ORANGE);
                listGUI.add(header, BorderLayout.NORTH);

                JPanel body = new JPanel();
                JTable tab = null;
                try {
                    ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STUDENTS;");
                    tab = new JTable(buildATable(rs));
                } catch (SQLException ex) {}

                JScrollPane scr = new JScrollPane(tab);
                body.add(scr);
                listGUI.add(body);

                listGUI.setTitle("List Students");
            }
            case "Module" -> {
                JLabel title = new JLabel("Module List");
                header.add(title);
                header.setBackground(Color.ORANGE);
                listGUI.add(header, BorderLayout.NORTH);

                JPanel body = new JPanel();
                JTable tab = null;
                try {
                    ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM MODULES;");
                    tab = new JTable(buildATable(rs));
                } catch (SQLException ex) {}

                JScrollPane scr = new JScrollPane(tab);
                body.add(scr);
                listGUI.add(body);

                listGUI.setTitle("List Modules");
            }
            case "Report1" -> {
                JLabel title = new JLabel("Initial report");
                header.add(title);
                header.setBackground(Color.ORANGE);
                listGUI.add(header, BorderLayout.NORTH);

                JPanel body = new JPanel();
                JTable tab = null;
                try {
                    ResultSet rs = conn.createStatement().executeQuery("SELECT ENROLMENTS.ID, STUDENTS.StudentID, " +
                            "STUDENTS.Student_Name, MODULES.ModuleCode, MODULES.Module_Name\n" +
                            "  FROM ENROLMENTS\n" +
                            "  INNER JOIN STUDENTS\n" +
                            "  ON ENROLMENTS.StudentID = STUDENTS.StudentID\n" +
                            "  INNER JOIN MODULES\n" +
                            "  ON ENROLMENTS.ModuleCode = MODULES.ModuleCode;");
                    tab = new JTable(buildATable(rs));
                } catch (SQLException ex) {}

                JScrollPane scr = new JScrollPane(tab);
                body.add(scr);
                listGUI.add(body);

                listGUI.setTitle("Initial Report");
            }
            default -> {
                JLabel title = new JLabel("Assessment report");
                header.add(title);
                header.setBackground(Color.ORANGE);
                listGUI.add(header, BorderLayout.NORTH);

                JPanel body = new JPanel();
                JTable tab = null;
                try {
                    ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM ENROLMENTS;");
                    tab = new JTable(buildATable(rs));
                } catch (SQLException ex) {}

                JScrollPane scr = new JScrollPane(tab);
                body.add(scr);
                listGUI.add(body);

                listGUI.setTitle("Assessment Report");
            }
        }

        JPanel footer = new JPanel();

        JButton addCloseBtn = new JButton("Close");
        addCloseBtn.addActionListener((e) -> listGUI.dispose());

        footer.add(addCloseBtn);
        listGUI.add(footer, BorderLayout.SOUTH);

        listGUI.pack();
        listGUI.setVisible(true);
    }

    public static DefaultTableModel buildATable(ResultSet rs)
            throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // get column name of the table
        Vector<String> colNames = new Vector<>();
        int colCount = metaData.getColumnCount();
        for (int col = 1; col <= colCount; col++) {
            colNames.add(metaData.getColumnName(col));
        }

        // get data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int colIndex = 1; colIndex <= colCount; colIndex++) {
                vector.add(rs.getObject(colIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, colNames);
    }

    public static void main(String[] args) throws IOException, SQLException {
        new CourseManProg().createMainGUI();
    }
}

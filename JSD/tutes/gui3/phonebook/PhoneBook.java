package tutes.gui3.phonebook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class PhoneBook {
    JFrame gui = new JFrame("Phone Book");
    JFrame gui2 = new JFrame("Add Contact");
    JTable tbl;

    public PhoneBook() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        Object[][] data = new Object[0][2];
        
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create table
        String[] header = {"Name", "Phone"};

        // create table model
        DefaultTableModel tm = new DefaultTableModel(data, header);

        // create table
        tbl = new JTable(tm);

        // put table inside scroll pane
        JScrollPane tblScrollPane = new JScrollPane(tbl);

        // add to center region
        gui.add(tblScrollPane);

        JPanel bottom = new JPanel();
        JButton addContactBtn = new JButton("Add Contact");
        addContactBtn.addActionListener(new ShowContactGUI());
        bottom.add(addContactBtn);

        gui.add(bottom, BorderLayout.SOUTH);

        gui.pack();
        gui.setVisible(true);
    }

    private void createAndShowGUI2() {
        JPanel header = new JPanel();
        JLabel title = new JLabel("Enter details");
        header.add(title);
        gui2.add(header, BorderLayout.NORTH);

        JPanel body = new JPanel(new GridLayout(2, 2));

        body.add(new JLabel("Name"));
        JTextField name = new JTextField(20);
        body.add(name);

        body.add(new JLabel("Phone"));
        JTextField phone = new JTextField(20);
        body.add(phone);

        body.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gui2.add(body);

        JPanel footer = new JPanel();
        JButton addContactBtn = new JButton("Add");
        JButton addCancelBtn = new JButton("Cancel");

        addContactBtn.addActionListener(new Add(name, phone));
        addCancelBtn.addActionListener(new Cancel(name, phone));

        footer.add(addContactBtn);
        footer.add(addCancelBtn);
        gui2.add(footer, BorderLayout.SOUTH);

        gui2.pack();
        gui2.setVisible(true);
    }

    class ShowContactGUI implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createAndShowGUI2();
        }
    }

    class Add implements ActionListener {
        JTextField name;
        JTextField phone;

        public Add(JTextField name, JTextField phone) {
            this.name = name;
            this.phone = phone;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel tm = (DefaultTableModel) tbl.getModel();
            tm.addRow(new String[] {name.getText(), phone.getText()});

            name.setText("");
            phone.setText("");

            gui2.dispose();
        }
    }

    class Cancel implements ActionListener {
        JTextField name;
        JTextField phone;

        public Cancel(JTextField name, JTextField phone) {
            this.name = name;
            this.phone = phone;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            name.setText("");
            phone.setText("");

            gui2.dispose();
        }
    }

    public static void main(String[] args) {
        new PhoneBook();
    }
}

package tutes.gui4.phonebook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class PhoneBook {
    JFrame gui = new JFrame("Phone Book");
    JFrame gui2 = new JFrame("Add Contact");
    DefaultTableModel tm;

    private void createAndShowGUI() {
        Object[][] data = new Object[0][3];

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create table
        String[] header = {"Name", "Phone", ""};

        // create table model
        tm = new DefaultTableModel(data, header);

        // create table
        JTable tbl = new JTable(tm) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0 || column == 1) {
                    return String.class;
                } else {
                    return Boolean.class;
                }
            }
        };
        tbl.getColumnModel().getColumn(0).setPreferredWidth(200);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl.setPreferredScrollableViewportSize(new Dimension(350, 400));
        tbl.setFillsViewportHeight(true);
        tbl.setRowHeight(25);
        tbl.setFont(tbl.getFont().deriveFont(16.0f));

        // put table inside scroll pane
        JScrollPane tblScrollPane = new JScrollPane(tbl);

        // add to center region
        gui.add(tblScrollPane);

        JPanel bottom = new JPanel();

        JButton addContactBtn = new JButton("Add Contact");
        addContactBtn.addActionListener(new ShowContactGUI());
        bottom.add(addContactBtn);

        JButton checkAllBtn = new JButton("Check All");
        checkAllBtn.addActionListener(new CheckAllContact());
        bottom.add(checkAllBtn);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(new DeleteContact());
        bottom.add(deleteBtn);

        gui.add(bottom, BorderLayout.SOUTH);
        gui.pack();
        gui.setVisible(true);
    }

    private void createAndShowGUI2() {
        JPanel header = new JPanel();
        JLabel title = new JLabel("Enter details");
        header.add(title);
        gui2.add(header, BorderLayout.NORTH);

        JPanel body = new JPanel(new GridLayout(2, 3));

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

    class CheckAllContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < tm.getRowCount(); i++) {
                tm.setValueAt(true, i, 2);
            }
        }
    }

    class DeleteContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = tm.getRowCount()-1; i >= 0; i--) {
                if (tm.getValueAt(i, 2).equals(true))
                    tm.removeRow(i);
            }
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
        new PhoneBook().createAndShowGUI();
    }
}

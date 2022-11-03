package tutes.gui2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JFrame f;
    JTextField tf;
    double result;
    char lastOp;
    String currentText = "";

    public void createAndShowGUI(Calculator c) {
        // Set window
        f = new JFrame("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel window = new JPanel(new BorderLayout());
        JPanel body = new JPanel(new GridLayout(4, 4));

        // Set screen
        tf = new JTextField(8);
        tf.setFont(new Font("sans serif", Font.BOLD, 16));
        tf.setEditable(false);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        window.add(tf, BorderLayout.NORTH);

        // Set button
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("x");
        be = new JButton(".");
        beq = new JButton("=");

        b0.addActionListener(c);
        b1.addActionListener(c);
        b2.addActionListener(c);
        b3.addActionListener(c);
        b4.addActionListener(c);
        b5.addActionListener(c);
        b6.addActionListener(c);
        b7.addActionListener(c);
        b8.addActionListener(c);
        b9.addActionListener(c);
        ba.addActionListener(c);
        bs.addActionListener(c);
        bd.addActionListener(c);
        bm.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);

        body.add(b7);
        body.add(b8);
        body.add(b9);
        body.add(ba);
        body.add(b4);
        body.add(b5);
        body.add(b6);
        body.add(bs);
        body.add(b1);
        body.add(b2);
        body.add(b3);
        body.add(bm);
        body.add(b0);
        body.add(be);
        body.add(beq);
        body.add(bd);

        window.add(body, BorderLayout.SOUTH);

        // Define window
        f.add(window);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char c = e.getActionCommand().charAt(0);

        if (Character.isDigit(c) || c == '.') {
            currentText += c;
            tf.setText(currentText);
        } else if (c == '=') {
            if (lastOp == '+') {
                result += Double.parseDouble(currentText);
            } else if (lastOp == '-') {
                result -= Double.parseDouble(currentText);
            } else if (lastOp == 'x') {
                result *= Double.parseDouble(currentText);
            } else {
                result /= Double.parseDouble(currentText);
            }
            if ((result % 1) > 0) tf.setText(String.valueOf(result));
            else tf.setText(String.valueOf((int) result));
            currentText = "";
            lastOp = '\u0000';
        } else {
            result = Double.parseDouble(currentText);
            lastOp = c;
            currentText = "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Calculator c = new Calculator();
                c.createAndShowGUI(c);
            }
        });
    }
}

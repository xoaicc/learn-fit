package tutes.gui2;

import javax.swing.*;
import java.awt.*;

public class Ex2 extends JFrame {
    public void createAndShowGUI() {
        JLabel title = new JLabel("Welcome to Java");
        title.setPreferredSize(new Dimension(450, 45));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel body = new JPanel(new GridLayout(2, 2));
        body.add(new JLabel("Name"));
        body.add(new JTextField(20));
        body.add(new JLabel("Address"));
        body.add(new JTextField(20));
        body.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(body);

        JPanel footer = new JPanel();
        footer.add(new JButton("OK"));
        footer.add(new JButton("Cancel"));
        add(footer, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ex2().createAndShowGUI();
            }
        });
    }
}

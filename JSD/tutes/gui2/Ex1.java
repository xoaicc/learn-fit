package tutes.gui2;

import javax.swing.*;
import java.awt.*;

public class Ex1 extends JFrame {
    JComponent[] comps;
    String[] regions = {
            BorderLayout.NORTH,
            BorderLayout.WEST,
            BorderLayout.EAST,
            BorderLayout.SOUTH
    };
    JPanel body;
    LayoutManager[] layouts = new LayoutManager[] {
            new FlowLayout(),
            new BorderLayout(),
            new GridLayout(2, 2)
    };
    int currentLayout = 0;

    public void createAndShowGUI() {
        body = new JPanel();
        comps = new JComponent[4];
        for (int i = 0; i < comps.length; i++) {
            comps[i] = new JButton("Button " + (i + 1));
            body.add(comps[i]);
        }
        JPanel footer = new JPanel();
        JButton switchBtn = new JButton("Switch Layout");
        switchBtn.addActionListener(e -> {
            switchLayout();
        });
        footer.add(switchBtn);

        add(body);
        add(footer, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    private void switchLayout() {
        currentLayout = (currentLayout + 1) % 3;
        LayoutManager next = layouts[currentLayout];
        body.setLayout(next);
        if (next instanceof BorderLayout) {
            body.removeAll();
            for (int i = 0; i < comps.length; i++) {
                body.add(comps[i], regions[i]);
            }
        }
        validate();
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ex1().createAndShowGUI();
            }
        });
    }
}
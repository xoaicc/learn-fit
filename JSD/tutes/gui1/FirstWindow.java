package tutes.gui1;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstWindow extends JFrame {
    // default width and length of the window
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public FirstWindow() {
        super();
        setSize(WIDTH, HEIGHT);

        setTitle("First Window Class");

        // handle window closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
            }
        });
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // create a button
        JButton endButton = new JButton("Click to end program.");

        // handle action event of the button
        endButton.addActionListener(new EndingListener());

        // add button to default position on window (centre)
        add(endButton);
        // add button to the top of the window
        add(endButton, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        // create a window
        FirstWindow w = new FirstWindow();

        // display it
        w.setVisible(true);
    }
}

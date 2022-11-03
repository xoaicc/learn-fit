package tutes.gui1;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// a simple action event listener that ends the program
public class EndingListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // end program
        System.exit(0);
    }
}

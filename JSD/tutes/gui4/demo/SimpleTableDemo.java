package tutes.gui4.demo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class SimpleTableDemo extends JPanel {
    private final boolean DEBUG = true;

    public SimpleTableDemo() {
        super(new GridLayout(1, 1));

        String[] head = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith", "Snowboarding", 5, false},
                {"John", "Doe", "Rowing", 3, true},
                {"Sue", "Black", "Knitting", 2, false},
                {"Jane", "White", "Speed reading", 20, true},
                {"Joe", "Brown", "Pool", 10, false}};

        JTable table = new JTable(data, head);
        // set view port size to table's preferred size to remove extra spaces in the otherwise default view port
        Dimension viewPortSize = table.getPreferredSize();
        table.setPreferredScrollableViewportSize(viewPortSize);
        table.setFillsViewportHeight(false);
        table.setRowHeight(28);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        table.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        // Create the scroll pane and add the table to it.
        // Add the scroll pane to this panel.

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));

        // set up initial column widths based on data
        initColumnSizes(table);

        add(scrollPane);
    }

    private void initColumnSizes(JTable table) {
        TableModel model = table.getModel();
        TableColumn column;
        Component comp;
        int headerWidth;
        int cellWidth;

        TableCellRenderer headerRenderer = table.getTableHeader()
                .getDefaultRenderer();

        int rc = model.getRowCount();
        Object val;
        String longValue = null;
        final int gap = 10;

        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);

            comp = headerRenderer.getTableCellRendererComponent(null,
                    column.getHeaderValue(), false, false, 0, 0);
            headerWidth = comp.getPreferredSize().width;

            // get the longest value of this column
            for (int j = 0; j < rc; j++) {
                val = model.getValueAt(j, i);
                if (longValue == null || longValue.length() < val.toString().length()) {
                    longValue = val.toString();
                }
            }

            // get the width of the longest value
            comp = table.getDefaultRenderer(model.getColumnClass(i))
                    .getTableCellRendererComponent(table, longValue, false, false, 0,
                            i);

            cellWidth = comp.getPreferredSize().width + gap;

            if (DEBUG) {
                System.out.println("Initializing width of column " + i + ". "
                        + "headerWidth = " + headerWidth + "; cellWidth = " + cellWidth);
            }
            // set the column width to the max of cell width and header width
            column.setPreferredWidth(Math.max(headerWidth, cellWidth));

            longValue = null;
        }
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        SimpleTableDemo newContentPane = new SimpleTableDemo();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(SimpleTableDemo::createAndShowGUI);
    }
}

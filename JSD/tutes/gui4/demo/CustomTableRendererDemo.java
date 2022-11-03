package tutes.gui4.demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

public class CustomTableRendererDemo extends JPanel {

    public CustomTableRendererDemo() {
        super(new GridLayout(1, 0));

        String[] head = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith", "Snowboarding", 5, false},
                {"John", "Doe", "Rowing", 3, true},
                {"Sue", "Black", "Knitting", 2, false},
                {"Jane", "Speed reading to be or not to be", "White is a colour", 20, true},
                {"Joe", "Brown", "Pool", 10, false}};

        JTable table = new JTable(data, head);
        // customise the cell renderer
        WrappableCellRenderer renderer = new WrappableCellRenderer();

        // use this to change the default renderer
        table.setDefaultRenderer(String.class, renderer);
        table.setDefaultRenderer(Object.class, renderer);
        table.setDefaultRenderer(Number.class, renderer);
        table.setDefaultRenderer(Boolean.class, renderer);

        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setCellSelectionEnabled(true);

        table.setFillsViewportHeight(false);

        // Create the scroll pane and add the table to it.
        // Add the scroll pane to this panel.
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }

    /**
     * @overview
     *  A <tt>TableCellRenderer</tt> that supports text wrapping
     */
    private static class WrappableCellRenderer
            extends JTextArea
            implements TableCellRenderer {

        private static final Border LINE_BORDER =
                BorderFactory.createLineBorder(Color.RED, 2);
        private static final Border EMPTY_BORDER =
                BorderFactory.createEmptyBorder(2, 2, 2, 2);

        // record the row heights
        Map<Integer, MaxHeight> heights;

        // user a panel with border layout to
        // expand the text area automatically
        private final JPanel panel;

        public WrappableCellRenderer() {
            super();
            setLineWrap(true);
            // change the layout to default FlowLayout to see the difference
            panel = new JPanel(new BorderLayout());
            panel.add(this);

            heights = new HashMap<>();
        }

        /**
         * @overview
         *  A helper class to record the current maximum height of a given table row.
         *  This height is determined based on the preferred size of the
         *  cell render when it is set to hold the value of a given column of the row.
         *  It is used to set the row height.
         */
        private static class MaxHeight {
            int rowIndex;
            int columnIndex;
            int height;

            MaxHeight(int row, int column, int height) {
                columnIndex = column;
                rowIndex = row;
                this.height = height;
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {

            if (value != null)
                setText(value.toString());

            if (isSelected) {
                setBorder(LINE_BORDER);
            } else {
                setBorder(EMPTY_BORDER);
            }

            int myHeight = getPreferredSize().height;
            setSize(table.getColumnModel().getColumn(column).getWidth(), myHeight);

            // adjust table height if necessary
            MaxHeight rowHeight = heights.get(row);

            if (rowHeight == null) {
                rowHeight = new MaxHeight(row, column, myHeight);
                heights.put(row, rowHeight);
                table.setRowHeight(row, myHeight);
            } else if (rowHeight.height < myHeight) {
                // new max height
                rowHeight.columnIndex = column;
                rowHeight.height = myHeight;
                table.setRowHeight(row, myHeight);
            }

            return panel;
        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("CustomTableRendererDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        CustomTableRendererDemo newContentPane = new CustomTableRendererDemo();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(CustomTableRendererDemo::createAndShowGUI);
    }
}

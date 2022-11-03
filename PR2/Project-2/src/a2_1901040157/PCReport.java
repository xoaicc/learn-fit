package a2_1901040157;

/**
 * @overview Displays a text-based tabular report on some {@link PC} objects.
 */
public class PCReport {
    /**
     * @effects <pre>
     *          generate and return a tabular report about PC objects in this.
     *
     *          <p>
     *          The report header is shown in the middle of the 1st line.
     *
     *          <p>
     *          The column widths are calculated based on the attribute lengths such
     *          that the cell values are properly aligned with the columns and are
     *          displayed right-justified. Further, cells on same row are at least
     *          one space apart from each other.
     *
     *          <p>
     *          e.g.<br>
     *          ---------------------------------------------------------------------------------------------------
     *                                                      PCPROG REPORT
     *          ---------------------------------------------------------------------------------------------------
     *            1   Thinkpad X1 Carbon   2022         Lenovo [AMD Ryzen 5, 8GB DDR4, 512GB SSD, NVIDIA MX450]
     *          ---------------------------------------------------------------------------------------------------
     *      </pre>
     */
    public String displayReport(PC[] objs) {
        int column1 = 3, column2 = 20, column3 = 6, column4 = 15, column5 = 50;
        int totalColNum = column1 + column2 + column3 + column4 + column5 + 4;
        String dashLine = ("-------------------------------------------------------------------------------------------------------\n");
        String Header = ("PCPROG REPORT");
        StringBuilder report = new StringBuilder();
        report.append(dashLine);
        report.append(String.format("%" + (int) (0.5 * (totalColNum + Header.length())) + "s \n", Header));
        report.append(dashLine);

        for (int i=0; i<objs.length; i++) {
            report.append(String.format("%3s %20s %6d %15s %-50s \n", i, objs[i].getModel(),
                    objs[i].getYear(), objs[i].getManufacture(), objs[i].getComps().getElements()));
        }

        report.append(dashLine);
        System.out.println(report);
        return report.toString();
    }
}

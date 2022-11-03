package a2_1901040247;

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
        String HEADER = "PCPROG REPORT";
        String BREAKLINE = "-";

        for (int i=1; i<99; i++) { BREAKLINE += "-"; }
        BREAKLINE += "\n";

        StringBuilder rp = new StringBuilder();
        rp.append(BREAKLINE);
        rp.append(String.format("%" + (int) (0.5 * (99 + HEADER.length())) + "s %n", HEADER));
        rp.append(BREAKLINE);

        int no = 1;
        for (PC pc : objs) rp.append(String.format("%3s %20s %6d %15s %-50s %n", (no++), pc.getModel(),
                            pc.getYear(), pc.getManufacture(), pc.getComps().getElements()));

        rp.append(BREAKLINE);
        System.out.println(rp);
        return rp.toString();
    }
}

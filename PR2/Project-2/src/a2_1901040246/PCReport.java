package a2_1901040246;

/**
 * @author LeThiCuc
 * @overview Displays a text-based tabular report on some {@link PC} objects.
 */
public class PCReport {
    /**
     * @effects return the string of all pcs in report form
     */
    public String displayReport(PC[] pcs) {

        StringBuilder str = new StringBuilder();
        str.append(
                "---------------------------------------------------------------------------------------------------\n");
        str.append(String.format("%57s", "PCPROG REPORT\n"));
        str.append(
                "---------------------------------------------------------------------------------------------------\n");
        int cont = 1;
        for (int i = 0; i < pcs.length; i++) {

            str.append(String.format("%3s", cont) + " " + String.format("%20s", pcs[i].getModel()) + " "
                    + String.format("%6s", pcs[i].getYear()) + " " + String.format("%15s", pcs[i].getManufacturer()) + " "
                    + String.format("%-50s", pcs[i].getComps().getElements()) + "\n");

            str.append(
                    "---------------------------------------------------------------------------------------------------\n");
            cont++;

        }
        System.out.println(str);
        return str.toString();
    }
}

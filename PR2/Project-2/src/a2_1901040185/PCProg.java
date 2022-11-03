package a2_1901040185;

import static utils.TextIO.getln;
import static utils.TextIO.getlnInt;
import static utils.TextIO.putln;
import static utils.TextIO.writeFile;
import static utils.TextIO.writeStandardOutput;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

import java.util.Vector;


/**
 * @overview PCProg is a program that captures data about PC objects
 *    and displays a report about them on the console.
 *
 * @attributes
 *  objs  Set<PC>
 *
 * @object
 *  A typical PCProg is {c1,...,cn} where c1,...,cn are pcs
 *
 * @abstract_properties
 *  mutable(objs)=true /\ optional(objs)=false
 */
public class PCProg {
  @DomainConstraint(mutable=true,optional=false)
  private Set<PC> objs;

  /**
   * @effects
   *  initialise this to have an empty set of PCs
   */
  public PCProg() {
    objs = new Set<>();
  }

  /**
   * @effects <pre>
   *      create a PC object, the program first prompts the user for the required data values,
   *      once the data values have been obtained, the program creates a new PC object and add
   *      it to a set. This set is an object of the Set class. The program then asks the user
   *      if (s)he wishes to continue (the answer of which must be either “Y” or “N”). If the
   *      user answers “Y”, the program repeats to create the next PC object. If, however, the
   *      user responds with “N”, the program proceeds to displaying a report about the PC objects.
   * </pre>
   */
  public void createObjects() {
    String opt1;
    do {
      putln("Enter model: ");
      String model = getln();

      putln("Enter year: ");
      int year = getlnInt();

      putln("Enter manufacturer: ");
      String manufacturer = getln();

      Set<String> comps = new Set<>();
      String opt2;
      do {
        putln("Enter component: ");
        String acp = getln();
        if (!comps.isIn(acp)) {
          comps.insert(acp);
        } else {
          System.err.println("Overlapping component!");
        }

        putln("Enter another component? [Y/N]");
        opt2 = getln();
      } while (opt2.equals("Y"));

      PCFactory.getInstance();
      PC apc = PCFactory.createPC(model, year, manufacturer, comps);

      if (apc.repOK()) {
        objs.insert(apc);
      }

      putln("Create another PC? [Y/N]");
      opt1 = getln();
    }
    while (opt1.equals("Y"));
  }

  /**
   *
   * @effects
   *  return the recorded PC objects
   */
  @DOpt(type = OptType.Observer)
  @AttrRef("objs")
  public Set<PC> getObjects() {
    return objs;
  }

  /**
   * @effects
   *  if objs is not empty
   *    display to the standard console a text-based tabular report on objs
   *    return this report
   *  else
   *    display nothing and return null
   */
  public String displayReport() {
    if (objs.size() > 0) {
      Vector<PC> pcs = objs.getElements();

      PCReport reportObj = new PCReport();
      return reportObj.displayReport(pcs.toArray(new PC[pcs.size()]));
    } else {
      return null;
    }
  }

  /**
   * @effects
   *  save report to a file pcs.txt in the same directory
   *  as the program's
   */
  public void saveReport(String report) {
    String fileName = "pcs.txt";
    writeFile(fileName);
    putln(report);
    writeStandardOutput();
  }

  /**
   * The run method
   * @effects
   *  initialise an instance of PCProg
   *  create objects from data entered by the user
   *  display a report on the objects
   *  prompt user to save report to file
   *  if user answers "Y"
   *    save report
   *  else
   *    end
   */
  public static void main(String[] args) {
    //
    PCProg prog = new PCProg();

    // create objects
    try {
      prog.createObjects();

      // display report
      String report = prog.displayReport();

      if (report != null) {
        // prompt user to save report
        putln("Save report to file? [Y/N]");
        String toSave = getln();
        if (toSave.equals("Y")) {
          prog.saveReport(report);
          putln("report saved");
        }
      }
    } catch (NotPossibleException e) {
      System.err.printf("%s: %s%n", e, e.getMessage());
    }

    putln("~END~");
  }
}
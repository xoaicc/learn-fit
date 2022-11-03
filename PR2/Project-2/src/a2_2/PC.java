package a2_2;

import utils.*;

import java.util.Objects;
import java.util.Vector;

/**
 * @overview A personal computer (PC) is a multi-purpose computer whose size,
 *           capabilities, and price make it feasible for individual use.
 * @attributes <pre>
 * 		model     		String
 * 		year 	        Integer
 * 		manufacturer 	String
 * 	    comps 	        Set<String>
 *    </pre>
 * @object A typical PC is c=<m, y, mf, cs>, where m(model),
 * y(year), mf(manufacturer), cs(comps).
 * @abstract_properties <pre>
 * 		mutable(model) = true /\ optional(model) = false /\ length(model) = 20 /\
 * 		mutable(year) = false /\ optional(year) = false /\ min(year) = 1984 /\
 * 		mutable(manufacturer) = false /\ optional(manufacturer) = false /\ length(manufacturer) = 15 /\
 * 	    mutable(comps) = true /\ optional(comps) = false
 *    </pre>
 */
public class PC {

    // constants
    private static final int LEN_MODEL = 20;
    private static final int LEN_MANUFACTURER = 15;
    private static final int MIN_YEAR = 1984;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = LEN_MODEL)
    private String model;

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_YEAR)
    private int year;

    @DomainConstraint(type = "String", mutable = false, optional = false, length = LEN_MANUFACTURER)
    private String manufacturer;

    @DomainConstraint(type = "Set<String>", mutable = true, optional = false)
    private Set<String> comps;

    // constructor methods
    public PC(@AttrRef("model") String model, @AttrRef("year") int year,
              @AttrRef("manufacturer") String manufacturer, @AttrRef("comps") Set<String> comps)
            throws NotPossibleException {
        if (!validateModel(model))
            throw new NotPossibleException("PC.init invalid model: " + model);
        if (!validateYear(year))
            throw new NotPossibleException("PC.init invalid year: " + year);
        if (!validateManufacturer(manufacturer))
            throw new NotPossibleException("PC.init invalid manufacturer: " + manufacturer);
        if (!validateComps(comps))
            throw new NotPossibleException("PC.init invalid comps: " + comps);
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.comps = new Set<>();
        Vector<String> stringObjs = comps.getElements();
        for (String s : stringObjs)
            this.comps.insert(s);
    }

    // helper
    /**
     * @effects <pre>
     *      if model is valid
     *          return true
     *      else
     *          return false
     *  </pre>
     */
    private boolean validateModel (String model) {
        return (model != null && model.length() > 0 && model.length() <= LEN_MODEL);
    }

    /**
     * @effects <pre>
     *      if year is valid
     *          return true
     *      else
     *          return false
     *  </pre>
     */
    private boolean validateYear (int year) {
        return (year >= MIN_YEAR);
    }

    /**
     * @effects <pre>
     *      if manufacturer is valid
     *          return true
     *      else
     *          return false
     *  </pre>
     */
    private boolean validateManufacturer (String manufacturer) {
        return (manufacturer != null && manufacturer.length() > 0 && manufacturer.length() <= LEN_MANUFACTURER);
    }

    /**
     * @effects <pre>
     *      if comps is valid
     *          return true
     *      else
     *          return false
     *  </pre>
     */
    private boolean validateComps (Set<String> comps) {
        if (comps == null || (!comps.repOK()) || comps.size() == 0) {
            return false;
        }
        Vector<String> compsElements = comps.getElements();
        for (int i = 0; i < comps.size(); i++) {
            if (compsElements.get(i) == null ||
                    compsElements.get(i).length() == 0 ||
                    compsElements.get(i).equals(" ")) {
                return false;
            }
        }
        return true;
    }

    // mutator
    /**
     * @effects
     *
     *          <pre>
     *   if model is valid
     *     set this.model=model
     *     return true
     *   else
     *     return false
     *          </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("model")
    public boolean setModel (String model) {
        if (validateModel(model)) {
            this.model = model;
            return true;
        }
        return false;
    }

    /**
     * @effects <pre>
     *      if comps is valid
     *          set this.comps = new Set
     *          for each element in comps
     *     		    add element to this.comps
     *          return true
     *      else
     *          return false
     * </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("comps")
    public boolean setComps (Set<String> comps) {
        if (validateComps(comps)) {
            this.comps = new Set<>();
            Vector<String> str = comps.getElements();
            for (String s : str) {
                this.comps.insert(s);
            }
            return true;
        } else {
            return false;
        }
    }

    // observer
    /**
     * @effects return <tt>model</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("model")
    public String getModel () {
        return this.model;
    }

    /**
     * @effects return <tt>year</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("year")
    public int getYear () {
        return this.year;
    }

    /**
     * @effects return <tt>manufacturer</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("manufacturer")
    public String getManufacture () {
        return this.manufacturer;
    }

    /**
     * @effects return <tt>comps</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("comps")
    public Set<String> getComps () {
        Set<String> comps = new Set<>();
        Vector<String> stringObjs = this.comps.getElements();
        for (String s : stringObjs) {
            comps.insert(s);
        }
        return comps;
    }

    // default
    @Override
    @DOpt(type = OptType.Default)
    public String toString () {
        return "PC: <" + model + "," + year + "," + manufacturer + "," + comps.toString() + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PC))
            return false;
        PC pc = (PC) o;
        return year == pc.year && Objects.equals(model, pc.model) &&
                Objects.equals(manufacturer, pc.manufacturer) &&
                Objects.equals(comps, pc.comps);
    }

    // representation OK
    /**
     * @effects <pre>
     *      if this satisfies abstract properties
     *          return true
     *      else
     *          return false
     * </pre>
     */
    public boolean repOK() {
        return validateModel(model) && validateYear(year) && validateManufacturer(manufacturer) && validateComps(comps);
    }
}

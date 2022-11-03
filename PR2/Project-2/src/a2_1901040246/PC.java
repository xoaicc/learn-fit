package a2_1901040246;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @author LeThiCuc
 * @overview Illustrate an unique PC
 * @attributes model String year Integer manufacturer String comps Set
 * @object A typical PC is PC = <ml,yr,mr,cs> where model(ml), year(yr),
 * manufacturer(mr), comps(cs).
 * @abstract_properties mutable(model)=true /\ optional(model)=false /\
 * length(model)=20 /\ mutable(year)=false /\
 * optional(year)=false /\ min(year)=1984/\
 * mutable(manufacturer)=false /\
 * optional(manufacturer)=false /\ length(manufacturer)=15
 * /\ mutable(comps)=true /\ optional(comps)=false
 */
public class PC {
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 20)
    private String model;
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1984)
    private final int year;
    @DomainConstraint(type = "String", mutable = false, optional = false, length = 15)
    private final String manufacturer;
    @DomainConstraint(type = "Set", mutable = true, optional = false)
    private Set<String> comps;

    /**
     * @effects          <pre>
     *
     *  if model, year, manufacturer, comps are valid
     *    initialize this as <model, year, manufacturer, comps>
     *  else
     *    initialize this as <> and print error
     *          </pre>
     */
    public PC(@AttrRef("model") String model, @AttrRef("year") int year, @AttrRef("manufacturer") String manufacturer, @AttrRef("comps") Set<String> comps) {
        if (!validateModel(model))
        {
            throw new NotPossibleException("Invalid PC  model: " + model);
        }
        if (!validateYear(year))
        {
            throw new NotPossibleException("Invalid PC  year: " + year);
        }
        if (!validateManufacturer(manufacturer))
        {
            throw new NotPossibleException("Invalid PC  manufacturer: " + manufacturer);
        }
        if (!validateComps(comps))
        {
            throw new NotPossibleException("Invalid PC  comps: " + comps);
        }
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.comps = comps;
    }

    /**
     * @effects return <tt>model</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("model")
    public String getModel() {
        return model;
    }

    /**
     * @effects return <tt>year</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("year")
    public int getYear() {
        return year;
    }

    /**
     * @effects return <tt>manufacturer</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @effects          <pre>
     * if model is valid
     * 	set this.model=model
     * 		return true
     * 	else
     * 		return false
     *          </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("model")
    public boolean setModel(String model) {
        if (validateModel(model)) {
            this.model = model;
            return true;
        } else return false;

    }

    /**
     * @effects return <tt>comps</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("comps")
    public Set<String> getComps() {
        return comps;
    }

    /**
     * @effects          <pre>
     * if comps is valid
     * 	set this.comps=comps
     * 		return true
     * 	else
     * 		return false
     *          </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("comps")
    public boolean setComps(Set<String> comps) {
        if (validateComps(comps)) {
            this.comps = comps;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @effects          <pre>
     *   if model is valid
     *     return true
     *   else
     *     return false
     *          </pre>
     */
    private boolean validateModel(String model) {
        return (model != null && model.length() > 0 && model.length() <= 20);
    }

    /**
     * @effects          <pre>
     *   if year is valid
     *     return true
     *   else
     *     return false
     *          </pre>
     */
    private boolean validateYear(int year) {
        return year >= 1940;
    }

    /**
     * @effects          <pre>
     *   if manufacturer is valid
     *     return true
     *   else
     *     return false
     *          </pre>
     */
    private boolean validateManufacturer(String manufacturer) {
        return (manufacturer != null && manufacturer.length() > 0 && manufacturer.length() <= 20);
    }

    /**
     * @effects          <pre>
     *   if comps is valid
     *     return true
     *   else
     *     return false
     *          </pre>
     */
    private boolean validateComps(Set<String> comps) {
        return (comps != null && comps.size() > 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PC other = (PC) obj;
        if (comps == null) {
            if (other.comps != null)
                return false;
        } else if (!comps.equals(other.comps))
            return false;
        if (manufacturer == null) {
            if (other.manufacturer != null)
                return false;
        } else if (!manufacturer.equals(other.manufacturer))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
		return year == other.year;
	}

    /**
     * @effects          <pre>
     *   if this satisfies abstract properties
     *     return true
     *   else
     *     return false
     *          </pre>
     */
    public boolean repOK() {
        return validateModel(model) && validateYear(year) && validateManufacturer(manufacturer) && validateComps(comps);
    }

    @Override
    public String toString() {
        return String.format("PC:<%s,%d,%s,%s>", model, year, manufacturer, comps.toString());
    }
}

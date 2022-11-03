package Tut08.b;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview MobilePhone are device with which we have relationships.
 * @attributes
 * manName    String
 * model      String
 * color      Character   char
 * year       Integer     int
 * guaranteed boolean
 * @object A typical MobilePhone is c=<n,m,c,y,g>, where manName(n), model(m), color (c), year(y), guaranteed(g).
 * @abstract_properties
 * mutable(manName)=true /\ optional(id)=false /\ length(manName)=50
 * mutable(model)=true /\ optional(name)=false /\ length(model)=50
 * mutable(color)=true /\ optional(id)=false
 * mutable(year)=true /\ optional(name)=false /\ min(year)=1975
 * mutable(guaranteed)=true /\ optional(id)=false
 * @author xoaic
 */
public class MobilePhone {
    // STATE SPACE
    @DomainConstraint(type="String", mutable=true, optional=false, length=50)
    private String manName;

    @DomainConstraint(type="String", mutable=true, optional=false, length=50)
    private String model;

    @DomainConstraint(type="Character", mutable=true, optional=false)
    private char color;

    @DomainConstraint(type="Integer", mutable=true, optional=false, min=1975)
    private int year;

    @DomainConstraint(type="boolean", mutable=true, optional=false)
    private boolean guaranteed;

    // BEHAVIOR SPACE
    /**
     * @effects
     *   if manName, model are valid
     *      initialise this as <n,m,c,y,g>
     *   else
     *      throws NotPossibleException
     */
    public MobilePhone(@AttrRef("manName")String manName, @AttrRef("model")String model, @AttrRef("color")char color, @AttrRef("year")int year, @AttrRef("guaranteed")boolean guaranteed) throws NotPossibleException {
        this.manName = manName;
        this.model = model;
        this.color = color;
        this.year = year;
        this.guaranteed = guaranteed;
        if (!repOK())
            throw new NotPossibleException("invalid input!");
    }

    /**
     * @effects
     *   if name is valid
     *      set name to this.manName
     *   else
     *      throws NotPossibleException
     */
    @DOpt(type=OptType.Mutator) @AttrRef("manName")
    public void recordName(String name) {
        if (validateName(manName)) this.manName = manName;
        else throw new NotPossibleException("invalid name!");
    }

    /**
     * @effects
     *   if model is valid
     *      set model to this.model
     *   else
     *      throws NotPossibleException
     */
    @DOpt(type=OptType.Mutator) @AttrRef("model")
    public void setModel(String model) {
        if (validateModel(model)) this.model = model;
        else
            throw new NotPossibleException("invalid model!");
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "manName='" + manName + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                ", year=" + year +
                ", guaranteed=" + guaranteed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    /**
     * @effects
     *   if name contains an invalid character
     *      return false
     *   else
     *      return true
     */
    public boolean validateName(String name) {
        for (char c : name.toLowerCase().toCharArray()) {
            if (((int)c < 97 || (int)c > 122)) return false;
        }
        return true;
    }

    /**
     * @effects
     *   if name contains an invalid character or number
     *      return false
     *   else
     *      return true
     */
    public boolean validateModel(String model) {
        for (char c : model.toLowerCase().toCharArray()) {
            if ((int)c > 122) return false;
            if (((int)c < 97) && ((int)c > 57)) return false;
            if ((int)c < 48) return false;
        }
        return true;
    }

    /**
     * @effects
     *   if id, name are valid
     *      return true
     *   else
     *      return false
     */
    public boolean repOK() {
        return validateName(manName) && validateModel(model);
    }
}

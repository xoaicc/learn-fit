package Tut07.b;

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
    public MobilePhone(@AttrRef("manName")String manName, @AttrRef("model")String model, @AttrRef("color") char color, @AttrRef("year") int year, @AttrRef("guaranteed") boolean guaranteed) throws NotPossibleException {
        this.manName = manName;
        this.model = model;
        this.color = color;
        this.year = year;
        this.guaranteed = guaranteed;
    }

    /**
     * @effects
     * if name is valid
     * set this.manName to manName
     * return true
     * else
     * return false
     */
    @DOpt(type=OptType.Mutator) @AttrRef("manName")
    public void recordName(String manName) {
        this.manName = manName;
    }

    /**
     * @effects
     * if name is valid
     * set this.model to model
     * return true
     * else
     * return false
     */
    @DOpt(type=OptType.Mutator) @AttrRef("model")
    public void setModel(String model) {
        this.model = model;
    }
}

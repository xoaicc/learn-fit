package Tut07.b;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview A person have relationships.
 * @attributes
 * id        Integer          int
 * name      String
 * @object A typical Person is c=<d,n>, where id(d), name(n).
 * @abstract_properties
 * mutable(id)   = false /\ optional(id)  = false /\ min(id)=1
 * mutable(name) = true  /\ optional(name)= false /\ length(name)=50
 * @author xoaic
 */
public class Person {
    // STATE SPACE
    @DomainConstraint(type="Integer", mutable=false, optional=false, min=1)
    private int id;

    @DomainConstraint(type="String", mutable=true, optional=false, length=50)
    private String name;

    // BEHAVIOR SPACE
    public Person (@AttrRef("id") int id, @AttrRef("name") String name) throws NotPossibleException {
        this.id = id;
        this.name = name;
    }

    /**
     * @effects
     * if name is valid
     * set this.name to name
     * return true
     * else
     * return false
     */
    @DOpt(type=OptType.Mutator) @AttrRef("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @effects return greet message
     */
    public String greet() {
        return "Hello, " + this.name + "! Your info is in our system.";
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    /**
     * @effects
     * if this satisfies abstract properties
     * return true
     * else
     * return false
     */
    public boolean repOK() {
        return true;
    }
}

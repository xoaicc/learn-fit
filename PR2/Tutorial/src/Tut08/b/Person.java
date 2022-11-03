package Tut08.b;

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
    /**
     * @effects
     *   if id, name are valid
     *      initialise this as <id, name>
     *   else
     *      throws NotPossibleException
     */
    public Person (@AttrRef("id") int id, @AttrRef("name") String name) {
        this.id = id;
        this.name = name;
        if (!repOK())
            throw new NotPossibleException("invalid input!");
    }

    /**
     * @effects
     *   if name is valid
     *      set name to this.name
     *   else
     *      throws NotPossibleException
     */
    @DOpt(type=OptType.Mutator) @AttrRef("name")
    public void setName(String name) {
        if (validateName(name)) this.name = name;
        else throw new NotPossibleException("invalid name!");
    }

    /**
     * @effects return greeting message
     */
    public String greet() {
        return "Hello, " + name + "! Your info is in our system.";
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    /**
     * @effects
     *   if id > 0
     *      return true
     *   else
     *      return false
     */
    public boolean validateId(int id) {
        return id > 0;
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
     *   if id, name are valid
     *      return true
     *   else
     *      return false
     */
    public boolean repOK() {
        return validateId(id) && validateName(name);
    }
}

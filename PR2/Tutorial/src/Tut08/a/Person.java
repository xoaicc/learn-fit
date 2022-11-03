package Tut08.a;

import utils.*;

/**
 * @overview A person have relationships.
 * @attributes
 * id        Integer          int
 * name      String
 * phone     Mobile Phone
 * @object A typical Person is c=<d,n,p>, where id(d), name(n), phone(p).
 * @abstract_properties
 * mutable(id)   = false /\ optional(id)  = false /\ min(id)=1
 * mutable(name) = true  /\ optional(name)= false /\ length(name)=50
 * mutable(phone)= true  /\ optional(phone)=false /\
 * @author xoaic
 */
public class Person {
    // STATE SPACE
    @DomainConstraint(type="Integer", mutable=false, optional=false, min=1)
    private int id;

    @DomainConstraint(type="String", mutable=true, optional=false, length=50)
    private String name;

    @DomainConstraint(type="MobilePhone", mutable=true, optional=false)
    private MobilePhone phone;

    // BEHAVIOR SPACE
    /**
     * @effects
     *   if id, name are valid
     *      initialise this as <id, name, phone>
     *   else
     *      throws NotPossibleException
     */
    public Person(@AttrRef("id") int id, @AttrRef("name") String name, MobilePhone phone) throws NotPossibleException {
        this.id = id;
        this.name = name;
        this.phone = phone;
        if (!repOK())
            throw new NotPossibleException("invalid input!");
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
                ", phone=" + phone +
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

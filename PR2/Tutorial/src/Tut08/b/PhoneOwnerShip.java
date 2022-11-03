package Tut08.b;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview PhoneOwner connects Person and MobilePhone.
 * @attributes
 * owner      Person
 * phone      MobilePhone
 * @object A typical Person is c=<o,p>, where owner(o), phone(p).
 * @abstract_properties
 * mutable(owner) = false /\ optional(owner)= false
 * mutable(phone) = false /\ optional(phone)= false
 * @author xoaic
 */
public class PhoneOwnerShip {
    // STATE SPACE
    @DomainConstraint(type="Person", mutable=false, optional=false)
    private Person owner;

    @DomainConstraint(type="MobilePhone", mutable=false, optional=false)
    private MobilePhone phone;

    // BEHAVIOR SPACE
    /**
     * @effects
     *   if owner, phone are valid
     *      initialise this as <o,p>
     *   else
     *      throws NotPossibleException
     */
    public PhoneOwnerShip(@AttrRef("owner") Person owner, @AttrRef("phone") MobilePhone phone) throws NotPossibleException {
        this.owner = owner;
        this.phone = phone;
        if (!repOK())
            throw new NotPossibleException("invalid input!");
    }

    /**
     * @effects
     *   if owner is valid
     *      set owner to this.owner
     *   else
     *      throws NotPossibleException
     */
    @DOpt(type=OptType.Mutator) @AttrRef("owner")
    public void setOwner(Person owner) {
        if (validateOwner(owner)) this.owner = owner;
        else throw new NotPossibleException("invalid owner!");
    }

    @Override
    public String toString() {
        return "Owner: " + owner.toString() + ", Phone: " + phone.toString();
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    /**
     * @effects
     *   if phone is valid
     *      set phone to this.phone
     *   else
     *      throws NotPossibleException
     */
    @DOpt(type=OptType.Mutator) @AttrRef("phone")
    public void setPhone(MobilePhone phone) {
        if (validatePhone(phone)) this.phone = phone;
        else throw new NotPossibleException("invalid phone!");
    }

    public boolean validateOwner(Person owner) {
        return true;
    }

    public boolean validatePhone(MobilePhone phone) {
        return true;
    }

    public boolean repOK() {
        return validateOwner(owner) && validatePhone(phone);
    }
}

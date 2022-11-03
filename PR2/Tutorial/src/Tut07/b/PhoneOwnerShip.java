package Tut07.b;

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

    public PhoneOwnerShip(@AttrRef("owner") Person owner, @AttrRef("phone") MobilePhone phone) throws NotPossibleException {
        this.owner = owner;
        this.phone = phone;
    }

    /**
     * @effects
     * if name is valid
     * set this.owner to owner
     * return true
     * else
     * return false
     */
    @DOpt(type=OptType.Mutator) @AttrRef("owner")
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     * @effects
     * if name is valid
     * set this.phone to phone
     * return true
     * else
     * return false
     */
    @DOpt(type=OptType.Mutator) @AttrRef("phone")
    public void setPhone(MobilePhone phone) {
        this.phone = phone;
    }
}

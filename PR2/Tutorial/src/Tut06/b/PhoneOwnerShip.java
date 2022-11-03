package Tut06.b;

public class PhoneOwnerShip {
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setPhone(MobilePhone phone) {
        this.phone = phone;
    }

    private Person owner;
    private MobilePhone phone;

    public PhoneOwnerShip(Person owner, MobilePhone phone) {
        this.owner = owner;
        this.phone = phone;
    }
}

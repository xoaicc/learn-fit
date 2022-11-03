package Tut10.MandKind;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    protected String getFirstName() {
        return firstName;
    }

    protected void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName.length() < 4)
            throw new IllegalArgumentException("Expected length at least 4 symbols! Argument: firstName");
        if ((int)firstName.charAt(0) < 65 || (int)firstName.charAt(0) > 90)
            throw new IllegalArgumentException("Expected upper case letter! Argument: firstName");

        this.firstName = firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        if (lastName.length() < 3)
            throw new IllegalArgumentException("Expected length at least 3 symbols! Argument: firstName");
        if ((int)lastName.charAt(0) < 65 || (int)lastName.charAt(0) > 90)
            throw new IllegalArgumentException("Expected upper case letter! Argument: firstName");

        this.lastName = lastName;
    }
}

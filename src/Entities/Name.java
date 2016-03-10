package entities;

public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toFirstLast() {
        return firstName + " " + lastName;
    }

    public String toLastFirst() {
        return lastName + ", " + firstName;
    }
}

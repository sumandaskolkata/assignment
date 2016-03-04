public class Name {
    private String firstName;
    private String lastName;

    Name(String firstname, String lastName) {
        this.firstName = firstname;
        this.lastName = lastName;
    }

    public String toFirstLast() {
        return firstName + " " + lastName;
    }

    public String toLsasFirst() {
        return lastName + ", " + firstName;
    }
}

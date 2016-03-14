package Representation;

public class LastFirstNameRepresentation implements NameRepresentor {
    @Override
    public String call(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }
}

package Representation;

public class FirstLastNameRepresentation implements NameRepresentor {

    @Override
    public String call(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}

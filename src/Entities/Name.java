package entities;

import Representation.NameRepresentor;

public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String represent(NameRepresentor representor) {
        return representor.call(firstName, lastName);
    }

}

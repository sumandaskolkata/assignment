package Representation;

import entities.Address;
import entities.Age;
import entities.Gender;
import entities.Name;

public class GuestRepresent implements GuestRepresentor {
    private final NameRepresentor representor;

    public GuestRepresent(NameRepresentor representor) {
        this.representor = representor;
    }

    @Override
    public String call(Name name, Gender gender, Age age, Address address) {
        String formatedName = gender.getPrefix() + " " + name.represent(representor);
        String formatedAddress = address.addressRerpresentation();
        Template template = new Template(formatedName, formatedAddress);
        return template.represent();
    }
}

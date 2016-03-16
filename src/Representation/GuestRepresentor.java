package Representation;

import entities.*;

import java.util.ArrayList;

public interface GuestRepresentor {
    public String call(Name name, Gender gender, Age age, Address address);
}

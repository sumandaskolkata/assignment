package Representation;

import entities.Address;
import entities.Gender;
import entities.Guest;
import entities.Name;

import java.util.ArrayList;

public interface GuestRepresentor {
    public String call(Name name, Gender gender, int age, Address address);
}

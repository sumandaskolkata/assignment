package entities;

import Representation.GuestRepresentor;

import java.util.ArrayList;

public class Guest {
    private final Name name;
    private final int age;
    private final Address address;
    private final Gender gender;

    public Guest(Name name, int age, Gender gender, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }


    public String toRepresent(GuestRepresentor guestRepresentor) {
        return guestRepresentor.call(this.name, this.gender, this.age, this.address);
    }
    public boolean isLegalDrinker(int minimumAgeForDrink) {
        return minimumAgeForDrink < this.age;
    }

    public boolean isYourCountry(String countryName) {
        return address.isYourCountry(countryName);
    }

    public static ArrayList<Guest> parse(ArrayList<String> guestDetails) {
        ArrayList<Guest> guestList = new ArrayList<>();
        for (String guest : guestDetails) {
            String[] guestDetail = guest.split(",");
            Name name = new Name(guestDetail[0], guestDetail[1]);
            int age = Integer.parseInt(guestDetail[3]);
            Gender gender = Gender.valueOf(guestDetail[2].toUpperCase());
            Address address = new Address(guestDetail[4], guestDetail[5], guestDetail[6]);
            Guest newGuest = new Guest(name, age, gender, address);
            guestList.add(newGuest);
        }
        return guestList;
    }
}

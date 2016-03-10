package entities;

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


    public String getFirstLastWithPrefix() {
        return gender.getPrefix() + " " + name.toFirstLast();
    }

    public String getLastFirstWithPrefix() {
        return gender.getPrefix() + " " + name.toLastFirst();
    }

    public String getFirstLastNameWithCountry() {
        return address.concatCountryNameWithGivenName(getFirstLastWithPrefix());
    }

    public String getLastFirstNameWithCountry() {
        return address.concatCountryNameWithGivenName(getLastFirstWithPrefix());
    }

    public String getLastFirstNameWithCountryAndAge() {
        return address.concatCountryNameWithGivenName(getLastFirstWithPrefix()) + ", " + this.age;
    }

    public String getFirstLastNameWithCountryAndAge() {
        return address.concatCountryNameWithGivenName(getFirstLastWithPrefix()) + ", " + this.age;
    }

    public boolean isLegalDrinker(int minimumAgeForDrink) {
        return minimumAgeForDrink < this.age;
    }

    public boolean isYourCountry(String countryName) {
        return address.isYourCountry(countryName);
    }

    public static ArrayList<Guest> generateGuest(ArrayList<String[]> guestDetails) {
        ArrayList<Guest> guestList = new ArrayList<>();
        for (String[] guest : guestDetails) {
            Name name = new Name(guest[0], guest[1]);
            int age = Integer.parseInt(guest[3]);
            Gender gender = (guest[2].equals("Male")) ? Gender.MALE : Gender.FEMALE;
            Address address = new Address(guest[4], guest[5], guest[6]);
            Guest newGuest = new Guest(name, age, gender, address);
            guestList.add(newGuest);
        }
        return guestList;
    }
}

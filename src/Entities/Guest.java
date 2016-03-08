package Entities;

public class Guest {
    private final Name name;
    private final int age;
    private final Address address;
    private final Gender gender;

    public Guest(String firstName, String lastName, Gender gender, int age, String city, String state, String country) {
        this.name = new Name(firstName, lastName);
        this.age = age;
        this.address = new Address(city, state, country);
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
}

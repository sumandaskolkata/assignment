package entities;

public class Address {

    private final String city;
    private final String state;
    private final String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }


    public boolean isYourCountry(String countryName) {
        return this.country.equals(countryName);
    }

    public String addressRerpresentation() {
        return city + ", " + state + "\n" + country;
    }
}

package guestFilter;

import entities.Guest;
import entities.GuestList;

import java.util.ArrayList;

public class CountryFilter implements Filter {
    private final String countryName;

    public CountryFilter(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public ArrayList<Guest> call(ArrayList<Guest> list) {
        ArrayList<Guest> filteredGuest = new ArrayList<>();
        for (Guest guest : list) {
            if (guest.isYourCountry(countryName)) {
                filteredGuest.add(guest);
            }
        }
        return filteredGuest;
    }
}
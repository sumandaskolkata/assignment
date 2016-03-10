package entities;

import java.util.ArrayList;

public class GuestList {
    private ArrayList<Guest> guestList;

    public GuestList(ArrayList<Guest> guests) {
        this.guestList = guests;
    }


    public ArrayList<String> getFirstLastNameList() {
        ArrayList<String> guestNameList = new ArrayList<>();
        for (Guest guest : guestList) {
            String name = guest.getFirstLastWithPrefix();
            guestNameList.add(name);
        }
        return guestNameList;
    }

    public ArrayList<String> getLastFirstNameList() {
        ArrayList<String> guestNameList = new ArrayList<>();
        for (Guest guest : guestList) {
            String name = guest.getLastFirstWithPrefix();
            guestNameList.add(name);
        }
        return guestNameList;
    }

    private ArrayList<Guest> sortGuestFromGivenCountry(String counrtyName) {
        ArrayList<Guest> guestFromGivenCountry = new ArrayList<>();
        for (Guest guest : guestList) {
            if (guest.isYourCountry(counrtyName)) {
                guestFromGivenCountry.add(guest);
            }
        }
        return guestFromGivenCountry;
    }

    public ArrayList<String> getAllGuestsFirstLastNameFromGivenCountry(String countryName) {
        ArrayList<Guest> sortedGuests;
        sortedGuests = sortGuestFromGivenCountry(countryName);
        ArrayList<String> guestNameList = new ArrayList<>();
        for (Guest guest : sortedGuests) {
            String name = guest.getFirstLastNameWithCountry();
            guestNameList.add(name);
        }
        return guestNameList;
    }

    public ArrayList<String> getAllGuestLastFirstNameFromGivenCountry(String countryName) {
        ArrayList<Guest> sortedGuests = sortGuestFromGivenCountry(countryName);
        ArrayList<String> guestNameList = new ArrayList<>();
        for (Guest guest : sortedGuests) {
            String name = guest.getLastFirstNameWithCountry();
            guestNameList.add(name);
        }
        return guestNameList;
    }

    public ArrayList<String> getAllGuestsFirstLastNameFromACountryWhoAllAreLegalDrinkers(String countryName, int drinkingAge) {
        ArrayList<Guest> sortedGuests = sortGuestFromGivenCountry(countryName);
        ArrayList<Guest> legalDrinkersGuests = findLegalDrinkersFromList(sortedGuests, drinkingAge);
        ArrayList<String> legalDrinkerNames = new ArrayList<>();
        for (Guest guest : legalDrinkersGuests) {
            String name = guest.getFirstLastNameWithCountryAndAge();
            legalDrinkerNames.add(name);
        }
        return legalDrinkerNames;
    }


    public ArrayList<String> getAllGuestsLastFirstNameFromACountryWhoAllAreLegalDrinkers(String countryName, int drinkingAge) {
        ArrayList<Guest> sortedGuests = sortGuestFromGivenCountry(countryName);
        ArrayList<Guest> legalDrinkersGuests = findLegalDrinkersFromList(sortedGuests, drinkingAge);
        ArrayList<String> legalDrinkerNames = new ArrayList<>();
        for (Guest guest : legalDrinkersGuests) {
            String name = guest.getLastFirstNameWithCountryAndAge();
            legalDrinkerNames.add(name);
        }
        return legalDrinkerNames;
    }

    private ArrayList<Guest> findLegalDrinkersFromList(ArrayList<Guest> sortedGuests, int drinkingAge) {
        ArrayList<Guest> legalDrinkers = new ArrayList<>();
        for (Guest guest : sortedGuests) {
            if (guest.isLegalDrinker(drinkingAge)) {
                legalDrinkers.add(guest);
            }
        }
        return legalDrinkers;
    }
}
package PrintLabelsWithCountry;

import Entities.Gender;
import Entities.Guest;

import java.util.ArrayList;
import java.util.HashMap;


public class CountryWiseGuestList {

    private HashMap<String, ArrayList<Guest>> guestList;


    private CountryWiseGuestList(HashMap<String, ArrayList<Guest>> guestList) {
        this.guestList = guestList;
    }


    public static CountryWiseGuestList generateGuestListCountryWise(ArrayList<String[]> guestRecords) {
        HashMap<String, ArrayList<Guest>> guestList = new HashMap<>();
        for (String[] guest : guestRecords) {
            Gender personGender = (guest[2].equals("Male")) ? Gender.MALE : Gender.FEMALE;
            String guestCountry = guest[6];
            Guest newGuest = new Guest(guest[0], guest[1], personGender, Integer.parseInt(guest[3]), guest[4], guest[5], guest[6]);
            if (guestList.containsKey(guestCountry)) {
                ArrayList<Guest> guests = guestList.get(guestCountry);
                guests.add(newGuest);
                guestList.put(guestCountry, guests);
            } else {
                ArrayList<Guest> newGuestList = new ArrayList<>();
                newGuestList.add(newGuest);
                guestList.put(guestCountry, newGuestList);
            }
        }
        return new CountryWiseGuestList(guestList);
    }

    public ArrayList<Guest> getAllGuestsFromAcountry(String countryName) {
        return this.guestList.get(countryName);
    }

    public ArrayList<String> representFirstLastNameOfAllGivenGuestWithCountry(ArrayList<Guest> guests) {
        ArrayList<String> allGuestNameWithCountry = new ArrayList<>();
        for (Guest guest : guests) {
            String guestName = guest.getFirstLastNameWithCountry();
            allGuestNameWithCountry.add(guestName);
        }
        return allGuestNameWithCountry;
    }

    public ArrayList<String> representLastFirstNameOfAllGivenGuestWithCountry(ArrayList<Guest> guests) {
        ArrayList<String> allGuestNameWithCountry = new ArrayList<>();
        for (Guest guest : guests) {
            String guestName = guest.getLastFirstNameWithCountry();
            allGuestNameWithCountry.add(guestName);
        }
        return allGuestNameWithCountry;
    }
}

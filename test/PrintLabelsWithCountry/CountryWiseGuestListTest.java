package PrintLabelsWithCountry;

import Entities.Guest;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CountryWiseGuestListTest {
    @Test
    public void testGenerateGuestListCountryWise() throws Exception {
        ArrayList<String[]> guests = new ArrayList<>();
        String[] firstGuest = "Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia".split(",");
        guests.add(firstGuest);
        String[] secondGuest = "Omari,Beer,Male,20,Crooks ton,Vermont,Macedonia".split(",");
        guests.add(secondGuest);
        CountryWiseGuestList guestList = CountryWiseGuestList.generateGuestListCountryWise(guests);
        ArrayList<Guest> selectedGuests = guestList.getAllGuestsFromAcountry("Macedonia");
        ArrayList<String> guestsname = guestList.representFirstLastNameOfAllGivenGuestWithCountry(selectedGuests);

        assertTrue(guestsname.get(0).equals("Mr Catharine Hills, Macedonia"));
        assertTrue(guestsname.get(1).equals("Mr Omari Beer, Macedonia"));
    }

    @Test
    public void testGenerateGuestListCountryWiseAndPrintLastFirstName() throws Exception {
        ArrayList<String[]> guests = new ArrayList<>();
        String[] firstGuest = "Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia".split(",");
        guests.add(firstGuest);
        String[] secondGuest = "Omari,Beer,Male,20,Crooks ton,Vermont,Macedonia".split(",");
        guests.add(secondGuest);
        CountryWiseGuestList guestList = CountryWiseGuestList.generateGuestListCountryWise(guests);
        ArrayList<Guest> selectedGuests = guestList.getAllGuestsFromAcountry("Macedonia");
        ArrayList<String> guestsname = guestList.representLastFirstNameOfAllGivenGuestWithCountry(selectedGuests);

        assertTrue(guestsname.get(0).equals("Mr Hills, Catharine, Macedonia"));
        assertTrue(guestsname.get(1).equals("Mr Beer, Omari, Macedonia"));
    }

}
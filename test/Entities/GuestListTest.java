package entities;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GuestListTest {
    private GuestList guestList;

    @Before
    public void setUp() throws Exception {
        String[] firstGuest = "Arjun,Rampal,Male,44,LigthCity,Bangalore,India".split(",");
        String[] secondGuest = "Tristin,O'Reilly,Female,37,Veda haven,North Carolina,Romania".split(",");
        ArrayList<String[]> list = new ArrayList<>();
        list.add(firstGuest);
        list.add(secondGuest);
        ArrayList<Guest> guests = Guest.generateGuest(list);
        guestList = new GuestList(guests);

    }

    @Test
    public void testGetFirstLastNameListShouldGiveAllGuestsNameInFirstLastFormat() throws Exception {
        Assert.assertTrue(guestList.getFirstLastNameList().get(0).equals("Mr Arjun Rampal"));
        Assert.assertTrue(guestList.getFirstLastNameList().get(1).equals("Ms Tristin O'Reilly"));
    }

    @Test
    public void testGetLastFirstNameListShouldGiveAllGuestsNameInFirstLastFormat() throws Exception {
        Assert.assertTrue(guestList.getFirstLastNameList().get(0).equals("Mr Arjun Rampal"));
        Assert.assertTrue(guestList.getFirstLastNameList().get(1).equals("Ms Tristin O'Reilly"));
    }

    @Test
    public void testGetAllGuestsFirstLastNameFromGivenCountryShouldGiveAllGuestNameWithCountryFromThatCountry() throws Exception {
        ArrayList<String> guestList = this.guestList.getAllGuestsFirstLastNameFromGivenCountry("India");
        Assert.assertTrue(guestList.get(0).equals("Mr Arjun Rampal, India"));
    }

    @Test
    public void testGetAllGuestsLastFirstNameFromGivenCountryShouldGiveAllGuestNameWithCountryFromThatCountry() throws Exception {
        ArrayList<String> romaniaGuests = guestList.getAllGuestLastFirstNameFromGivenCountry("Romania");
        Assert.assertTrue(romaniaGuests.get(0).equals("Ms O'Reilly, Tristin, Romania"));
    }

    @Test
    public void getAllGuestsFirstLastNameFromACountryWhoAllAreLegalDrinkersShouldReturnAllGuestsNameWhoAreLegalDrinkers() throws Exception {
        ArrayList<String> romaniaGuests = guestList.getAllGuestsFirstLastNameFromACountryWhoAllAreLegalDrinkers("Romania", 20);
        Assert.assertTrue(romaniaGuests.get(0).equals("Ms Tristin O'Reilly, Romania, 37"));
    }

    @Test
    public void getAllGuestsLastFirstNameFromACountryWhoAllAreLegalDrinkersShouldReturnAllGuestsNameWhoAreLegalDrinkers() throws Exception {
        ArrayList<String> romaniaGuests = guestList.getAllGuestsLastFirstNameFromACountryWhoAllAreLegalDrinkers("Romania", 20);
        Assert.assertTrue(romaniaGuests.get(0).equals("Ms O'Reilly, Tristin, Romania, 37"));
    }

}
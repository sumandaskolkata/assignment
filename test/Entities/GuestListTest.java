package entities;

import guestFilter.CountryFilter;
import guestFilter.Filter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class GuestListTest {
    private GuestList guestList;

    @Before
    public void setUp() throws Exception {
        String firstGuest = "Arjun,Rampal,Male,44,LigthCity,Bangalore,India";
        String secondGuest = "Tristin,O'Reilly,Female,37,Veda haven,North Carolina,Romania";
        ArrayList<String> list = new ArrayList<>();
        list.add(firstGuest);
        list.add(secondGuest);
        ArrayList<Guest> guests = Guest.parse(list);
        guestList = new GuestList(guests);

    }

    @Test
    public void testfilterGuestListShouldTakeAListOfFilterAndFilterGuestList() throws Exception {
        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(new CountryFilter("India"));
        GuestList newList = guestList.filterGuestList(filters);
        Assert.assertEquals(newList.numberOfGuest(), 1);

    }
}
package guestFilterTest;

import entities.Guest;
import entities.GuestList;
import guestFilter.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CountryFilter {
    private GuestList guestList;

    @Before
    public void setUp() throws Exception {
        ArrayList<String> guests = new ArrayList<>();
        guests.add("Tristin,O'Reilly,Female,37,Veda haven,North Carolina,Peru");
        guests.add("Weston,McDermott,Female,21,Katlynn view,North Carolina,Bangladesh");
        ArrayList<Guest> list = Guest.parse(guests);
        guestList = new GuestList(list);
    }

    @Test
    public void testFilterShouldReturnAListOfGuests() throws Exception {
        Filter filter = new guestFilter.CountryFilter("Bangladesh");
        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(filter);
        GuestList filterGuestList = guestList.filterGuestList(filters);
        Assert.assertEquals(filterGuestList.numberOfGuest(), 1);
    }

    @Test
    public void testFilterShouldReturnAEmptyListWhenNoGuestFoundFromThatCountry() throws Exception {
        Filter filter = new guestFilter.CountryFilter("India");
        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(filter);
        GuestList filterGuestList = guestList.filterGuestList(filters);
        Assert.assertEquals(filterGuestList.numberOfGuest(), 0);
    }
}

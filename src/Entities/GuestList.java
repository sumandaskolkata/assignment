package entities;

import Representation.GuestRepresentor;
import guestFilter.Filter;

import java.util.ArrayList;

public class GuestList {
    private ArrayList<Guest> guestList;

    public GuestList(ArrayList<Guest> guests) {
        this.guestList = guests;
    }

    public GuestList filterGuestList(ArrayList<Filter> filters) {
        ArrayList<Guest> filteredGuestList = this.guestList;
        for (Filter filter : filters) {
            filteredGuestList = filter.call(filteredGuestList);
        }
        return new GuestList(filteredGuestList);
    }

    public ArrayList<String> representAllGuest(GuestRepresentor guestRepresentor) {
        ArrayList<String> guestsNames = new ArrayList<>();
        for (Guest guest : guestList) {
            guestsNames.add(guest.represent(guestRepresentor));
        }
        return guestsNames;
    }

    public int numberOfGuest() {
        return guestList.size();
    }
}
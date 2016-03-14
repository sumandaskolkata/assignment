import entities.GuestList;
import entities.Guest;
import guestFilter.Filter;
import util.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

public class PrintLabels {
    public static void main(String[] args) throws IOException {
        ReadFile reader = new ReadFile();
        UserOption options = UserOption.readUserOption(args);
        ArrayList<String> guestRecords = options.read(reader);
        ArrayList<Guest> guests = Guest.parse(guestRecords);
        GuestList guestList = new GuestList(guests);
        ArrayList<Filter> filters = options.createFilters();
        GuestList filteredGuestList = guestList.filterGuestList(filters);
        ArrayList<String> guestNames = filteredGuestList.representAllGuest(options.representor());
        for (String guestName : guestNames) {
            System.out.println(guestName);
        }
    }
}
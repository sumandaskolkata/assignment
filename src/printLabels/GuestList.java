package printLabels;

import java.util.ArrayList;

public class GuestList {
    private final ArrayList<Guest> guestList;

    private GuestList(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }


    public static GuestList generateGuestList(ArrayList<String[]> guestDitales) {
        ArrayList<Guest> list = new ArrayList<>();
        int numberOfGuest = guestDitales.size();
        for (int i = 0; i < numberOfGuest; i++) {
            String[] person = guestDitales.get(i);
            Gender personGender = (person[2].equals("Male")) ? Gender.MALE : Gender.FEMALE;
            Guest guest = new Guest(person[0], person[1], personGender, Integer.parseInt(person[3]), person[4], person[5], person[6]);
            list.add(guest);
        }
        return new GuestList(list);
    }

    public ArrayList<String> guestFirstLastNameList() {
        ArrayList<String> guestNameList = new ArrayList<>();
        for (Guest guest : guestList) {
            String name = guest.getFirstLastWithPrefix();
            guestNameList.add(name);
        }
        return guestNameList;
    }

    public ArrayList<String> guestLastFirstNameList() {
        ArrayList<String> guestNameList = new ArrayList<>();
        for (Guest guest : guestList) {
            String name = guest.getLastFirstWithPrefix();
            guestNameList.add(name);
        }
        return guestNameList;
    }
}
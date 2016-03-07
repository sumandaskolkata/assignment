package printLabels;

import org.junit.Test;
import printLabels.GuestList;

import java.util.ArrayList;

public class GuestListTest {
    @Test
    public void testGsestList() throws Exception {
        String[] guest = "Arjun,Rampal,Male,44,LigthCity,Bangalore,India".split(",");
        ArrayList<String[]> list = new ArrayList<>();
        list.add(guest);
        GuestList guestList = GuestList.generateGuestList(list);
        guestList.guestFirstLastNameList();
    }
}
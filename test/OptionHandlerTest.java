import entities.Guest;
import entities.GuestList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OptionHandlerTest {
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
    public void testOptionHandlerShouldGiveAllGuestFirstLastNameWhenOptionIsFirstLastAndFileName() throws Exception {
        String[] option = "-firstLast,records".split(",");
        OptionHandler handler = new OptionHandler(option, guestList);
        ArrayList<String> guestsNames = handler.operation();
        assertTrue(guestsNames.get(0).equals("Mr Arjun Rampal"));
        assertTrue(guestsNames.get(1).equals("Ms Tristin O'Reilly"));
    }

    @Test
    public void testOptionHandlerShouldGiveAllGuestLastFirstNameWhenOptionIsLastFirstAndFileNameName() throws Exception {
        String[] option = "-lastFirst,records".split(",");
        OptionHandler handler = new OptionHandler(option, guestList);
        ArrayList<String> guestsNames = handler.operation();
        System.out.println(guestsNames.get(0));
        assertTrue(guestsNames.get(0).equals("Mr Rampal, Arjun"));
        assertTrue(guestsNames.get(1).equals("Ms O'Reilly, Tristin"));
    }

    @Test
    public void testOptionHandlerShouldGiveAllGuestLastFirstNameWithCountryNameWhenOptionIsLastFirstCountryNameFileName() throws Exception {
        String[] option = "-lastFirst,India,records".split(",");
        OptionHandler handler = new OptionHandler(option, guestList);
        ArrayList<String> guestsNames = handler.operation();
        assertTrue(guestsNames.get(0).equals("Mr Rampal, Arjun, India"));
    }

    @Test
    public void testOptionHandlerShouldGiveAllGuesFirstLastNameWithCountryNameWhenOptionIsFirstLastCountryNameFileName() throws Exception {
        String[] option = "-firstLast,India,records".split(",");
        OptionHandler handler = new OptionHandler(option, guestList);
        ArrayList<String> guestsNames = handler.operation();
        assertTrue(guestsNames.get(0).equals("Mr Arjun Rampal, India"));
    }
}
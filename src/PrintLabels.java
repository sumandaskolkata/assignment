import entities.GuestList;
import entities.Guest;
import util.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

public class PrintLabels {
    public static void main(String[] args) throws IOException {
        System.out.println(args[0] + args[1] + args.length);
        String fileName = args[args.length - 1];
        ReadFile recordFile = new ReadFile(fileName);
        ArrayList<String[]> guestRecords = recordFile.readGuestRecords();
        ArrayList<Guest> guests = Guest.generateGuest(guestRecords);
        GuestList guestList = new GuestList(guests);
        OptionHandler handler = new OptionHandler(args, guestList);
        ArrayList<String> guestNames = handler.operation();
        for (String guestName : guestNames) {
            System.out.println(guestName);
        }
    }
}
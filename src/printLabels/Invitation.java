package printLabels;

import java.io.IOException;
import java.util.ArrayList;

public class Invitation {
    public static void main(String[] args) throws IOException {
        String option = args[0];
        String fileName = args[1];
        ArrayList<String> guestNameList;

        printLabels.FileReader recordFile = new FileReader(fileName);
        ArrayList<String[]> records = recordFile.readGuestRecords();
        GuestList guestList = GuestList.generateGuestList(records);

        switch (option) {
            case "-lastFirst":
                guestNameList = guestList.guestLastFirstNameList();
                break;
            case "-firstLast":
                guestNameList = guestList.guestFirstLastNameList();
                break;
            default:
                guestNameList = guestList.guestFirstLastNameList();
                break;
        }
        for (String name : guestNameList) {
            System.out.println(name);
        }
    }
}

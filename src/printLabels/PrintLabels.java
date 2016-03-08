package PrintLabels;

import Entities.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

public class PrintLabels {
    public static void main(String[] args) throws IOException {
        String option = args[0];
        String fileName = args[1];
        ArrayList<String> guestNameList;

        ReadFile recordFile = new ReadFile(fileName);
        ArrayList<String[]> guestRecords = recordFile.readGuestRecords();
        GuestList guestList = GuestList.generateGuestList(guestRecords);

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

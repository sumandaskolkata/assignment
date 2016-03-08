package PrintLabelsWithCountry;

import Entities.Guest;
import Entities.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

public class PrintLabelsWithCountryName {
    public static void main(String[] args) throws IOException {
        String option = args[0];
        String countryName = args[1];
        String fileName = args[2];
        ArrayList<String> guestsNameList = new ArrayList<>();

        ReadFile recordFile = new ReadFile(fileName);
        ArrayList<String[]> guestRecords = recordFile.readGuestRecords();
        CountryWiseGuestList guestsList = CountryWiseGuestList.generateGuestListCountryWise(guestRecords);
        ArrayList<Guest> guestsFormCountry = guestsList.getAllGuestsFromAcountry(countryName);


        if (option.equals("-firstLast")) {
            guestsNameList = guestsList.representFirstLastNameOfAllGivenGuestWithCountry(guestsFormCountry);
        } else if (option.equals("-lastFirst")) {
            guestsNameList = guestsList.representLastFirstNameOfAllGivenGuestWithCountry(guestsFormCountry);
        }
        for (String guestName : guestsNameList) {
            System.out.println(guestName);
        }
    }
}

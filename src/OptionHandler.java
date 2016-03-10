import entities.GuestList;

import java.util.ArrayList;

public class OptionHandler {
    private final String[] options;
    private final GuestList guestList;

    public OptionHandler(String[] options, GuestList list) {
        this.options = options;
        this.guestList = list;
    }

    public ArrayList<String> operation() {
        if (options[0].equals("-firstLast") && options.length == 2) {
            return guestList.getFirstLastNameList();
        } else if (options[0].equals("-lastFirst") && options.length == 2) {
            return guestList.getLastFirstNameList();
        } else if (options[0].equals("-firstLast") && options.length == 3) {
            String countryName = options[1];
            return guestList.getAllGuestsFirstLastNameFromGivenCountry(countryName);
        } else if (options.length == 3 && options[0].equals("-lastFirst")) {
            String countryName = options[1];
            return guestList.getAllGuestLastFirstNameFromGivenCountry(countryName);
        } else if (options.length == 4 && options[0].equals("-firstLast")) {
            String countryName = options[1];
            int legalDrinkingAge = Integer.parseInt(options[2]);
            return guestList.getAllGuestsFirstLastNameFromACountryWhoAllAreLegalDrinkers(countryName, legalDrinkingAge);
        } else if (options.length == 4 && options[0].equals("-lastFirst")) {
            String countryName = options[1];
            int legalDrinkingAge = Integer.parseInt(options[2]);
            return guestList.getAllGuestsLastFirstNameFromACountryWhoAllAreLegalDrinkers(countryName, legalDrinkingAge);

        }
        throw new RuntimeException("Not a valid option");
    }

}

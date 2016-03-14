import Representation.*;
import guestFilter.CountryFilter;
import guestFilter.DrinkingAgeFilter;
import guestFilter.Filter;
import util.ReadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UserOption {
    private final String fileName;
    private final String nameFormat;
    private String countryName;
    private final int minimumAge;


    public UserOption(String fileName, String nameFormat, String countryName, int minimumAge) {
        this.fileName = fileName;
        this.nameFormat = nameFormat;
        this.countryName = countryName;
        this.minimumAge = minimumAge;
    }

    public ArrayList<String> read(ReadFile reader) throws IOException {
        return reader.read(this.fileName);
    }

    public static UserOption readUserOption(String[] options) {
        int countryIndex = Arrays.asList(options).indexOf("-country");
        int ageIndex = Arrays.asList(options).indexOf("-minAge");

        String fileName = options[options.length - 1];
        String nameFormat = (options.length > 1) ? options[0] : null;
        String countryName = (countryIndex == -1) ? null : options[countryIndex + 1];
        String minimunAge = (ageIndex == -1) ? null : options[ageIndex + 1];

        int age = (minimunAge != null) ? Integer.parseInt(minimunAge) : 0;
        return new UserOption(fileName, nameFormat, countryName, age);
    }

    public ArrayList<Filter> createFilters() {
        ArrayList<Filter> filters = new ArrayList<>();
        if (this.countryName != null) {
            filters.add(new CountryFilter(this.countryName));
        }
        if (this.minimumAge != 0) {
            filters.add(new DrinkingAgeFilter(this.minimumAge));
        }
        return filters;
    }

    public GuestRepresentor representor() {
        if (Objects.equals(nameFormat, "-firstLast"))
            return new GuestRepresent(new FirstLastNameRepresentation());
        else
            return new GuestRepresent(new LastFirstNameRepresentation());
    }
}

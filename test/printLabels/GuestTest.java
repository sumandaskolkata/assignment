package printLabels;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import printLabels.Gender;
import printLabels.Guest;

public class GuestTest {
    @Test
    public void person_name_as_prefixed_firstname_lasname_format() {
        Guest firstPerson = new Guest("Julius", "Barrows", Gender.FEMALE, 18, "Veda haven", "Vermont", "Macedonia");
        Guest secondPerson = new Guest("Gavin", "Hyatt", Gender.MALE, 36, "Crooks ton", "Illinois", "Romania");

        assertEquals(firstPerson.getFirstLastWithPrefix(), "Ms Julius Barrows");
        assertEquals(secondPerson.getFirstLastWithPrefix(), "Mr Gavin Hyatt");
    }

    @Test
    public void person_name_as_prefixed_lasname_firstname_format() {
        Guest one = new Guest("Julius", "Barrows", Gender.FEMALE, 18, "Veda haven", "Vermont", "Macedonia");
        assertEquals(one.getLastFirstWithPrefix(), "Ms Barrows, Julius");
    }

    @Test
    public void peroson_name_with_countryName() {
        Guest firstPerson = new Guest("Julius", "Barrows", Gender.FEMALE, 18, "Veda haven", "Vermont", "Macedonia");
        assertEquals(firstPerson.getNameWithCountry(), "Ms Julius Barrows Macedonia");
    }
}

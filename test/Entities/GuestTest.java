package Entities;

import static org.junit.Assert.assertEquals;

import Entities.Gender;
import Entities.Guest;
import org.junit.Test;

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
    public void peroson_firstLast_name_with_countryName() {
        Guest firstPerson = new Guest("Julius", "Barrows", Gender.FEMALE, 18, "Veda haven", "Vermont", "Macedonia");
        assertEquals(firstPerson.getFirstLastNameWithCountry(), "Ms Julius Barrows, Macedonia");
    }

    @Test
    public void testGuestLastFirstNameWithCountry() throws Exception {
        Guest firstPerson = new Guest("Julius", "Barrows", Gender.FEMALE, 18, "Veda haven", "Vermont", "Macedonia");
        assertEquals(firstPerson.getLastFirstNameWithCountry(), "Ms Barrows, Julius, Macedonia");
    }
}

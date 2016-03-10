package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GuestTest {
    private Guest male;
    private Guest female;

    @Before
    public void setUp() throws Exception {
        Name maleName = new Name("Julius", "Barrows");
        Address maleAddress = new Address("Veda haven", "Vermont", "Macedonia");
        female = new Guest(maleName, 18, Gender.FEMALE, maleAddress);
        Name femaleName = new Name("Gavin", "Hyatt");
        Address femaleAddress = new Address("Crooks ton", "Illinois", "Romania");
        male = new Guest(femaleName, 32, Gender.MALE, femaleAddress);

    }

    @Test
    public void person_name_as_prefixed_firstname_lasname_format() {
        assertEquals(female.getFirstLastWithPrefix(), "Ms Julius Barrows");
        assertEquals(male.getFirstLastWithPrefix(), "Mr Gavin Hyatt");
    }

    @Test
    public void person_name_as_prefixed_lasname_firstname_format() {
        assertEquals(female.getLastFirstWithPrefix(), "Ms Barrows, Julius");
        assertEquals(male.getLastFirstWithPrefix(), "Mr Hyatt, Gavin");
    }

    @Test
    public void peroson_firstLast_name_with_countryName() {
        assertEquals(female.getFirstLastNameWithCountry(), "Ms Julius Barrows, Macedonia");
    }

    @Test
    public void testGuestLastFirstNameWithCountry() throws Exception {
        assertEquals(female.getLastFirstNameWithCountry(), "Ms Barrows, Julius, Macedonia");
    }

    @Test
    public void testIsAGuestLegalDrinkerShouldGiveFalseIfGuestAgeIsLessThanGivenAge() throws Exception {
        assertFalse(female.isLegalDrinker(20));
    }

    @Test
    public void testIsAGuestLegalDrinkerShouldGiveTrueIfGuestAgeIsLessThanGivenAge() throws Exception {
        assertTrue(male.isLegalDrinker(30));
    }

    @Test
    public void testIsyourCountryGiveTrueWhenGivenCountryMatchWithPersonCountry() throws Exception {
        assertTrue(male.isYourCountry("Romania"));
    }

    @Test
    public void testIsyourCountryGiveFalseWhenGivenCountryNotMatchWithPersonCountry() throws Exception {
        assertFalse(male.isYourCountry("India"));
    }
}

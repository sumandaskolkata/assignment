package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Representation.FirstLastNameRepresentation;
import Representation.GuestRepresent;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GuestTest {
    private Guest male;
    private Guest female;

    @Before
    public void setUp() throws Exception {
        Name femaleName = new Name("Julius", "Barrows");
        Address maleAddress = new Address("Veda haven", "Vermont", "Macedonia");
        Age femaleAge = new Age(18);
        female = new Guest(femaleName, femaleAge, Gender.FEMALE, maleAddress);
        Name maleName = new Name("Gavin", "Hyatt");
        Address femaleAddress = new Address("Crooks ton", "Illinois", "Romania");
        Age maleAge = new Age(32);
        male = new Guest(maleName, maleAge, Gender.MALE, femaleAddress);

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

    @Test
    public void testToRepresentShouldTakeAGuestRepresentorAndCallIt() throws Exception {
        GuestRepresent represent = new GuestRepresent(new FirstLastNameRepresentation()) {
            @Override
            public String call(Name name, Gender gender, Age age, Address address) {
                assertEquals(gender.getPrefix(), "Mr");
                return super.call(name, gender, age, address);
            }
        };
        male.represent(represent);

    }

    @Test
    public void testGuestPasreShouldTakeListOfStringAndCreateGUestFromString() throws Exception {
        ArrayList<String> guestDetails = new ArrayList<>();
        guestDetails.add("Omari,Beer,Male,20,Crooks ton,Vermont,Macedonia");
        guestDetails.add("Tristin,O'Reilly,Female,37,Veda haven,North Carolina,Romania");
        ArrayList<Guest> guests = Guest.parse(guestDetails);
        assertEquals(guests.size(), 2);
    }
}

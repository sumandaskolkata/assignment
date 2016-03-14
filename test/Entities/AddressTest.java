package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void testIsYourCOuntryReturnTrueWhenGivenCountryMatchs() throws Exception {
        Address address = new Address("Wasipur", "Bihar", "India");
        assertTrue(address.isYourCountry("India"));
    }

    @Test
    public void testIsYourCOuntryReturnFalseWhenGivenCountryNotMatchs() throws Exception {
        Address address = new Address("Wasipur", "Bihar", "India");
        assertFalse(address.isYourCountry("America"));
    }

    @Test
    public void testAddressRepresentaionShouldGiveCityStateAndCountryName() throws Exception {
        Address address = new Address("Airport", "Army", "America");
        assertEquals(address.addressRerpresentation(), "Airport, Army\nAmerica");

    }
}
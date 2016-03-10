package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    @Test
    public void testGuestNameWithCountryRepresentation() throws Exception {
        Address address = new Address("Wasipur", "Bihar", "India");
        String name = address.concatCountryNameWithGivenName("Mr Gabbar Sing");
        assertTrue(name.equals("Mr Gabbar Sing, India"));
    }

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
}
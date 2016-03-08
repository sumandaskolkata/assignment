package Entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    @Test
    public void testGuestNameWithCountryRepresentation() throws Exception {
        Address address = new Address("Wasipur", "Bihar", "India");
        String name = address.concatCountryNameWithGivenName("Mr Gabbar Sing");
        assertTrue(name.equals("Mr Gabbar Sing, India"));
    }
}
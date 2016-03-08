package Entities;

import Entities.Name;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    @Test
    public void testFirstLastNameRepresentation() {
        Name name = new Name("Ramu", "Kaka");
        assertTrue(name.toFirstLast().equals("Ramu Kaka"));
    }

    @Test
    public void testLastFirstNameRepresentation() {
        Name name = new Name("Sun", "Moon");
        assertTrue(name.toLastFirst().equals("Moon, Sun"));
    }
}
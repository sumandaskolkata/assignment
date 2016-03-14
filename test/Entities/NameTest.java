package entities;

import Representation.FirstLastNameRepresentation;
import Representation.LastFirstNameRepresentation;
import Representation.NameRepresentor;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    @Test
    public void testNameRepresentReturnFirstLastNameWhenRepresentorIsFirstLast() throws Exception {
        NameRepresentor representor = new FirstLastNameRepresentation();
        Name name = new Name("Ramu", "Kaka");
        assertEquals(name.represent(representor), "Ramu Kaka");

    }
    @Test
    public void testNameRepresentReturnLastFirstNameWhenRepresentorIsLastFirst() throws Exception {
        NameRepresentor representor = new LastFirstNameRepresentation();
        Name name = new Name("Ramu", "Kaka");
        assertEquals(name.represent(representor), "Kaka, Ramu");

    }
}
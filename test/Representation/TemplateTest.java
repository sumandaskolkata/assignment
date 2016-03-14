package Representation;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemplateTest {
    @Test
    public void testTemplateRepresentShouldRepresentNameAndAddressInBoxForamt() throws Exception {
        String name = "Ramu";
        String address = "Kolkata,dumdum\nBangladesh";
        Template template = new Template(name, address);
        String expected = "+----------------+\n" +
                "| Ramu           |\n" +
                "|----------------|\n" +
                "| Kolkata,dumdum |\n" +
                "| Bangladesh     |\n" +
                "+----------------+";
        assertEquals(template.represent(), expected);
    }
}
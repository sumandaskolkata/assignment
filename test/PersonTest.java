import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
    @Test
    public void person_name_as_prefixed_firstname_lasname_format() {
        Person one = new Person("Julius", "Barrows", Gender.FEMALE, 18, "Veda haven", "Vermont", "Macedonia");
        assertEquals(one.invitationName(), "Ms Julius Barrows");
    }

    @Test
    public void person_name_as_prefixed_lasname_firstname_format() {
        Person one = new Person("Julius", "Barrows", Gender.FEMALE, 18, "Veda haven", "Vermont", "Macedonia");
        assertEquals(one.invitationNameLastFirst(), "Ms Barrows, Julius");
    }


}

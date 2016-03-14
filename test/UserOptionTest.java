import Representation.FirstLastNameRepresentation;
import Representation.GuestRepresent;
import org.junit.Test;
import util.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserOptionTest {
    @Test
    public void testReadShouldTakeAFileReaderAndReadAFile() throws Exception {
        UserOption option = new UserOption("Sample.txt", null, null, 0);
        ReadFile reader = new ReadFile() {
            @Override
            public ArrayList<String> read(String fileName) throws IOException {
                ArrayList<String> list = new ArrayList<>();
                list.add("sample data");
                return list;
            }
        };
        ArrayList<String> text = option.read(reader);
        assertEquals(text.get(0), "sample data");
    }
}
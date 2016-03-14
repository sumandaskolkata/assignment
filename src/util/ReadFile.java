package util;

import java.io.*;
import java.util.ArrayList;


public class ReadFile {
    public ArrayList<String> read(String fileName) throws IOException {
        FileReader fileRead = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fileRead);
        String line;
        ArrayList<String> guestDetails = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            guestDetails.add(line);
        }
        return guestDetails;
    }
}

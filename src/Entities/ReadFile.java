package Entities;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    private final String fileName;

    public ReadFile(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String[]> readGuestRecords() throws IOException {
        FileReader fileRead = new FileReader(this.fileName);
        BufferedReader br = new BufferedReader(fileRead);
        String line;
        ArrayList<String[]> guestDetails = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] country = line.split(",");
            guestDetails.add(country);
        }
        return guestDetails;
    }
}

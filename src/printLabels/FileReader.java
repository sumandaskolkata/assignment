package printLabels;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {
    private final String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String[]> readGuestRecords() throws IOException {
        java.io.FileReader fileRead = new java.io.FileReader(this.fileName);
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

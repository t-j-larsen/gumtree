package com.gumtree.tim;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tim on 27/02/15.
 */
public class AddressBook {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

    public Map<String,Entry> entries = new HashMap<>(); // map by name

    public AddressBook(InputStream inputStream) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(", ");
                try {
                    // e.g. Bill McKnight, Male, 16/03/77
                    Entry entry = new Entry(parts[0], Entry.Gender.valueOf(parts[1].toUpperCase()), LocalDate.parse(parts[2], formatter));
                    entries.put(parts[0], entry);
                } catch (Exception e) {
                    System.err.println("");
                    //TODO: confirm desired functionality if there is a format problem with a single entry
                    // continue trying other entries
                }
                line = br.readLine();
            }
        }
    }

    public Map<String,Entry> getEntries() {
        return entries;
    }

}

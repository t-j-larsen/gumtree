package com.gumtree.tim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tim on 27/02/15.
 */
public class AddressBook {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

    // TODO: consider multi-threaded access
    public Map<String,AddressBookEntry> entries = new HashMap<>(); // map by name

    /**
     * Loads the entries from an InputStream
     *
     * @param inputStream contains the entries
     * @throws IOException
     */
    // TODO: confirm if throwing the IOException is the right thing to do
    public AddressBook(InputStream inputStream) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(", ");
                try {
                    // example format: "Bill McKnight, Male, 16/03/77"
                    AddressBookEntry addressBookEntry = new AddressBookEntry(parts[0], AddressBookEntry.Gender.valueOf(parts[1].toUpperCase()), LocalDate.parse(parts[2], formatter));
                    entries.put(parts[0], addressBookEntry);
                } catch (Exception e) {
                    System.err.println("");
                    //TODO: confirm desired functionality if there is a format problem with a single entry
                    // continue trying other entries
                }
                line = br.readLine();
            }
        }
    }

    /**
     *
     * @param name the person's full name
     * @return the entry for that person
     */
    public AddressBookEntry getByName(String name) {
        return entries.get(name);
    }

    /**
     *
     * @return all entries in the address book
     */
    public Collection<AddressBookEntry> getEntries() {
        return entries.values();
    }

}

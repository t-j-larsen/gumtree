package com.gumtree.tim;

import java.time.temporal.ChronoUnit;

/**
 * Created by tim on 27/02/15.
 */
public class MyApp {

    private AddressBook addressBook;

    public MyApp(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Counts the number of entries for each gender
     *
     * @param gender
     * @return the count
     */
    public long countGender(AddressBookEntry.Gender gender) {
        return addressBook.getEntries().stream().filter(e -> gender.equals(e.getGender())).count();
    }

    /*
     *
     * @return the entry with the earliest date of birth
     */
    public AddressBookEntry findOldest() {
        // TODO: This assumes there is only one oldest person, or that the requirements don't care about this situation!
        return addressBook.getEntries().stream().reduce((a, b) -> a.getDob().isBefore(b.getDob()) ? a : b).get();
    }

    /**
     * Calculates the number of days between the date of birth of person 1 and 2
     *
     * @param name1 full name of first person
     * @param name2 full name of second person
     * @return number of days difference
     */
    public long calculateDOBDiff(String name1, String name2) {
        AddressBookEntry entry1 = addressBook.getByName(name1);
        AddressBookEntry entry2 = addressBook.getByName(name2);

        if (entry1 == null || entry2 == null) {
            // TODO: confirm requirements here
            throw new IllegalArgumentException("Could not find both names in the address book");
        }

        return ChronoUnit.DAYS.between(entry1.getDob(), entry2.getDob());
    }
}

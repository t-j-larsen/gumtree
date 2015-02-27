package com.gumtree.tim;

import org.junit.Test;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by tim on 27/02/15.
 */
public class AddressBookTest {

    private AddressBook addressBook;

    public AddressBookTest() throws IOException {
        addressBook = new AddressBook(this.getClass().getClassLoader().getResourceAsStream("AddressBook"));
    }

    @Test
    public void shouldLoadEntries() {
        assertEquals(5, addressBook.getEntries().size());
    }

    @Test
    public void shouldCountMales() {
        final Collection<Entry> entries = addressBook.getEntries().values();
        final long maleCount = entries.stream().filter(e -> Entry.Gender.MALE.equals(e.getGender())).count();
        assertEquals(3, maleCount);
    }

    @Test
    public void shouldFindOldestPerson() {
        // TODO: This assumes there is only one oldest person, or that the requirements don't care about this situation!
        Collection<Entry> entries = addressBook.getEntries().values();
        Entry oldest = entries.stream().reduce((a, b) -> a.getDob().isBefore(b.getDob()) ? a : b).get();
        assertEquals("Wes Jackson", oldest.getName());

    }

    @Test
    public void shouldCalculateDOBDifference() {

        Entry bill = addressBook.getEntries().get("Bill McKnight"); // 16/03/77
        Entry paul = addressBook.getEntries().get("Paul Robinson"); // 15/01/85

        long daysBetween = ChronoUnit.DAYS.between(bill.getDob(), paul.getDob());

        // http://www.timeanddate.com/date/durationresult.html?m1=3&d1=16&y1=1977&m2=01&d2=15&y2=1985
        assertEquals(2862, daysBetween);
    }
}

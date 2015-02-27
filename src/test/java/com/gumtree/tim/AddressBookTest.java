package com.gumtree.tim;

import org.junit.Test;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

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

    }

    @Test
    public void shouldFindOldestPerson() {

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

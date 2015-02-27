package com.gumtree.tim;

import org.junit.Test;

import java.io.IOException;

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

    }
}

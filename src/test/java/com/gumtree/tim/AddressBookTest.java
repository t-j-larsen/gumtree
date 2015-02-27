package com.gumtree.tim;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by tim on 27/02/15.
 */
public class AddressBookTest {

    private AddressBook addressBook;

    public AddressBookTest() throws IOException {
        this.addressBook = new AddressBook(this.getClass().getClassLoader().getResourceAsStream("AddressBook"));
    }

    @Test
    public void shouldLoadEntries() {
        assertEquals(5, addressBook.getEntries().size());
    }

    //TODO: write tests that check for error handling e.g. invalid file formats
}

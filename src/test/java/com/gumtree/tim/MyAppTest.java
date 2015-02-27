package com.gumtree.tim;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

/**
 * Created by tim on 27/02/15.
 */
public class MyAppTest {

    private MyApp myApp;

    public MyAppTest() throws IOException {
        this.myApp = new MyApp(new AddressBook(this.getClass().getClassLoader().getResourceAsStream("AddressBook")));
    }

    // task 1
    @Test
    public void shouldCountMales() {
        assertEquals(3, myApp.countGender(AddressBookEntry.Gender.MALE));
    }

    // task 2
    @Test
    public void shouldFindOldestPerson() {
        assertEquals("Wes Jackson", myApp.findOldest().getName());

    }

    // task 3
    @Test
    public void shouldCalculateDOBDifference() {
        // http://www.timeanddate.com/date/durationresult.html?m1=3&d1=16&y1=1977&m2=01&d2=15&y2=1985
        assertEquals(2862, myApp.calculateDOBDiff("Bill McKnight", "Paul Robinson"));
    }

}

package com.gumtree.tim;

import java.time.LocalDate;

/**
 * Created by tim on 27/02/15.
 */
public class AddressBookEntry {

    public enum Gender { MALE, FEMALE }

    private String name; // assume we don't need to store given and family names separately
    private Gender gender;
    private LocalDate dob;

    public AddressBookEntry(String name, Gender gender, LocalDate dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

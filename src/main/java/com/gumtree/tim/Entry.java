package com.gumtree.tim;

import java.util.Date;

/**
 * Created by tim on 27/02/15.
 */
public class Entry {

    public enum Gender { MALE, FEMALE }

    private String name;
    private Gender gender;
    private Date dob;

    public Entry(Date dob, Gender gender, String name) {
        this.dob = dob;
        this.gender = gender;
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.acc.capstone.addressbook;

import java.io.Serializable;

/**
 *
 * @author Rayo
 */
import java.io.*;

public class Person implements Serializable{
    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private String phoneNumber;
    private String birthday;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param firstName the name to set
     */
    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    /**
     * @param address the address to set
     */
    public void setAddress( String address ) {
        this.address = address;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress( String emailAddress ) {
        this.emailAddress = emailAddress;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber( String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday( String birthday ) {
        this.birthday = birthday;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.acc.capstone.addressbook;

/**
 *
 * @author Rayo
 */
import java.io.*;

public class UserBean implements Serializable {
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser( String user ) {
        this.user = user;
    }

    public void setPassword( String password ) {
        this.password = password;
    }      
}
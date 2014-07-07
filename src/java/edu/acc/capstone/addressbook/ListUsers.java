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
import java.util.*;

public class ListUsers {
    private static ArrayList<User> userList = new ArrayList<>();

    /**
     * @return the userList
     */
    public static ArrayList<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public static void updateUserList( User user ) {
        userList.add( user );
    }
    
}

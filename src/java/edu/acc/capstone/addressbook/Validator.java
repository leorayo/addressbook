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

public class Validator {
    private boolean check;
    private User current = new User();
    
    public boolean validate( User user ) {
        ArrayList<User> list = ListUsers.getUserList();
        Iterator<User> itr = list.iterator();
            while ( itr.hasNext() ) {
                User element = itr.next();
                if ( element.getUserName().equals( user.getUserName() ) && element.getPassword().equals( user.getPassword() ) ) {
                    check = true;
                    current = element;
                }
                else
                   check =  false;
               }
    return check;
    }
    public User getCurrentUser() {
        return current;
    }
}

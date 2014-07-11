package edu.acc.capstone.addressbook;
/**
 *
 * @author Rayo
 */
import java.util.*;

public class Validator {
    private boolean check;
    private User current = null;
    
    public boolean validate( User user, ListUsers listOfUsers ) {
        ArrayList<User> userList = listOfUsers.getUserList();
        
        if( userList == null)
                   return false;
        
        Iterator<User> itr = userList.iterator();
            while ( itr.hasNext() ) {
                User element = itr.next();
                if ( element.getUserName().equals( user.getUserName() ) && element.getPassword().equals( user.getPassword() ) ) {
                    check = true;
                    current = element;
                    return check;
                }
                else 
                    check = false;
               }
    return check;
    }
    public boolean validateUser( User user, ListUsers listsOfUsers ) {
        ArrayList<User> userList = listsOfUsers.getUserList();
        
        if( userList == null)
                   return false;
        
        Iterator<User> itr = userList.iterator();
            while ( itr.hasNext() ) {
                User element = itr.next();
                if ( element.getUserName().equals( user.getUserName() ) ) {
                    check = true;
                    current = element;
                    return check;
                }
                else 
                    check = false;
               }
    return check;
    }
    
    public User getCurrentUser() {
        return current;
    }
}

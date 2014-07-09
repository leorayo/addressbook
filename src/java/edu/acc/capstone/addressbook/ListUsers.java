package edu.acc.capstone.addressbook;

/**
 *
 * @author Rayo
 */
import java.util.*;

public class ListUsers {
    //User user = new User();
    private ArrayList<User> userList = new ArrayList<>();

   
    public ListUsers() {}
    
    public ListUsers( ArrayList<User> userList ) {
        this.userList = userList;
    } 
    /**
     * @return the userList
     */
    public ArrayList<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void updateUserList( User user ) {
        userList.add( user );
    }
    
}

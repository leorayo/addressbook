
package edu.acc.capstone.addressbook;

/**
 *
 * @author Rayo
 */
import java.io.*;
import java.util.*;

public class User implements Serializable {
    private String userName;
    private String password;
    private ArrayList<Person> personList = new ArrayList<>();

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName( String userName ) {
        this.userName = userName;
    }

    /**
     * @param password the password to set
     */
    public void setPassword( String password ) {
        this.password = password;
    }

    /**
     * @return the personList
     */
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    /**
     * @param personList the personList to set
     */
    public void setPersonList( Person person ) {
        personList.add( person );
    }
    public void deletePerson( Person person ) {
        personList.remove( person );
    }
    
    
}

package edu.acc.capstone.addressbook;
/**
 *
 * @author Rayo
 */
import java.util.*;
        
public class PersonSearch {
    private Person person = new Person();
    
    public Person search( String firstName, String lastName, User user) {
       ArrayList<Person> list = user.getPersonList();
       Iterator<Person> itr = list.iterator();
            while ( itr.hasNext() ) {
                Person element = itr.next();
                if ( element.getFirstName().equals( firstName ) && element.getLastName().equals( lastName ) ) {
                    person = element;
                }
                else
                   person =  null;
               }
    return person; 
    }
}

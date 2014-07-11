package edu.acc.capstone.addressbook;
/**
 *
 * @author Rayo
 */
import java.util.*;
        
public class PersonSearch {
    private Person person;
    
    public Person search( String firstName, String lastName, User user) {
       ArrayList<Person> personList = user.getPersonList();
       
       if( personList == null)
                   return null;
       
       Iterator<Person> itr = personList.iterator();
            while ( itr.hasNext() ) {
                Person element = itr.next();
                if ( element.getFirstName().equals( firstName ) && element.getLastName().equals( lastName ) ) {
                    person = element;
                    return person ;
                }
                else
                   person =  null;
               }
    return person; 
    }
}

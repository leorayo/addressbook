package edu.acc.capstone.addressbook;
/**
 *
 * @author Rayo
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import java.util.*;

public class UpdatePersonServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String firstName = request.getParameter( "firstName" );
        String lastName = request.getParameter( "lastName" );        
        String address = request.getParameter( "address" );
        String emailAddress = request.getParameter( "emailAddress" );
        String phoneNumber = request.getParameter( "phoneNumber" );
        String birthday = request.getParameter( "birthday" );
        String notes = request.getParameter( "notes" );
        //String originalPersonFirst = request.getParameter( "originalPersonFirst" );
        //String originalPersonLast = request.getParameter( "originalPersonLast" );
        
        User user = (User)request.getSession().getAttribute( "user" );
              
           Person person = new Person();
           PersonSearch myPerson = new PersonSearch();
           person = myPerson.search( firstName, lastName, user );
          // person = myPerson.search( originalPersonFirst, originalPersonLast, user );
           if ( person == null ) {
                request.setAttribute( "notFound", firstName + " " + lastName + " is not in your addressbook." );
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "content.jsp" ).forward( request, response );
                return;
           }
        
        person.setFirstName( firstName );
        person.setLastName( lastName );
        person.setAddress( address );
        person.setEmailAddress( emailAddress );
        person.setPhoneNumber( phoneNumber );
        person.setBirthday( birthday );
        person.setNotes( notes );
        //user.setPersonList( addPerson );
        request.setAttribute( "add", firstName + lastName + " updated." );
        session.setAttribute( "user", user );
        session.setAttribute( "person", person );
        request.getRequestDispatcher( "display.jsp" ).forward( request, response );
              
    }
}

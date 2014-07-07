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
//import edu.acc.j2ee.crapsv3.PlayerDAO;

public class WorkServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String firstName = request.getParameter( "firstname" );
        String lastName = request.getParameter( "lastName" );
        String search = request.getParameter( "search" );
        String delete = request.getParameter( "delete" );
        String add = request.getParameter( "add" );
        String address = request.getParameter( "address");
        String emailAddress = request.getParameter( "emailAddress" );
        String phoneNumber = request.getParameter( "phoneNumber" );
        String birthday = request.getParameter( "birthday" );
        
        User user = (User)request.getSession().getAttribute( "user" );
        
        if ( search != null ) {
           Person person = new Person();
           PersonSearch myPerson = new PersonSearch();
           person = myPerson.search( firstName, lastName, user );
           if ( person == null ) {
               request.setAttribute( "notFound", firstName + lastName + " wast not found!");
               request.getRequestDispatcher( "content.jsp" ).forward( request, response );
           }
           else {
           session.setAttribute( "person", person );
           request.getRequestDispatcher( "display.jsp" ).forward( request, response );
           }
           
        }
        else if ( delete != null ) {
           Person person = new Person();
           PersonSearch myPerson = new PersonSearch();
           person = myPerson.search( firstName, lastName, user );
           ArrayList<Person> personList = user.getPersonList();
           user.deletePerson( person );
           request.setAttribute( "delete", person.getFirstName() + " was deleted" );
           session.setAttribute( "user", user );
           request.getRequestDispatcher( "content.jsp" ).forward( request, response );
        }
        else if ( add != null ) {
            session.setAttribute( "user", user );
            request.getRequestDispatcher( "addPerson.jsp" ).forward( request, response );
        }
        
        
        Person addPerson = new Person();
        addPerson.setFirstName( firstName );
        addPerson.setLastName( lastName );
        addPerson.setAddress( address );
        addPerson.setEmailAddress( emailAddress );
        addPerson.setPhoneNumber( phoneNumber );
        addPerson.setBirthday( birthday );
        user.setPersonList( addPerson );
        request.setAttribute( "add", addPerson.getFirstName() + addPerson.getLastName() + " was added" );
        session.setAttribute( "user", user );
        session.setAttribute( "person", addPerson );
        request.getRequestDispatcher( "display.jsp" ).forward( request, response );
       
        
    }
}
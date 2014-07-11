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

public class WorkServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String firstName = request.getParameter( "firstName" );
        String lastName = request.getParameter( "lastName" );
        String addAnewPerson = request.getParameter( "addAnewPerson" );
        String work = request.getParameter( "work" );
        String search = null;
        String deleted = null;
        String add = null;
        String update = null;
       
        if ( work != null && work.equals( "search" )  ) search = work;
        if ( work != null && work.equals( "deleted" )) deleted = work;
        if ( work != null && work.equals( "add" ) ) add = work;
        if ( work != null && work.equals( "update" ) ) update = work;
        
        if ( search == null && deleted == null && add == null && addAnewPerson == null && update == null ){
            request.setAttribute( "firstName", firstName );
            request.setAttribute( "lastName", lastName );
            request.setAttribute( "chooseOption", "You must choose of one these options!" );
            request.getRequestDispatcher( "content.jsp" ).forward( request, response );
               return;
        }
        
        String address = request.getParameter( "address" );
        String emailAddress = request.getParameter( "emailAddress" );
        String phoneNumber = request.getParameter( "phoneNumber" );
        String birthday = request.getParameter( "birthday" );
        String notes = request.getParameter( "notes" );
        //String addAnewPerson = request.getParameter( "addAnewPerson" );
        
        User user = (User)request.getSession().getAttribute( "user" );
               
        if ( search != null ) {
           Person person = new Person();
           PersonSearch myPerson = new PersonSearch();
           person = myPerson.search( firstName, lastName, user );
           if ( person == null ) {
               request.setAttribute( "notFound", firstName + " "+ lastName + " is not in your addressbook" );
               request.getRequestDispatcher( "content.jsp" ).forward( request, response );
               return;
           }
           else {
           session.setAttribute( "person", person );
           request.getRequestDispatcher( "display.jsp" ).forward( request, response );
           return;
           }
           
        }
        else if ( deleted != null ) {
           Person person = new Person();
           PersonSearch myPerson = new PersonSearch();
           person = myPerson.search( firstName, lastName, user );
           //ArrayList<Person> personList = user.getPersonList();
           if ( person == null ) {
                request.setAttribute( "notFound", firstName + " " + lastName + " is not in your addressbook." );
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "content.jsp" ).forward( request, response );
                return;
           }
           else {
                user.deletePerson( person );
                request.setAttribute( "deleted", firstName + " " + lastName+ " was deleted." );
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "content.jsp" ).forward( request, response );
                return;
           }
        }
        else if ( add != null ) {
            request.setAttribute( "personFirstName", firstName );
            request.setAttribute( "personLastName", lastName );
            session.setAttribute( "user", user );
            request.getRequestDispatcher( "addPerson.jsp" ).forward( request, response );
            return;
        }
        else if ( update != null ) {
            /*request.setAttribute( "personFirstName", firstName );
            request.setAttribute( "personLastName", lastName );
            session.setAttribute( "user", user );
            request.getRequestDispatcher( "updatePerson.jsp" ).forward( request, response );
            return;*/
            Person person = new Person();
           PersonSearch myPerson = new PersonSearch();
           person = myPerson.search( firstName, lastName, user );
           //ArrayList<Person> personList = user.getPersonList();
           if ( person == null ) {
                request.setAttribute( "notFound", firstName + " " + lastName + " is not in your addressbook." );
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "content.jsp" ).forward( request, response );
                return;
           }
           else {
                session.setAttribute( "user", user );
                session.setAttribute( "person", person); //!!!!!!!!!!!!!
                request.getRequestDispatcher( "updatePerson.jsp" ).forward( request, response );
                return;
           }
        }
            
        Person addPerson = new Person();
        addPerson.setFirstName( firstName );
        addPerson.setLastName( lastName );
        addPerson.setAddress( address );
        addPerson.setEmailAddress( emailAddress );
        addPerson.setPhoneNumber( phoneNumber );
        addPerson.setBirthday( birthday );
        addPerson.setNotes( notes );
        user.setPersonList( addPerson );
        request.setAttribute( "add", firstName + lastName + " was added." );
        session.setAttribute( "user", user );
        session.setAttribute( "person", addPerson );
        request.getRequestDispatcher( "display.jsp" ).forward( request, response );
              
    }
}
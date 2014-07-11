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


public class DeleteUserServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" ) ;
        //String register = request.getParameter( "register" );
        
        if( password.equals( "" ) && userName.equals( "" ) ) {
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.getRequestDispatcher( "login.jsp" ).forward( request, response );
            return;
        } 
        if ( password.equals( "" ) && password.equals( "" ) ) {
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            return;
        } 
        if( userName.equals( "" ) )  {         
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.getRequestDispatcher( "login.jsp" ).forward( request, response );
            return;
        }   
        if( password.equals( "" ) ) {
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.setAttribute( "userName", userName );
            request.getRequestDispatcher( "login.jsp" ).forward( request, response );
            return;
        }
       
        else {
        
            User user = new User();
            user.setUserName( userName );
            user.setPassword( password );
            
            ServletContext context = request.getServletContext();
            ListUsers listOfUsers = (ListUsers)context.getAttribute( "listOfUsers" );
            
            Validator validate = new Validator();
            boolean check = validate.validate( user, listOfUsers );
            
            if ( check == true ) {
            user = validate.getCurrentUser(); 
           // HttpSession session = request.getSession();
            listOfUsers.deleteUser( user );
            context.setAttribute( "listOfUsers", listOfUsers );
            request.setAttribute( "deletedUser", "Your account was deleted" );
            //session.setAttribute( "user", user );
            request.getRequestDispatcher( "login.jsp" ).forward( request, response );
            return;
            }
        
            else {
           request.setAttribute( "invalid", "This account is not registered" );
           request.getRequestDispatcher( "deleteUser.jsp" ).forward( request, response );
           return;
            }                 
        }
    }
}
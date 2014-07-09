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


public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" ) ;
        String register = request.getParameter( "register" );
        
        if( (register.equals("") || register.equals( null )) && ( password.equals( "" ) || password.equals( null )) && ( userName.equals( "" ) || userName.equals( null ) ) ) {
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.getRequestDispatcher( "login.jsp" ).forward( request, response );
            return;
        }
        if( (register.equals("") || register.equals( null )) && ( userName.equals( "" ) || userName.equals( null ) ) ) {
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.setAttribute( "password", password );
            request.getRequestDispatcher( "login.jsp" ).forward( request, response );
            return;
        }
        
        if ( (register.equals("") || register.equals( null )) && ( password.equals( "" ) || password.equals( null ) ) ) {
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.setAttribute( "userName", userName );
            request.getRequestDispatcher( "login.jsp" ).forward( request, response );
            return;
        }
       
        
        if ( register != null ) {
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            return;
        }
        else {
        
            User user = new User();
            user.setUserName( userName );
            user.setPassword( password );
            
            ServletContext context = request.getServletContext();
            ListUsers listOfUsers = (ListUsers)context.getAttribute( "listOfUsers" );
            
            //ArrayList<User> list = new ArrayList<User>();
            Validator validate = new Validator();
            boolean check = validate.validate( user, listOfUsers );
            
            
            if ( check == true ) {
            user = validate.getCurrentUser(); 
            HttpSession session = request.getSession();
            context.setAttribute( "listOfUsers", listOfUsers );
            //this.getServletContext().setAttribute( "list", users );
            session.setAttribute( "user", user );
            request.getRequestDispatcher( "content.jsp" ).forward( request, response );
            return;
            }
        
            else {
           request.setAttribute( "invalid", "Access denied, you are not registered." );
           request.getRequestDispatcher( "register.jsp" ).forward( request, response );
           return;
            }                 
        }
    }
}


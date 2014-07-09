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
//import edu.acc.j2ee.crapsv3.Player;
//import edu.acc.j2ee.crapsv3.PlayerDAO;

public class RegisterServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" ) ;
        String haveAccount = request.getParameter( "haveAccount" );
        
        if( ( haveAccount.equals("") || haveAccount.equals( null )) && ( password.equals( "" ) || password.equals( null )) && ( userName.equals( "" ) || userName.equals( null ) ) ) {
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            return;
        }
        if( ( haveAccount.equals("") || haveAccount.equals( null )) && ( userName.equals( "" ) || userName.equals( null ) ) ) {
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.setAttribute( "password", password );
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            return;
        }
        
        if ( ( haveAccount.equals("") || haveAccount.equals( null )) && ( password.equals( "" ) || password.equals( null ) ) ) {
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.setAttribute( "userName", userName );
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            return;
        }
        
        if ( haveAccount != null ) {
            request.getRequestDispatcher( "login.jsp" ).forward( request, response );
            return;
        }
        else {
        
            User user = new User();
            user.setUserName( userName );
            user.setPassword( password );
        
       
              
        
            ServletContext context = request.getServletContext();
            ListUsers listOfUsers = (ListUsers)context.getAttribute( "listOfUsers");

            Validator validate = new Validator();
            boolean check = validate.validateUser( user, listOfUsers );     
        
            if ( check == true ) {
                session.setAttribute( "user", user);
                request.setAttribute( "invalid", "The user name " + user.getUserName() + " is already taken." );
                request.getRequestDispatcher( "register.jsp" ).forward( request, response );
                return;
            }
        
            else { 
            //ListUsers.updateUserList( user );
                listOfUsers.updateUserList( user );
            //list = list.getUserList();
            //session.setAttribute( "listUser", list);
                context.setAttribute( "list", listOfUsers);
            //this.getServletContext().setAttribute( "list", list );
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "content.jsp" ).forward( request, response );
                return;
            }
        }
    }
}

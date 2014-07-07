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
        
        User user = new User();
        user.setUserName( userName );
        user.setPassword( password );
        
        Validator validate = new Validator();
        boolean check = validate.validate( user );
        
        
        
        if ( check == true ) {
            session.setAttribute( "user", user );
            request.setAttribute( "invalid", "The user name" + user.getUserName() + " is already taken" );
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
        }
        
        else { 
            ListUsers.updateUserList( user );
            session.setAttribute( "user", user );
            request.getRequestDispatcher( "content.jsp" ).forward( request, response );
        }
    }
}

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

public class ContentServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" );
        
        User user = new User();
        user.setUserName( userName );
        user.setPassword( password );
        
        Validator validate = new Validator();
        boolean check = validate.validate( user );
        
        if ( check == true ) {
            request.getRequestDispatcher( "content.jsp" ).forward( request, response );
        }
        
        else {
           request.setAttribute( "invalid", "you are not register" );
           request.getRequestDispatcher( "register.jsp" ).forward( request, response );
        }
    }
}


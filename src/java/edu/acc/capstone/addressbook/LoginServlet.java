/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" ) ;
        String register = request.getParameter( "register" );
        
        if ( register != null ) {
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            return;
        }
        else {
        
            User user = new User();
            user.setUserName( userName );
            user.setPassword( password );
            
           // ArrayList<User> list = (ArrayList<User>)request.getSession().getAttribute( "listUser" );
            ArrayList<User> list = new ArrayList<User>();
            Validator validate = new Validator();
            boolean check = validate.validate( user, list );
            
            
            if ( check == true ) {
            user = validate.getCurrentUser(); 
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            request.getRequestDispatcher( "content.jsp" ).forward( request, response );
            return;
            }
        
            else {
           request.setAttribute( "invalid", "you are not register" );
           request.getRequestDispatcher( "register.jsp" ).forward( request, response );
           return;
            }                 
        }
    }
}


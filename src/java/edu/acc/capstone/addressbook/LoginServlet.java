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
        
        HttpSession session = request.getSession();
        
        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" ) ;
        String register = request.getParameter( "register" );
        
        if ( register != null ) request.getRequestDispatcher( "register.jsp" ).forward( request, response );
        else {
        
            User user = new User();
            user.setUserName( userName );
            user.setPassword( password );
        
            Validator validate = new Validator();
            boolean check = validate.validate( user );
            
            
            if ( check == true ) {
            user = validate.getCurrentUser();   
            session.setAttribute( "user", user );
            request.getRequestDispatcher( "content.jsp" ).forward( request, response );
            }
        
            else {
           request.setAttribute( "invalid", "you are not register" );
           request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            }                 
        }
    }
}


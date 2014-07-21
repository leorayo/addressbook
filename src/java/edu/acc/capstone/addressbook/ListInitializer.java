/**
 * This class will create a new list of users from the list of users java class
 * that will be initiated at the launch of the application. I will be used to
 * keep track of the registered users and their attributes.
 */
package edu.acc.capstone.addressbook;
/**
 * @author Leobardo Rayo
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.*;

public class ListInitializer implements ServletContextListener {

    @Override
    public void contextInitialized( ServletContextEvent sce ) {
        //instantiate a list and attach it to the context scope
        ServletContext ctx = sce.getServletContext();
        ListUsers listOfUsers = new ListUsers();
        ctx.setAttribute( "listOfUsers", listOfUsers );
        
    }

    @Override
    public void contextDestroyed( ServletContextEvent sce ) {
    }
    
}

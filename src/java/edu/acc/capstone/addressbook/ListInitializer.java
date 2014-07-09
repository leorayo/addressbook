package edu.acc.capstone.addressbook;
/**
 *
 * @author Rayo
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.*;

public class ListInitializer implements ServletContextListener {

    @Override
    public void contextInitialized( ServletContextEvent sce ) {
        ServletContext ctx = sce.getServletContext();
        ListUsers listOfUsers = new ListUsers();
        
        ctx.setAttribute( "listOfUsers", listOfUsers );
        //sce.getServletContext().setAttribute( "listInitializer", list );
        //this.getServletContext().setAttribute( "listInitializer", list );
    }

    @Override
    public void contextDestroyed( ServletContextEvent sce ) {
    }
    
}

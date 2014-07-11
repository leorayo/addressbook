<%-- 
    Document   : logout
    Created on : Jul 6, 2014, 5:04:20 PM
    Author     : Rayo
--%>
       <% 
		   session.invalidate();
           response.sendRedirect( "login.jsp" );
		%>
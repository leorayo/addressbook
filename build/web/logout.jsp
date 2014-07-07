<%-- 
    Document   : logout
    Created on : Jul 6, 2014, 5:04:20 PM
    Author     : Rayo
--%>

<html>
	<head>
       <% 
		   session.invalidate();
		%>
        <meta http-equiv="refresh" content="0; url=login.jsp">
    </head>
	<body>
	</body>
</html>
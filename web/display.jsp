<%-- 
    Document   : display
    Created on : Jul 6, 2014, 7:02:01 PM
    Author     : Rayo
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="person" class="edu.acc.capstone.addressbook.Person" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Display</title>

<style>
 html, body {
text-align: center;
}
p {text-align: left;}

body {
	margin: 0;
	padding: 0;
	background: #697281;
	text-align: left;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #F1F5F8;
	background-color:#2A2A2A;
}
*
{
  margin: 0 auto 0 auto;
 text-align:left;}


html, body {
text-align: center;
}
p {text-align: left;}





#page
{
  margin: 0 auto 0 auto; 
  margin-top:25px;
  display: block; 
  height:auto;
  position: relative; 
  overflow: hidden; 
  background: url(images/background.png) repeat-y;
  width: 738px;
}

#header
{
background-image:url(images/header.png);
background-repeat:no-repeat;
height:111px;
width:738px;
}

#header h1
{
position:relative;
left:30px;
top:25px;
color:#F6F6F6;
text-align:left;
font-size:40px;
font-weight:bold;
font-family:Arial, Helvetica, sans-serif;
}

#header h2
{
position:relative;
left:33px;
top:21px;
color:#2C2C2C;
text-align:left;
font-size:17px;
font-weight:bold;
font-family:Arial, Helvetica, sans-serif;
}


#bar
{
background-image:url(images/bar.png);
background-repeat:no-repeat;
height:55px;
width:750px;
line-height:55px;
padding-left:20px;
padding-right:20px;
}

#bar .link
{
float:left;
height:55px;
}

#bar .link:hover
{
background-image:url(images/linkrollover.png);
background-repeat:no-repeat;
background-position:center;


}


#bar a
{
font-size:14px;
font-weight:bold;
color:#FBFDFB;
margin-left:27px;
margin-right:27px;

}

#bar a:hover
{
color:#999999;
}



.contentTitle
{
width:676px;
height:37px;
margin-top:20px;
margin-left:25px;
margin-right:25px;
margin-bottom:10px;
background-image:url(images/tab_back.png);
background-repeat:no-repeat;

}

.contentTitle h1
{
margin-left:10px;
padding-top:8px;
font-size:20px;
font-weight:bold;
color:#071027;
}

.comments
{
font-size:11px;
font-style:italic;
}

.contentText
{
width:680px;
padding-left:30px;
padding-right:30px;
font-size:13px;
color:#030712;
line-height:30px;
letter-spacing:-1px;
}

a
{
text-decoration:none;
color:#2A2A2A;
border-bottom:1px dashed #2A2A2A;
}

a:hover
{
color:#8F8F8F;
border-bottom:1px dotted #2A2A2A;
}


#footer {
width: 738px;
height:53px;
background: url(images/footer.png) no-repeat;
text-align:center;
font-size:9px;
color:#2A2A2A;
padding-top:25px;
}

   
    
</style>

</head>
    
<body>
    <div id="page">
		
        <div id="header">
        	<h1>${person.firstName} ${person.lastName}</h1>
            <h2></h2>
            
      </div>
  <div id="bar">
        	
            <div class="link"><a href="logout.jsp">Logout</a></div>
            <div class="link"><a href="content.jsp">Home</a></div>
            
      </div>
        <div class="contentTitle"><h1>${person.firstName} ${person.lastName}'s information</h1></div>
        <div class="contentText">
            
            First Name: ${person.firstName}
            <br />
            Last Name: ${person.lastName}
            <br />
            Address: ${person.address}
            <br />
            Email Address: ${person.emailAddress}
            <br />
            Phone Number: ${person.phoneNumber}
            <br />
            Birthday: ${person.birthday}

        </div>
        <div class="contentTitle"><h1></h1></div>
        <div class="contentText">
          
        </div>
          
</div>
        <div id="footer"><a href=""></a><a href=""></a></div>
</body>
</html> 
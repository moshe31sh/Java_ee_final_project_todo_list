<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html/; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./CSS/style.css">

<title>Login</title>
</head>
<body>
<nav id="navigation-menu"><ul>
<li><a href="./SignIn.jsp">Sign-in</a></li>
<li><a href="./LogIn.jsp">Login</a></li>
</ul></nav>
<form id="login-form" method="get" action="/Toto_list_final_project/ToDoListAuthenticationController">
    <table>
    <tr><td>id:</td><td><input  type="text" placeholder="id" name="id"  title="Inset Id"/></td></tr>    
    <tr><td>password:</td><td><input type="password" size ="20" name="pass" placeholder="password" title="Inset Pass"/></td></tr>
</table>
   
    <input class="submit" type="submit"/>
</form>

</body>
</html>
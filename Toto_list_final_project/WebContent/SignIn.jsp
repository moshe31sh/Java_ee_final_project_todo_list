<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errorPage="/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html/; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./CSS/style.css">

<title>Sign-In</title>
</head>
<body>

<nav id="navigation-menu">
<ul>
<li><a href="/Toto_list_final_project/SigninController/signin">Sign-in</a></li>
<li><a href="/Toto_list_final_project/ToDoListController/login">Login</a></li>
</ul></nav>
<form id="login-form" method="post" action="/Toto_list_final_project/SigninController/signin">
    <table>
    <tr><td>first name:</td><td><input  type="text" placeholder="First Name" name="fname"/></td></tr> 
        <tr><td>last name:</td><td><input  type="text" placeholder="last Name" name="lname"/></td></tr>    
        <tr><td>id:</td><td><input  type="text" placeholder="Id" name="id"/></td></tr>    
    <tr><td>password:</td><td><input type="password" size ="20" name="password" placeholder="password" title="Inset Pass"/></td></tr>
</table>
   
    <input class="submit" type="submit"/>
</form>

</body>
</html>
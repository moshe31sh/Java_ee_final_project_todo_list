<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*" errorPage="/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/user_menu_style.css">
<title>User-Dashboard</title>
</head>
<body>



<div id="leftBar">
<%
User currentUser = (User)session.getAttribute("user");
if (currentUser == null){
out.println("<jsp:forword page=/login.jsp/>");
}
String userName = currentUser.getUserName().substring(0,1).toUpperCase();
userName = userName + currentUser.getUserName().substring(1); 

out.println("<div class=\"hellouser\">"+"Hello "+userName+"</div>");
%>	

<a class="button" href="/Toto_list_final_project/controller/adminsession">Session</a>
<a class="button"href="/Toto_list_final_project/controller/userlist">User-list</a>
<a class="button"href="/Toto_list_final_project/controller/login">Log-Out</a>



</div>
</body>
</html>
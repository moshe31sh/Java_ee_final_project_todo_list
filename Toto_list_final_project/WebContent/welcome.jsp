<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*" errorPage="/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<Script language="JavaScript">
alert("d")
setTimeout("window.focus()",1000);
</Script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Authentication succeed...</h2>

<%
RequestDispatcher dispatcher = null;
dispatcher = getServletContext().getRequestDispatcher("/controller/items");	
dispatcher.forward(request, response);
%> 
</body>
</html>
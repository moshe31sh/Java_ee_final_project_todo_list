<%@page import="scala.collection.parallel.ParIterableLike.Foreach"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.* , java.util.*" errorPage="/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./CSS/user_menu_style.css">
<title>My task</title>
<jsp:include page="usermenu.jsp"/>
</head>
<body>
<div class="container">

<%
Map<Integer , ToDoListItem> userTasks = (Map<Integer , ToDoListItem>)session.getAttribute("items");
//Collection<ToDoListItem> items = (Collection<ToDoListItem>)session.getAttribute("items");
out.println("<table border='1'>");
out.println("<tr><th>Id</th><th>Title</th><th>Description</th><th>Status</th><tr></tr>");
//Set keys = userTasks.keySet();

for(Map.Entry<Integer , ToDoListItem> userTask : userTasks.entrySet()){
//for(ToDoListItem item : userTasks) {
	out.println("<tr><td>"+userTask.getKey()+"</td><td>"+userTask.getValue().getTitle()+"</td><td>"+userTask.getValue().getDescription()+"</td><td>"+userTask.getValue().getStatus()+"</td></tr>");	
}
out.println("</table>");
%> 
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="model.* , java.util.*" errorPage="/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html/; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./CSS/add_task_style.css">

<title>Add new task</title>
<jsp:include page="usermenu.jsp"/>
</head>
<body>
<div class="container">
<h2>Delete  task</h2>
<%
Map<Integer , ToDoListItem> userTasks = (Map<Integer , ToDoListItem>)session.getAttribute("items");
out.println("<table border='1'>");
out.println("<tr><th>Id</th><th>Title</th><th>Description</th><th>Status</th><tr></tr>");

for(Map.Entry<Integer , ToDoListItem> userTask : userTasks.entrySet()){
	out.println("<tr><td>"+userTask.getKey()+"</td><td>"+userTask.getValue().getTitle()+"</td><td>"+userTask.getValue().getDescription()+"</td><td>"+userTask.getValue().getStatus()+"</td></tr>");	
}
out.println("</table>");
%> 
</br>
<form id="deletetask" method="post" action="/Toto_list_final_project/ToDoListController/deletetask">
    <table>
    <tr><td>id:</td><td><input  type="text" name="id"  title="Inset Id" /></td></tr>    
</table>
   
    <input class="submit" type="submit"/>
</form>
</div>
</body>
</html>
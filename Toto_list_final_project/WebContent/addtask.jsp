<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html/; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/style.css">

<title>Add new task</title>
<jsp:include page="usermenu.jsp"/>
</head>
<body>
<div class="container">
<h2>Add new task</h2>
</br>
<form id="addTask" method="post" action="/Toto_list_final_project/ToDoListController/addtask">
    <table>
    <tr><td>title:</td><td><input  type="text" placeholder="title" name="title"  title="Insert Title"/></td></tr>    
     <tr><td>description:</td><td><input  type="text" placeholder="description" name="description"  title="Insert Description"/></td></tr>    
       

</table>
   
    <input class="submit" type="submit"/>
</form>
</div>
</body>
</html>
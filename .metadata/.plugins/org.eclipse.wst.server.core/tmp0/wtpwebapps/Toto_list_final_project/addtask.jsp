<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Add new task</title>
<jsp:include page="usermenu.jsp"/>
</head>
<body>
<div class="container">
<form id="addTask" method="post" action="">
<div class="form-group">
<label for="title">Title</label>
    <input type="text" class="form-control" name="title">
</div>
<div class="form-group">
<label for="description">Description</label>
    <input type="text" class="form-control" name="description">
</div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</body>
</html>
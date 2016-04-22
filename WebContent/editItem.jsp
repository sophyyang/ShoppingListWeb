<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit An Item</title>
</head>
<body>
<%
String oldStore = (String)request.getAttribute("store");
String oldItem = (String)request.getAttribute("item");

%>
<form method = "post" action = "changeItemServlet">
store: <input type= "text" name = "newStore" value = "<%=oldStore%>">
Item: <input type= "text" name = "newItem" value = "<%=oldItem%>">
<input type= "hidden" name = "oldStore" value = "<%=oldStore%>">
<input type= "hidden" name = "oldItem" value = "<%=oldItem%>">
<input type= "submit"   value = "change item" >
</form>
<a href = "index.html"> Back to Full List</a>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.util.ArrayList, model.ListItem" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kelli's Shopping List</title>
</head>
<body>
<form method = "post" action="MasterController">
<%
@SuppressWarnings("unchecked")
ArrayList<ListItem> allItems = (ArrayList<ListItem>)request.getAttribute("items");
%>
<table border = 1 cellpadding = 5>
	<tr>
		<th>Select</th>
		<th>Store</th>
		<th>Item</th>
		</tr>

<%
//about to cycle through the arrayList and put them into the appropriate cells

for(int tempIndex = 0; tempIndex < allItems.size(); tempIndex++){
%>
<tr>
	<td><input type = "radio" name = "id" value = "<%=tempIndex %>"></td>
	<td><%= allItems.get(tempIndex).getStore() %> </td>
	<td><%= allItems.get(tempIndex).getItem() %> </td>
	</tr>
<%
} //closing for loop bracket
%>
</table>
<input type = "submit" name = "doThisToItem" value = "edit item">
<input type = "submit" name = "doThisToItem" value = "delete item">
<input type = "submit" name = "doThisToItem" value = "add item">
</form>
</body>
</html>
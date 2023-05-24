<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Name selection</title>
</head>
<body>
	<form action="salutation" method="post">
		<select name="name">
			<%
			//retrieve the list of names from the session object
			List<String> names = (List<String>) session.getAttribute("names");
			//create an option element for each item in the list of names
			//the servet in form's action will be able to retrieve the selected name
			//by getting the value of the parameter "name" (the name of the select element)
			//which will be set to the value of the selected option
			for (int i = 0; i < names.size(); i++) {
			%>
			<option value="<%=i%>"><%=names.get(i)%></option>
			<%
			}
			%>
		</select>
		<button type="submit">Go!</button>
	</form>
</body>
</html>

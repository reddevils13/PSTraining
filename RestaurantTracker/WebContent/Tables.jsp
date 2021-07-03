<%@page import="com.to.Restaurants"%>
<%@page import="java.util.List"%>
<%@page import="com.to.Tables"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tables</title>
</head>
<body>
	<h1>Available Tables</h1>
	<%
	Restaurants res = (Restaurants) session.getAttribute("restaurants");
	List<Tables> tables = (List<Tables>) request.getAttribute("tables");

	String message = null;

	if (request.getAttribute("message") != null) {
		message = request.getAttribute("message").toString();
	}
	%>
	<h1 class="name">
		Restaurant Name :
		<%=res.getRname()%>
	</h1>
	<div>
		

		<%
		if (tables != null) {
		%>
		<br>
		<table border='1'>
			<tr>
				<th>Table Id</th>
				<th>status</th>

			</tr>

			<%
			for (Tables t : tables) {
			%>
			<tr>
				<td><%=t.getTid()%></td>
				<td><%=t.getStatus()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>
	<br>
	<%
		if (message != null) {
		%>
			<h1><%=message %></h1>
			
		<%
		//tables = (List<Tables>) request.getAttribute("tables");
		}
		else {
		%>
		<div>
		<form action="TableController" method="post">
			<br></>Book a Table:-<input type='text' name='tid'
				placeholder='Table id'> <input type="hidden" name='h1'
				value='book'> <br> <input type='submit'
				value='Book Table'>
		</form>
	</div>
		<%} %>
	


</body>
</html>
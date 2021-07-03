<%@page import="java.util.List"%>
<%@page import="com.to.Restaurants"%>
<%@page import="com.to.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Tracker</title>
<h1>Available Restaurants</h1>
</head>
<body>
	<%
	//User user1 = new User("u10","email10@gmail.com","password10","name10","12678");
	User user1 = (User) session.getAttribute("user");
	List<Restaurants> restaurants = (List<Restaurants>) request.getAttribute("restaurants");
	int h1 = 0;
	if (request.getAttribute("button") != null) {
		h1 = Integer.parseInt(request.getAttribute("button").toString());
	}
	%>
	<h1 class="name">
		Name :
		<%=user1.getName()%>
	</h1>

	<div>
		<form action="RestaurantController" method="post">
			<input type="hidden" name='h1' value='display'> <input
				type='submit' name='display' value='Display Available Restaurants'><br>
		</form>
	</div>

	<div>
		<%
		if (restaurants != null) {
		%>
		<br>
		<table border='1'>
			<tr>
				<th>Restaurant Id</th>
				<th>Name</th>
				<th>Location</th>

			</tr>

			<%
			for (Restaurants res : restaurants) {
			%>
			<tr>
				<td><%=res.getRid()%></td>
				<td><%=res.getRname()%></td>
				<td><%=res.getLocation()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>

	<div>
		<%
		if (h1 == 1) {
		%>
		<br>
		<form action="RestaurantController" method="post">
			<br></>Book a Restaurant:-<input type='text' name='rid'
				placeholder='restaurant id'> <input type="hidden" name='h1'
				value='book'> <br> <input type='submit'
				value='Proceed to Book Table'>
		</form>
		<%
		}
		%>
	</div>

</body>
</html>
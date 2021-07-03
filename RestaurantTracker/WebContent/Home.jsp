<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><h1>Welcome to Restaurant Tracker</h1></title>
<h1>Welcome to Restaurant Tracker</h1>
</head>
<body>
	<%
	int choice = 0;
	if (request.getAttribute("choice") != null) {
		choice = Integer.parseInt(request.getAttribute("choice").toString());
	}
	

	String message = null;

	if (request.getAttribute("message") != null) {
		message = request.getAttribute("message").toString();
	}
	%>
	<div>
		<form action='LoginController' method='post'>
			<input type='hidden' name='h1' value='Home'> <br>Already
			a user? <br> <input type='submit' name='choice' value='SignIn'>
			<br>New User? <br> <input type='submit' name='choice'
				value='SignUp'>

		</form>

		<%
		if (choice == 100) {
		%>

		<form action='LoginController' method='post'>
			<br>
			<h1>Register Yourself</h1>

			<br> User ID : <input type='text' name="uid" /> <br>
			e-mail : <input type='text' name="email" /> <br> password : <input
				type='password' name="password" /> <br> name : <input
				type='text' name="name" /> <br> Phone No: <input type='text'
				name="phone" /> <input type="hidden" name='h1' value='NewRegister'><br>
			<input type="submit" value='Sign-Up' />
		</form>

		<%
		} else if (choice == 200) {
		%>

		<form action='LoginController' method='post'>
			<br>
			<h1>Login</h1>

			<br> User ID : <input type='text' name="uid" /> <br>
			password : <input type='password' name="password" /> <input
				type="hidden" name='h1' value='Login'><br> <input
				type="submit" value='Login' />
		</form>

		<%
		}
		%>



		<%
		if (message != null) {
		%>

		<h1><%=message%></h1>

		<%
		}
		%>

	</div>
</body>
</html>
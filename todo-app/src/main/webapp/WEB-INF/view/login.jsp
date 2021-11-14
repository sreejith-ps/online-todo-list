<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${errorMsg}</h2>
	<form method="post">
		<input type="text" name="username" placeholder="User name" /> <br><br>
		<input type="password" name="password" placeholder="Password" /> <br><br>
		<button>Login</button>
	</form>
</body>
</html>
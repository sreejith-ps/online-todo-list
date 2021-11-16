<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TODO App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>

	<div>
		<div class="navbar navbar-inverse">
			<a href="#" class="navbar-brand">TODO Application</a>
		</div>
	</div>

	<div class="container text-center">
		<p>
	        <font color="red">${errorMsg}</font>
	    </p>
		<form action="/login" method="POST" class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-md-5">Username</label>
				<div class="col-md-3">
					<input type="text" class="form-control" name="username" placeholder="Username" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-5">Password</label>
				<div class="col-md-3">
					<input type="password" class="form-control" name="password" placeholder="Password" />
				</div>
			</div>
			
			<button class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
</html>
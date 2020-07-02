<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login Page!!</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	
</head>
<body class="text-center">
	<div class="container">
	<br/>
	<br/>
	<br/>
	<br/>
		<h1>LOGIN FOR VETS</h1>


		${SPRING_SECURITY_LAST_EXCEPTION.message}


		<form class="form-signin" action="login" method="post">
			<div class="form-group">
				<label>Email address for vet:</label>
				 <input type="email" class="form-control" placeholder="Enter email" name="username" required>
			</div>
			<div class="form-group">
				<label>Password:</label>
				 <input type="password" class="form-control" placeholder="Password" name="password" required>
			</div>

			<button type="submit" name="submit" class="btn btn-primary">Submit</button>
		</form>


		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>
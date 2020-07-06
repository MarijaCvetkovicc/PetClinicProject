<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login Page!!</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body class="text-center">
	<div class="container">
		<br /> <br /> <br /> <br />
		<h1>LOGIN FOR VETS</h1>

		<c:if test="${param.error != null}">
			<div class="alert alert-danger" role="alert mb-2">
				Failed to login.
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                  Reason: <c:out 
						value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				</c:if>
			</div>
		</c:if>



		<form class="form-signin" action="login" method="post">
			<div class="form-group">
				<label>Email address for vet:</label> <input type="email"
					class="form-control" placeholder="Enter email" name="username"
					required>
			</div>
			<div class="form-group">
				<label>Password:</label> <input type="password" class="form-control"
					placeholder="Password" name="password" required>
			</div>

			<button type="submit" name="submit" class="btn btn-primary" >Submit</button>
		</form>
		
		<!-- <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Login message</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
					<c:choose>
						<c:when test="${param.error != null}">
							<div>
								Failed to login.
								<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                 		 Reason: <c:out
										value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
								</c:if>
							</div>
						</c:when>
						<c:otherwise>
							<div>
								<p>Successful login!!</p>
							</div>
						</c:otherwise>
						</c:choose>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>

					</div>
				</div>
			</div>
		</div> -->

		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Sign in</title>
		<link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
		<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
		<link href="<c:url value='/static/css/signin.css' />" rel="stylesheet">

	</head>

	<body>
	<div class="container">
		<c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method="post" class="form-sigin">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Invalid email and password.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>
			<div class="form-group">
                <label class="sr-only " for="inputEmail">Email address</label>
				<div class="col-sm-10">
					<input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email" required="" autofocus="">
				</div>
			</div>
			<div class="form-group">
                <label class="sr-only " for="inputEmail">Password</label>
				<div class="col-sm-10">
					<input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password" required="">
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="form-group">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-block btn-primary">Sign in</button>
				</div>
			</div>
		</form>
	</div>


	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/static/js/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/static/js/bootstrap.js"></script>
	</body>
</html>
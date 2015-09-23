<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
	<!--Hearder Bar-->
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">MUMScrum</a>
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="panel panel-default" style="margin: 50px 250px 50px 250px;">
		<div class="panel-heading" style="text-align: center;">
			<h3 class="panel-title">User Authentication</h3>
		</div>
		<div class="panel-body">
			<form:form class="form-horizontal" action="login" method="post"
				commandName="login">




				<div class="content">








					<div class="form-group">
						<label for="inputUser" class="col-sm-2 control-label">Username</label>
						<div class="col-sm-10">
							<form:input type="text" name="username" class="form-control"
								path="username" id="inputUser" placeholder="User name" />
							<form:errors path="username"></form:errors>
						</div>


					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<form:input type="password" name="password" class="form-control"
								path="password" id="inputPassword" placeholder="Password" />
							<form:errors path="password"></form:errors>
						</div>



					</div>

				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Login in</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>



</body>
</html>
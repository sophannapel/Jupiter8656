<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
</head>
<body>

	

	<form action="product" method="post">
		<!--  <label>ID</label> <input type="text" name="id" /> -->
		<label>Name</label> <input type="text" name="name" />
		<label>Start date</label> <input type="text" name="startDate" />
		<label>Due date</label> <input type="text" name="dueDate" />
		<label>Status</label> <input type="text" name="status" />
		<label>Description</label> <input type="text" name="description" />		
		<label>Employee ID</label> <input type="text" value="${userId}" name="employeeId" />
		<button>submit</button>
	</form>

</body>
</html>
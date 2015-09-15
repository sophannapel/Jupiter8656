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
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${productList}" var="product">

		<tr>
			<td>${product.id}</td>
			<td>${product.description}</td>
		</tr>

	</c:forEach>

	<form action="product" method="post">
		<label>Product id</label>
		<input type="text" name="id" />
		<label>Product name</label>
		<input type="text" name="name" />
		<button>submit</button>
	</form>


</body>
</html>
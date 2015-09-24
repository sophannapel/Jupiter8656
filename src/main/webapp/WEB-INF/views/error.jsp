<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>

	<c:if test="${not empty errCode}">
		<h2>Error code = ${errCode}</h2>
	</c:if>
	
	<c:if test="${empty errCode}">
		<h2>Error code : System Errors</h2>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h2>Error message : ${errMsg}</h2>
	</c:if>

</body>
</html>
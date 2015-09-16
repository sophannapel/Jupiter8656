<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${userStoryList}" var="userStory">

					<tr>
						<td>${userStory.id}</td>
						<td>${userStory.description}</td>
						<td>${userStory.developerId}</td>
						<td>${userStory.dueDate}</td>
						<td>${userStory.estimateDevEffort}</td>
						<td>${userStory.estimateTestEffort}</td>
						<td>${userStory.priority}</td>
						<td>${userStory.releaseId}</td>
						<td>${userStory.testId}</td>
						<td><a href="#">Edit</a> | <a href="">Delete</a></td>		
					</tr>
			
				</c:forEach>

</body>
</html>
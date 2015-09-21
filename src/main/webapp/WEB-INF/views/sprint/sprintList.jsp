<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE t:layout PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<table id="myTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Sprint Name</th>
				<th>Start Date</th>
				<th>Due Date</th>
				<th>Release</th>
				<th>Edit | Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sprintList}" var="sprintList">

				<tr>
					<td>${sprintList.id}</td>
					<td>${sprintList.name}</td>
					<td>${sprintList.startDate}</td>
					<td>${sprintList.dueDate}</td>
					<td>${sprintList.releaseBacklog.name}</td>
					<td><a href="editSprint?id=${sprintList.id}">Edit</a> | <a href="deleteSprint?id=${sprintList.id}">Delete</a></td>
				</tr>

			</c:forEach>
		</tbody>

	</table>




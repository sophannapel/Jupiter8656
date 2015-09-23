<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE t:layout PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:layout userName="${username}" userRole="${role}" contentTitle= "List of Release Backlog" activeMenuProduct="active">


	<table id="myTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Release Name</th>
				<th>Product Name</th>
				<th>Start Date</th>
				<th>Due Date</th>
				<th>Description</th>
				<th>Release Type</th>
				<th>Owner</th>
				<th>Scrum Master</th>
				<th>Edit | Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${releaseList}" var="releaseList">

				<tr>
					<td>${releaseList.id}</td>
					<td>${releaseList.name}</td>
					<td>${releaseList.product.name}</td>
					<td>${releaseList.formatStartDate()}</td>
					<td>${releaseList.formatDueDate()}</td>
					<td>${releaseList.descriptioon}</td>
					<td>${releaseList.type}</td>
					<td>${releaseList.product.employeeId.getFullname()}</td>
					<td>${releaseList.employee.getFullname()}</td>
					<td>
						<a href="/mumscrum/releaseBacklog/releaseBacklogForm?releaseId=${releaseList.id}">Edit</a>  | 
						<a href="/mumscrum/releaseBacklog/releaseBacklogDelete?releaseId=${releaseList.id}">Delete</a>
					</td>
				</tr>

			</c:forEach>
		</tbody>

	</table>
</t:layout>

<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').DataTable();
	});
</script>

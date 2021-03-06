<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE t:layout PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:layout userName="${username}" userRole="${role}" contentTitle= "List of User Stories" activeMenuUserStories="active">
   
   <table id="myTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<!--<th>ID</th>-->
				<th>Priority</th>
				<th>Name</th>
				<th>Product</th>
				<!--<th>Release</th>
				<th>Sprint</th>-->
				<th>Start Date</th>
				<th>Due Date</th>
				<!--<th>Est.Dev Effort</th>
				<th>Est.Test Effort</th>-->
				<!--<th>Description</th>
				<th>Owner</th>
				<th>Developer</th>
				<th>Tester</th>-->
				<th>Edit | Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userStoryList}" var="userStoryList">
				<tr>
					<td>${userStoryList.priority}</td>
					<td>${userStoryList.getName()}</td>
					<td>${userStoryList.product.name}</td>
					<td>${userStoryList.formatStartDate()}</td>
					<td>${userStoryList.formatDueDate()}</td>				
					<!--<td>${userStoryList.estimateDevEffort}</td>
					<td>${userStoryList.estimateTestEffort}</td>-->
					<td><a href="/mumscrum/userStory/userStoryForm?userStoryId=${userStoryList.id}">Edit</a> | 
						<a href="/mumscrum/userStory/userStoryDelete?userStoryId=${userStoryList.id}">Delete</a></td>
					 
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
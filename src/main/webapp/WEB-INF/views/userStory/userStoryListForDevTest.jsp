<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE t:layout PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:layout userName="${username}" userRole="${role}" contentTitle= "List of User Stories" activeMenuUserStories="active">
   
   <table id="myTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Priority</th>
				<th>Name</th>
				<th>Start Date</th>
				<th>Due Date</th>
				<th>Est.Dev Effort</th>
				<th>Est.Test Effort</th>
				<th>Worklogs</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userStoryListForDevTest}" var="userStoryList">
				<tr>
					<td>${userStoryList.priority}</td>
					<td>${userStoryList.getName()}</td>
					<td>${userStoryList.formatStartDate()}</td>
					<td>${userStoryList.formatDueDate()}</td>				
					<td><a href="/mumscrum/userStory/userStoryFormForDevTest?userStoryId=${userStoryList.id}">${userStoryList.estimateDevEffort}</a></td>
					<td><a href="/mumscrum/userStory/userStoryFormForDevTest?userStoryId=${userStoryList.id}">${userStoryList.estimateTestEffort}</a></td>
					<td><a href="/mumscrum/worklog/worklogForm?userStoryId=${userStoryList.id}">Add</a> | <a href="/mumscrum/worklog/worklogList?userStoryId=${userStoryList.id}">View</a></td> 
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
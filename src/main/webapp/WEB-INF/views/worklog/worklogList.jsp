<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE t:layout PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:layout userName="${username}" userRole="${role}" contentTitle= "List of Worklogs | ${title}" activeMenuUserStories="active">
   
   <table id="myTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Date</th>
				<th>Actual Effort</th>
				<th>Effort Type</th>
				<th>Edit | Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${worklogList}" var="worklogList">
				<tr>
					<td>${worklogList.formatModifiedDate()}</td>
					<td>${worklogList.actualEffort}</td>
					<td>${worklogList.effortType}</td>
					<td><a href="/mumscrum/worklog/worklogList?worklogId=${worklogList.id}">Edit</a> | 
						<a href="/mumscrum/worklog/worklogDelete?worklogId=${worklogList.id}">Delete</a></td>
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
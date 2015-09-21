<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout userName="${username}" userRole="${role}" contentTitle= "${title}" activeMenuUserStories="active">


	<form:form class="form-horizontal" action="worklogForm" method="post" commandName="worklogBean">
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Actual Effort</label>
			<div class="col-sm-10">
				<form:input type="number" name="actualEffort" class="form-control" path="actualEffort" id="inputName" placeholder="Actual Effort" value="${worklog.actualEffort}"/>
				<form:errors path="actualEffort"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Modified Date</label>
			<div class="col-sm-10">
			 <form:input type="text" name="modifiedDate" class="form-control" path="modifiedDate" id="inputModifiedDate" placeholder="yyyy-mm-dd" value="${worklog.modifiedDate}"/>
			 <form:errors path="modifiedDate"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Effort Type</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEffortType" placeholder="Effort Type" name="effortType" value="${worklog.effortType}" path="effortType"/>
				<form:errors path="effortType"></form:errors>
			</div>
		</div>
		
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</form:form>


</t:layout>
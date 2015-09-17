<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout>

	<form:form class="form-horizontal" action="userStoryForm" method="post" commandName="userStoryBean">
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">User story name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputName" placeholder="User story name" name="name">
				<form:errors path="name"></form:errors>
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Product name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputProduct" placeholder="Product name" name="productId">
				<form:errors path="productId"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Release name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputReleaseBacklog" placeholder="Release name" name="releaseId">
				<form:errors path="releaseId"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Sprint name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputSprint" placeholder="Sprint name" name="sprintId">
				<form:errors path="sprintId"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Start date</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputStartDate" placeholder="yyyy-mm-dd" name="startDate">
				<form:errors path="startDate"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Due date</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputDueDate" placeholder="yyyy-mm-dd" name="dueDate">
				<form:errors path="dueDate"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Priority</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputPriority" placeholder="Priority" name="priority">
				<form:errors path="priority"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Estimate development effort</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputEstimateDevEffort" placeholder="Estimate development effort" name="estimateDevEffort">
				<form:errors path="estimateDevEffort"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Estimate test effort</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputEstimateTestEffort" placeholder="Estimate test effort" name="estimateTestEffort">
				<form:errors path="estimateTestEffort"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Assinged developer</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputDeveloperId" placeholder="Assigned developer" name="developerId">
				<form:errors path="developerId"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Assigned tester</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputTestId" placeholder="Assigned tester" name="testId">
				<form:errors path="testId"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Description</label>
			<div class="col-sm-10">
				<textarea name="description" row="5" class="form-control" id="inputDescription" placeholder="Description" name="description"> </textarea>
			</div>
		</div>
		

		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
		</div>
	</form:form>


</t:layout>
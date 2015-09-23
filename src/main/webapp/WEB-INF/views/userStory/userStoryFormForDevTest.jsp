<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout userName="${username}" userRole="${role}" contentTitle= "${title}" activeMenuUserStories="active">


	<form:form class="form-horizontal" action="userStoryFormForDevTest" method="post" commandName="userStoryBean">
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">User story name</label>
			<div class="col-sm-10">
				<h4><span class="label label-primary">${userStory.name}</span></h4>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Start date</label>
			<div class="col-sm-10">
			 <form:input type="text" name="startDate" class="form-control" path="startDate" id="inputStartDate" placeholder="yyyy-mm-dd" value="${userStory.formatStartDate()}"/>
			 <form:errors path="startDate"></form:errors>
			
			
				
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Due date</label>
			<div class="col-sm-10">
				<div class='input-group date' id='datetimepicker1'>
					<form:input type="text" class="form-control" id="inputDueDate" placeholder="yyyy-mm-dd" name="dueDate" value="${userStory.formatDueDate()}" path="dueDate"/>
					<span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
					<form:errors path="dueDate"></form:errors>
				</div>
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Estimate development effort</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEstimateDevEffort" placeholder="Estimate development effort" name="estimateDevEffort" value="${userStory.estimateDevEffort}" path="estimateDevEffort"/>
				<form:errors path="estimateDevEffort"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Estimate test effort</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputEstimateTestEffort" placeholder="Estimate test effort" name="estimateTestEffort" value="${userStory.estimateTestEffort}" path="estimateTestEffort"/>
				<form:errors path="estimateTestEffort"></form:errors>
			</div>
		</div>
		
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</form:form>
	
</t:layout>
<script type="text/javascript">
      $(function () {
          $('#datetimepicker1').datetimepicker();
      });
 </script>
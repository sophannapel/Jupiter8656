<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout userName="${username}" userRole="${role}" contentTitle= "${title}" activeMenuUserStories="active">


	<form:form class="form-horizontal" action="userStoryForm" method="post" commandName="userStoryBean">
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">User story name</label>
			<div class="col-sm-10">
				<form:input type="text" name="name" class="form-control" path="name" id="inputName" placeholder="User story name" value="${userStory.name}"/>
				<form:errors path="name"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Product name</label>
			<div class="col-sm-10">
			<form:select path="productId" name="productId" id="productId" value="${userStory.product.id}" class="form-control">
			<c:forEach items="${productList}" var="productList">				
				<c:choose>
					<c:when test="${userStory.product.id == productList.id}">
						<form:option value="${productList.id}" selected="${userStory.product.id}" >${productList.name} </form:option>
					</c:when>
				
					<c:otherwise>
						<form:option value="${productList.id}" >${productList.name} </form:option>
					</c:otherwise>
				</c:choose>
    		</c:forEach>
			</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Release name</label>
			<div class="col-sm-10">		
				<c:set var="defaultRelease" value="${userStory.releaseBacklog.id}" />  			
				<form:select path="releaseId" name="releaseId" id="releaseList" class="form-control">
				</form:select>	 
				<form:errors path="releaseId"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Sprint name</label>
			<div class="col-sm-10">
				<c:set var="defaultSprint" value="${userStory.sprint.id}" />  
				 <form:select path="sprintId" name="sprintId" id="sprintList" class="form-control">
				</form:select>
				<form:errors path="sprintId"></form:errors>
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
				<form:input type="text" class="form-control" id="inputDueDate" placeholder="yyyy-mm-dd" name="dueDate" value="${userStory.formatDueDate()}" path="dueDate"/>
				<form:errors path="dueDate"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Priority</label>
			<div class="col-sm-10">
				<form:select path="priority" name="priority" id="inputPriority" value="${userStory.priority}" class="form-control">
					<c:forEach items="${priority}" var="priority">
						<c:choose>
							<c:when test="${userStory.priority == priority}">
						<form:option value="${priority}" selected="${userStory.priority}" >${priority} </form:option>
					</c:when>
				
					<c:otherwise>
						<form:option value="${priority}" >${priority} </form:option>
					</c:otherwise>
				</c:choose>
					
					
					
					
    					
    				</c:forEach>
				</form:select>
				<form:errors path="priority"></form:errors>
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
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Assinged developer</label>
			<div class="col-sm-10">
				<form:select path="developerId" name="developerId" id="inputDeveloperId" value="${userStory.developerId.id}" class="form-control">
					<c:forEach items="${developer}" var="developer">
    					<form:option value="${developer.id}" selected="${userStory.developerId.id}">${developer.getFullname()}</form:option>
    				</c:forEach>
				</form:select>
				<form:errors path="developerId"></form:errors>			
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Assigned tester</label>
			<div class="col-sm-10">
				<form:select path="testId" name="testId" id="inputTestId" value="${userStory.testId.id}" class="form-control">
					<c:forEach items="${tester}" var="tester">
    					<form:option value="${tester.id}" selected="${userStory.testId.id}">${tester.getFullname()}</form:option>
    				</c:forEach>
				</form:select>
				<form:errors path="testId"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Description</label>
			<div class="col-sm-10">
				<form:textarea name="description" row="5" class="form-control" id="inputDescription" placeholder="Description" path="description" />
			</div>
		</div>
		

		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</form:form>
	
	<script>
		$(document).ready(function() {
			//populates release drop down on load from selected product.
			var productId = $("#productId").val();
			getReleaseList(productId);
		});

		$("#productId").change(function() {
			var id = $(this).val();
			getReleaseList(id);
		});
		
		$("#releaseList").change(function() {
			var id = $(this).val();
			getSprintList(id);
		});

		function getReleaseList(productId) {
			$.getJSON("getReleasesByProductId?productId=" + productId, function(jsonData) {
				var options = '';
				var releases = jsonData[0].resultList;
				options += '<option value=""> none </option>';
				var defaultRelease = "${defaultRelease}";		
				for (var i = 0; i < releases.length; i++) {
					if(releases[i].id == defaultRelease)
						options += '<option value="' + releases[i].id + ' " selected>' + releases[i].name + '</option>';
					else
						options += '<option value="' + releases[i].id + '">' + releases[i].name + '</option>';
				}
				$("#releaseList").html(options);
				var releaseId = $("#releaseList").val();
				getSprintList(releaseId);
			});
		}
		
		function getSprintList(releaseId) {
			$.getJSON("getSprintsByReleaseId?releaseId=" + releaseId, function(jsonData) {
				var options = '';
				var sprints = jsonData[0].resultList;
				var defaultSprint = "${defaultSprint}";
				options += '<option value=""> none </option>';
				for (var i = 0; i < sprints.length; i++) {
					if(sprints[i].id == defaultSprint)
						options += '<option value="' + sprints[i].id + ' " selected>' + sprints[i].name + '</option>';
					else
						options += '<option value="' + sprints[i].id + '">' + sprints[i].name + '</option>';
				}
				$("#sprintList").html(options);
			});
		}	
	</script>

</t:layout>
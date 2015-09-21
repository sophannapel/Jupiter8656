<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout userName="${username}" userRole="${role}" contentTitle= "${title}" activeMenuProduct="active">


   	<form:form class="form-horizontal" action="releaseBacklogForm" method="post" commandName="releaseBacklogBean">
			  <div class="form-group">
			    <label for="inputName" class="col-sm-2 control-label">Release Backlog Name</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputName" placeholder="Release Backlog Name" name="name" path="name" value="${releaseBacklog.name}"/>
			      <form:errors path="name"></form:errors>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputName" class="col-sm-2 control-label">Product Name</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputName" placeholder="Release Backlog Name" name="productId" path="productId" value="${releaseBacklog.product.id}"/>
			      <form:errors path="productId"></form:errors>
			    </div>
			  </div>

			 <div class="form-group">
			    <label for="inputStart" class="col-sm-2 control-label">Start Date</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputStart" placeholder="yyyy-mm-dd" name="startDate" path="startDate" value="${releaseBacklog.formatStartDate()}"/>
			      <form:errors path="startDate"></form:errors>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputEnd" class="col-sm-2 control-label">Due Date</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputEnd" placeholder="yyyy-mm-dd" name="dueDate" path="dueDate" value="${releaseBacklog.formatDueDate()}"/>
			      <form:errors path="dueDate"></form:errors>
			    </div>
	    
			  </div>
	
			  <div class="form-group">
			    <label for="inputName" class="col-sm-2 control-label">Release Type</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputType" placeholder="Release Backlog Type" name="type" path="type" value="${releaseBacklog.type}"/>
			      <form:errors path="type"></form:errors>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputName" class="col-sm-2 control-label">Scrum Master Name</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputScrumMaster" placeholder="Scrum Master Name" name="scrumMasterId" path="scrumMasterId" value="${releaseBacklog.employee.id}"/>
			      <form:errors path="scrumMasterId"></form:errors>
			    </div>
			  </div>

			  <div class="form-group">
			    <label for="inputDescription" class="col-sm-2 control-label">Description</label>
			    <div class="col-sm-10">
			     <form:textarea name="description" row="5" class="form-control" id="inputDescription" placeholder="" path="description" value="${product.description}"/>
			   
			   
			    </div>
			  </div>
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Submit</button>
			    </div>
			</form:form>
   
   
</t:layout>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout userName="${username}" userRole="${role}" contentTitle= "${title}" activeMenuProduct="active">


   	<form:form class="form-horizontal" action="productForm" method="post" commandName="productBean">
			  <div class="form-group">
			    <label for="inputName" class="col-sm-2 control-label">Product Name</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputName" placeholder="Product Backlog Name" name="name" path="name" value="${product.name}"/>
			      <form:errors path="name"></form:errors>
			    </div>
			  </div>

			 <div class="form-group">
			    <label for="inputStart" class="col-sm-2 control-label">Start Date</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputStart" placeholder="yyyy-mm-dd" name="startDate" path="startDate" value="${product.formatStartDate()}"/>
			      <form:errors path="startDate"></form:errors>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEnd" class="col-sm-2 control-label">Due Date</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputEnd" placeholder="yyyy-mm-dd" name="dueDate" path="dueDate" value="${product.formatDueDate()}"/>
			      <form:errors path="dueDate"></form:errors>
			    </div>
	    
			  </div>
			  <div class="form-group">
			    <label for="inputStatus" class="col-sm-2 control-label">Status</label>
			    <div class="col-sm-10">
			      <form:input name="statusId" type="text" class="form-control" id="inputStatus" placeholder="Product status" path="statusId" value="${product.status.name}"/>
			      <form:errors path="statusId"></form:errors>
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
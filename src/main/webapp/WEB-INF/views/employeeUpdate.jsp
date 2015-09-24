<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout userName="" userRole="" contentTitle= "" activeMenuProduct="active">




   	<form:form class="form-horizontal" action="updateEmployee" method="post" commandName="employeeBean">
			  <div class="form-group">
			    <label for="inputfirstname" class="col-sm-2 control-label">First Name</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputfirstname" placeholder="first Name" name="firstname" path="firstname" value="${employee.firstname}"/>
			      <form:errors path="firstname"></form:errors>
			    </div>
			  </div>
				
			 <div class="form-group">
			    <label for="inputlastname" class="col-sm-2 control-label">Last Name</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputlastname" placeholder="last Name" name="lastname" path="lastname" value="${employee.lastname}"/>
			      <form:errors path="lastname"></form:errors>
			    </div>
			  </div>
			
			 <div class="form-group">
			    <label for="inputusername" class="col-sm-2 control-label">User Name</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputusername" placeholder="username Name" name="username" path="username" value="${employee.username}"/>
			      <form:errors path="username"></form:errors>
			    </div>
			  </div>
			
			 <div class="form-group">
			    <label for="inputpassword" class="col-sm-2 control-label">Password</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputpassword" placeholder="password" name="password" path="password" value="${employee.password}"/>
			      <form:errors path="password"></form:errors>
			    </div>
			  </div>
			
			 <div class="form-group">
			    <label for="inputstatus" class="col-sm-2 control-label">Status</label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" id="inputstatus" placeholder="status" name="status" path="status" value="${employee.status}"/>
			      <form:errors path="status"></form:errors>
			    </div>
			  </div>
			  
			  <div class="form-group">
<!-- 			    <label for="inputstatu" class="col-sm-2 control-label">Status</label> -->
			    <div class="col-sm-10">
			      <form:input type="hidden" class="form-control" id="inputstatu" placeholder="id" name="id" path="id" value="${employee.id}"/>
			      <form:errors path="id"></form:errors>
			    </div>
			  </div>
			
	
			 
			   
			   
			  
			 
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Submit</button>
			    </div>
			</form:form>
   
   
</t:layout>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>




<t:layout userName="" userRole="" contentTitle= "" activeMenuProduct="active">

            <table id="myTable" class="display" cellspacing="0" width="100%">
               <thead>
                  <tr>
                      <th>Employee Id</th>
                      <th>Employee First Name</th>
                      <th>Employee Last Name</th>
                      <th>Employee User name</th>
                      <th>Employee Password</th>
                      <th> Employee Status</th>
                   
                      <th>Edit | Delete</th>
                  </tr>
              </thead>
              <tbody>
                <c:forEach items="${listEmployee}" var="employeeList">

					<tr>
						<td>${employeeList.id}</td>
						<td>${employeeList.firstname}</td>
						<td>${employeeList.lastname}</td>
						<td>${employeeList.username}</td>
						<td>${employeeList.password}</td>
						<td>${employeeList.status}</td>

						<td><a href="employeeEdit?id=${employeeList.id}">Edit</a> | <a href="deleteEmployee?id=${employeeList.id}">Deactivate</a></td>	

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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


    <div class="col-md-8">
        <div style="margin-left: -140px;" class="panel panel-default">
          <!-- Default panel contents -->
          <div style="text-align: center;" class="panel-heading">List of Employees</div>
          <div class="panel-body">
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

						<td><a href="#">Edit</a> | <a href="deleteEmployee?id=${employeeList.id}">Deactivate</a></td>	

					</tr>
			
				</c:forEach>
              </tbody>

            </table>  
          </div>

        </div>
    </div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>Employee Details</title>
</head>
<body>

<form  action="employee"  method="post" >
      <table>
          <tr>
              <td>First Name:</td>
              <td><input type="text" name="firstname" /></td>
              
          </tr>
          <tr>
              <td>Last Name:</td>
              <td><input  type="text" name="lastname" /></td>
          </tr>
            <tr>
              <td>User Name:</td>
              <td><input  type="text" name="username" /></td>
          </tr>
            <tr>
              <td>Password</td>
              <td><input  type="text" name="password" /></td>
          </tr>
           <tr>
              <td>Role</td>
              <td><input  type="text" name="roleId" /></td>
          </tr>
          <tr>
              <td>Status</td>
              <td><input  type="checkbox" name="status" /></td>
          </tr>
          
         
          <tr>
              <td colspan="2">
                  <input type="submit" value="Save Changes" />
              </td>
          </tr>
      </table>
  </form>



</body>
</html>
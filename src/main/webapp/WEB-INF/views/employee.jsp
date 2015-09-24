

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%-- 	<form> --%>
<%-- 					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
<%-- 					</form> --%>
					
					
					
	

<t:layout userName="" userRole="" contentTitle= "" activeMenuProduct="active">

<%-- <form  class="form-horizontal" action="employee"  method="post" > --%>
<%--       <table> --%>
<%--           <tr> --%>
<%--               <td>First Name:</td> --%>
<%--               <td><input type="text" name="firstname" /></td> --%>
              
              
              
<%--           </tr> --%>
<%--           <tr> --%>
<%--               <td>Last Name:</td> --%>
<%--               <td><input  type="text" name="lastname" /></td> --%>
<%--           </tr> --%>
<%--             <tr> --%>
<%--               <td>User Name:</td> --%>
<%--               <td><input  type="text" name="username" /></td> --%>
<%--           </tr> --%>
<%--             <tr> --%>
<%--               <td>Password</td> --%>
<%--               <td><input  type="text" name="password" /></td> --%>
<%--           </tr> --%>
<%--            <tr> --%>
<%--               <td>Role</td> --%>
<%--               <td><input  type="text" name="roleId" /></td> --%>
<%--           </tr> --%>
<%--           <tr> --%>
<%--               <td>Status</td> --%>
<%--               <td><input  type="checkbox" name="status" /></td> --%>
<%--           </tr> --%>
          
         
<%--           <tr> --%>
<%--               <td colspan="2"> --%>
<!--                   <input type="submit" value="Save Changes" /> -->
<%--               </td> --%>
<%--           </tr> --%>
<%--       </table> --%>
<%--   </form> --%>




   	<form class="form-horizontal" action="employee" method="post">
			  <div class="form-group">
			    <label for="inputfirstname" class="col-sm-2 control-label">First Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputfirstname" placeholder="first Name" name="firstname" />
			      
			    </div>
			  </div> 
			   <div class="form-group">
			    <label for="inputlastname" class="col-sm-2 control-label">Last Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputlastname" placeholder="last Name" name="lastname"  />
			   
			    </div>
			  </div>
			
			 <div class="form-group">
			    <label for="inputusername" class="col-sm-2 control-label">User Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputusername" placeholder="username Name" name="username"  />
			   
			    </div>
			  </div>
			
			 <div class="form-group">
			    <label for="inputpassword" class="col-sm-2 control-label">Password</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputpassword" placeholder="password" name="password"  />
			      
			    </div>
			  </div>
			
			 <div class="form-group">
			    <label for="inputstatus" class="col-sm-2 control-label">Status</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputstatus" placeholder="status" name="status" />
			     
			    </div>
			  </div>
			  
			  
			   <div class="form-group">
			    <label for="inputRole" class="col-sm-2 control-label">Role</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputRole" placeholder="roleId" name="roleId"  />
			      
			    </div>
			  </div>
	
			
	
			 
			   
			    
			 
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Submit</button>
			    </div>
			</form>
   
   
</t:layout>
					



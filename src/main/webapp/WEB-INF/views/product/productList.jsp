<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE t:layout PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:layout userName="${username}" userRole="${role}" contentTitle= "List of Products" activeMenuProduct="active">


	<table id="myTable" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Start Date</th>
				<th>Due Date</th>
				<th>Description</th>
				<th>Status</th>
				<th>Owner</th>
				<!--<th>Edit | Delete</th>-->
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="productList">

				<tr>
					<td>${productList.id}</td>
					<td>${productList.name}</td>
					<td>${productList.formatStartDate()}</td>
					<td>${productList.formatDueDate()}</td>
					<td>${productList.description}</td>
					<td>${productList.status.name}</td>
					<td>${productList.employeeId.firstname}
						${productList.employeeId.lastname}</td>
					<td>
						<a href="/mumscrum/product/productForm?productId=${productList.id}">Edit</a> 
						<!--  
						| <a href="/mumscrum/product/productDelete?productId=${productList.id}">Delete</a>
						 -->
					</td>
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

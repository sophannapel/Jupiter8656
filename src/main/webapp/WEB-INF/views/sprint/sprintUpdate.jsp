<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout userName="${username}" userRole="${role}"
	contentTitle="Update Sprint" activeMenuProduct="active">

	<form:form class="form-horizontal" action="updateSprint" method="post" commandName="sprintBean">

		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Sprint
				Name</label>
			<div class="col-sm-10">
				<form:input path="name"  type="text" class="form-control" id="inputName"
					placeholder="Sprint Name" name="name" value="${sprint.name}" />
				<form:errors path="name" />
			</div>
		</div>

		<div class="form-group">
			<label for="inputStart" class="col-sm-2 control-label">Start
				Date</label>
			<div class="col-sm-10">
				<form:input path="startDate" type="text" class="form-control" id="inputStart"
					placeholder="yyyy-mm-dd" name="startDate"
					value="${sprint.startDate}" />
				<form:errors path="startDate" />
			</div>
		</div>

		<div class="form-group">
			<label for="inputEnd" class="col-sm-2 control-label">Due Date</label>
			<div class="col-sm-10">
				<form:input path="dueDate"  type="text" class="form-control" id="inputEnd"
					placeholder="yyyy-mm-dd" name="dueDate" value="${sprint.dueDate}" />
				<form:errors path="dueDate" />
			</div>
		</div>

		<div class="form-group">
			<label for="products" class="col-sm-2 control-label">Product
				name</label>
			<div class="col-sm-10">

				<select path="productId" name="productId" id="products">
					<c:forEach items="${productList}" var="productList">
						<option value="${productList.id}">${productList.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="productReleases" class="col-sm-2 control-label">Release</label>
			<div class="col-sm-10">
				<select path="releaseId" name="releaseId" id="productReleases">
					<option value="${sprint.releaseBacklog.id}">${sprint.releaseBacklog.name}</option>
				</select>
			</div>
		</div>
		<input type="hidden" name="id" value="${sprint.id}">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</form:form>


</t:layout>

<script>
	/* 	$(document).ready(function() {
	 //populates release drop down on load from selected product.
	 id = $("#products").val();
	 getJson(id);
	 }); */

	$("#products").change(function() {
		var id = $(this).val();
		getJson(id);
	});

	function getJson(id) {
		$.getJSON("getProductReleases?productId=" + id, function(jsonData) {
			var options = '';
			var releases = jsonData[0].Releases;
			for (var i = 0; i < releases.length; i++) {
				options += '<option value="' + releases[i].id + '">'
						+ releases[i].name + '</option>';
			}
			$("#productReleases").html(options);
		});
	}
</script>
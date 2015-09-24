<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout userName="${username}" userRole="${role}"
	contentTitle="${title}" activeMenuProduct="active">


	<form:form class="form-horizontal" action="releaseBacklogForm"
		method="post" commandName="releaseBacklogBean">
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Release
				Backlog Name</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="inputName"
					placeholder="Release Backlog Name" name="name" path="name"
					value="${releaseBacklog.name}" />
				<form:errors path="name" cssClass="error"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Product
				Name</label>
			<div class="col-sm-10">
				<form:select path="productId" name="productId" id="productId"
					value="${releaseBacklog.product.id}" class="form-control">
					<c:forEach items="${productList}" var="productList">
						<c:choose>
							<c:when test="${releaseBacklog.product.id == productList.id}">
								<form:option value="${productList.id}"
									selected="${releaseBacklog.product.id}">${productList.name} </form:option>
							</c:when>

							<c:otherwise>
								<form:option value="${productList.id}">${productList.name} </form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
				<form:errors path="productId"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<label for="inputStart" class="col-sm-2 control-label">Start
				Date</label>
			<div class="col-sm-10">
				<form:input type="text" class="datePicker form-control"
					id="inputStart" placeholder="yyyy-mm-dd" name="startDate"
					path="startDate" value="${releaseBacklog.formatStartDate()}" />
				<form:errors path="startDate" cssClass="error"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<label for="inputEnd" class="col-sm-2 control-label">Due Date</label>
			<div class="col-sm-10">
				<form:input type="text" class="datePicker form-control"
					id="inputEnd" placeholder="yyyy-mm-dd" name="dueDate"
					path="dueDate" value="${releaseBacklog.formatDueDate()}" />
				<form:errors path="dueDate" cssClass="error"></form:errors>
			</div>

		</div>

		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Release
				Type</label>
			<div class="col-sm-10">
				<form:select path="type" name="type" id="type"
					value="${releaseBacklog.type}" class="form-control">
					<c:forEach items="${releaseType}" var="releaseType">
						<c:choose>
							<c:when test="${releaseBacklog.type == releaseType}">
								<form:option value="${releaseType}"
									selected="${releaseBacklog.type}">${releaseType} </form:option>
							</c:when>

							<c:otherwise>
								<form:option value="${releaseType}">${releaseType} </form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
				<form:errors path="type" cssClass="error"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Scrum
				Master Name</label>
			<div class="col-sm-10">
				<form:select path="scrumMasterId" name="scrumMasterId"
					id="inputScrumMaster" value="${releaseBacklog.employee.id}"
					class="form-control">
					<c:forEach items="${scrumMaster}" var="scrumMaster">
						<c:choose>
							<c:when test="${releaseBacklog.employee.id == scrumMaster.id}">
								<form:option value="${scrumMaster.id}"
									selected="${releaseBacklog.employee.id}">${scrumMaster.getFullname()} </form:option>
							</c:when>

							<c:otherwise>
								<form:option value="${scrumMaster.id}">${scrumMaster.getFullname()} </form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
				<form:errors path="scrumMasterId" cssClass="error"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<label for="inputDescription" class="col-sm-2 control-label">Description</label>
			<div class="col-sm-10">
				<form:textarea name="description" row="5" class="form-control"
					id="inputDescription" placeholder="" path="description"
					value="${product.description}" />
			</div>
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</form:form>

	<script type="text/javascript">
		$(function() {
			$(".datePicker").datepicker({
				dateFormat : "yyyy-mm-dd"
			});

			$("#inputStart").change(function() {
				var startDate = $("#inputStart").val();
				$("#inputStart").val(startDate.substring(4, 14));

			});

			$("#inputEnd").change(function() {
				var endDate = $("#inputEnd").val();
				$("#inputEnd").val(endDate.substring(4, 14));

			});
		});
	</script>

</t:layout>
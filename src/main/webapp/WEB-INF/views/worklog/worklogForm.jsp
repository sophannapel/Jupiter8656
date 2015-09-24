<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout userName="${username}" userRole="${role}" contentTitle= "${title} | ${subtitle}" activeMenuUserStories="active">


	<form:form class="form-horizontal" action="worklogForm" method="post" commandName="worklogBean">
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Actual Effort</label>
			<div class="col-sm-10">
				<form:input type="number" name="actualEffort" class="form-control" path="actualEffort" id="inputName" placeholder="Actual Effort" value="${worklog.actualEffort}"/>
				<form:errors path="actualEffort" cssClass="error"></form:errors>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Modified Date</label>
			<div class="col-sm-10">
			 <form:input type="text" name="modifiedDate" class="datePicker form-control" path="modifiedDate" id="datepickerDate" placeholder="yyyy-mm-dd" value="${worklog.formatModifiedDate()}"/>
			 <form:errors path="modifiedDate" cssClass="error"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<label for="inputName" class="col-sm-2 control-label">Effort Type</label>
			<div class="col-sm-10">
				<form:select class="form-control" id="inputEffortType" name="effortType" path="effortType">
							<form:option value="Development" >Development</form:option>
							<form:option value="Test" >Test</form:option>
				</form:select>
				<form:errors path="effortType" cssClass="error"></form:errors>
			</div>
		</div>
		
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</form:form>

<script type="text/javascript">
$(function() {
    $( ".datePicker").datepicker({
    	  dateFormat: "yyyy-mm-dd"
    });
    var modDate;
    $("#datepickerDate").change(function() {
    	modDate = $("#datepickerDate").val();
        $("#datepickerDate").val(modDate.substring(4,14));

    });
    $("#inputEffortType").val('${worklog.effortType}');
  });
 </script>
</t:layout>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<t:layout userName="${username}" userRole="${role}"
	contentTitle="Burndown Chart" activeMenuProduct="active">
	
			<div class="form-group" style="height:25px">
			<label for="sprints" class="col-sm-2 control-label">Select Sprint</label>
			<div class="col-sm-10">
				<select path="sprintId" name="sprintId" id="sprints">
					<option></option>
					<c:forEach items="${sprintList}" var="sprintList">
						<option value="${sprintList.id}">${sprintList.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
	<div id="chart_div" style="width: 900px; height: 500px;"></div>

</t:layout>
<script type="text/javascript">

  
	google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	
	
//	google.setOnLoadCallback(drawVisualization);
	
	$("#sprints").change(function() {
		var sprintId = $(this).val();
		
		$.getJSON("getCoordinates?sprintId=" + sprintId, function(json) {	
			drawVisualization(json);
		});
		
	});
	
	

	function getDataArray(jsonData) {
		var coordinates = new Array();

		coordinates.push([ 'day', 'Work Hours', 'Velocity' ])
		var data = jsonData[0].Coordinates;
		if(data.length == 0){
			coordinates.push(['',0,0]);
			coordinates.push(['',0,0]);
		}
		for (var i = 0; i < data.length; i++) {
			var set = new Array();
			set.push(data[i].day);
			set.push(data[i].workHours);
			set.push(data[i].workHours);
			coordinates.push(set);
		}

		return coordinates;
	}

	function drawVisualization(jsonData) {

		var dataArray = getDataArray(jsonData);
		
		/* 		var data = google.visualization.arrayToDataTable([
		 [ 'day', 'Work Hours', 'Velocity' ],
		 [ '2015-09-14', 157, 157 ], [ '2015-09-15', 133, 133 ],
		 [ '2015-09-16', 124, 124 ], [ '2015-09-17', 117, 117 ],

		 ]); */
		 
		var data = google.visualization.arrayToDataTable(dataArray);
		var options = {
			title : 'Burndown Chart',
			vAxis : {
				title : 'Work Remaining (Hours)'
			},
			hAxis : {
				title : 'Time (Dates)'
			},
			seriesType : 'bars',
			series : {
				1 : {
					type : 'line'
				}
			}
		};

		var chart = new google.visualization.ComboChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>Sprint Form</title>
</head>
<body>

	<header>
		<h1>Edit Sprint</h1>
	</header>
	<section>
		<form action="updateSprint" method="post">

			<div style="padding: 12px;">
				<label>Sprint Name</label> <input name="name" type="text" value="${sprint.name}">
			</div>
			<div style="padding: 12px;">
				<label>Start Date</label> <input name="startDate" type="text" value="${sprint.startDate}">
			</div>
			<div style="padding: 12px;">
				<label>Due Date</label> <input name="dueDate" type="text" value="${sprint.dueDate}">
			</div>
			<div style="padding: 12px;">
				<label>Product</label> <input list="products" name="product" id="editProduct"> 
				<datalist id="products">
					<c:forEach items="${productList}" var="productList">
						<option id="${productList.id}" value="${productList.name}">
					</c:forEach>
				</datalist>
			</div>
			<div style="padding: 12px;">
				<label>Release</label> <input list="productReleases" name="releaseId" id="editRelease">
				<datalist id="productReleases">

				</datalist>
			</div>
			<input type="hidden" name="id" value="${sprint.id}">
			<div style="padding: 12px;">
				<input type="submit" value="Save" />
			</div>
		</form>
	</section>

	<script>	
		$(document).on('change', 'input', function() {
			var options = $('datalist')[0].options; // Product List
			var val = $(this).val();
			var id =  $(this)[0].id;
			
			for (var i = 0; i < options.length; i++) {
				if (options[i].value === val) {
					getJson(options[i].id);
					break;
				}
			}
		});

		function getJson(id) {
			$.getJSON("getProductReleases?productId=" + id, function(jsonData) {
				var options = '';
				var releases = jsonData[0].Releases;
				for (var i = 0; i < releases.length; i++) {
					options += '<option value="' + releases[i].id + '">'
							+ releases[i].name + '</option>';
				}
				$("datalist#productReleases").html(options);
			});
		}
		
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Product</title>
	<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	
	
	<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css">
    <!-- Latest compiled and minifi ed JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
</head>
<body>
	 <!--Hearder Bar-->
    <nav class="navbar navbar-default">
      <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">MUMScrum</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Developer: </a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Kuroun <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">View Profile</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Logout</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
     <!-- Content page-->
    <div class="row">
      <div class="col-md-4">
            <div class="side-menu">
    
                <nav class="navbar navbar-default" role="navigation">

                  <!-- Main Menu -->
                  <div class="side-menu-container">
                      <ul class="nav navbar-nav">

                          <li class="active"><a href="#"><span class="glyphicon glyphicon-plane"></span> Active Link</a></li>
                           <!-- Dropdown-->
                          <li class="panel panel-default" id="dropdown">
                              <a data-toggle="collapse" href="#manage_projects_menu">
                                  <span class="glyphicon glyphicon-send"></span> Manage Projects <span class="caret"></span>
                              </a>

                              <!-- Dropdown level 1 -->
                              <div id="manage_projects_menu" class="panel-collapse collapse">
                                  <div class="panel-body">
                                      <ul class="nav navbar-nav">
                                          <li><a href="#">Project 1</a></li>
                                          <li><a href="#">Project 2</a></li>
                                          <li><a href="#">Project 3</a></li>
                                      </ul>
                                  </div>
                              </div>
                          </li>
                          <li><a href="#"><span class="glyphicon glyphicon-cloud"></span> Manage User Stories</a></li>

                          <!-- Dropdown-->
                          <li class="panel panel-default" id="dropdown">
                              <a data-toggle="collapse" href="#dropdown-lvl1">
                                  <span class="glyphicon glyphicon-user"></span> Sub Level <span class="caret"></span>
                              </a>

                              <!-- Dropdown level 1 -->
                              <div id="dropdown-lvl1" class="panel-collapse collapse">
                                  <div class="panel-body">
                                      <ul class="nav navbar-nav">
                                          <li><a href="#">Link</a></li>
                                          <li><a href="#">Link</a></li>
                                          <li><a href="#">Link</a></li>

                                           <!-- Dropdown level 2 -->
                                    
                                          <li class="panel panel-default" id="dropdown">
                                              <a data-toggle="collapse" href="#dropdown-lvl2">
                                                  <span class="glyphicon glyphicon-off"></span> Sub Level <span class="caret"></span>
                                              </a>
                                              <div id="dropdown-lvl2" class="panel-collapse collapse">
                                                  <div class="panel-body">
                                                      <ul class="nav navbar-nav">
                                                          <li><a href="#">Link</a></li>
                                                          <li><a href="#">Link</a></li>
                                                          <li><a href="#">Link</a></li>
                                                      </ul>
                                                  </div>
                                              </div>
                                          </li>
                                     
                                      </ul>
                                  </div>
                              </div>
                          </li>
                      </ul>
                  </div><!-- /.navbar-collapse -->
            </nav>
    
    </div>
    </div>
      <!--Main Content-->
    <div class="col-md-8">
        <div style="margin-left: -140px;" class="panel panel-default">
          <!-- Default panel contents -->
          <div style="text-align: center;" class="panel-heading">Add Product Backlog</div>
          <div class="panel-body">
			<form class="form-horizontal" action="product" method="post">
			  <div class="form-group">
			    <label for="inputName" class="col-sm-2 control-label">Product Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputName" placeholder="Product Backlog Name" name="name" >
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="inputStart" class="col-sm-2 control-label">Start Date</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputStart" placeholder="yyyy-mm-dd" name="startDate" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEnd" class="col-sm-2 control-label">Due Date</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputEnd" placeholder="yyyy-mm-dd" name="dueDate" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputStatus" class="col-sm-2 control-label">Status</label>
			    <div class="col-sm-10">
			      <input name="status" type="text" class="form-control" id="inputStatus" placeholder="">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputDescription" class="col-sm-2 control-label">Description</label>
			    <div class="col-sm-10">
			      <textarea name="description" row="5" class="form-control" id="inputDescription" placeholder=""></textarea>
			    </div>
			  </div>
			  <input style="display:none" type="text" value="${userId}" name="employeeId" />
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Submit</button>
			    </div>
			  </div>
			</form>
          </div>
        </div>
    </div>
    </div>
	
</body>
</html>
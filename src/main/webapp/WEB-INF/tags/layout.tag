<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@attribute name="userRole" required="true"%>
<%@attribute name="contentTitle" required="true"%>
<%@attribute name="userName" required="true"%>
<%@attribute name="activeMenuUserStories" %>
<%@attribute name="activeMenuProduct" %>
<html>
	<head>
		<!-- Latest compiled and minified CSS -->
	    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	    <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/customStyle.css" />" rel="stylesheet">
		
		<!--<link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">-->
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	    
		<link href="<c:url value="/resources/css/jquery.dataTables.min.css" />" rel="stylesheet">
	  
	    <!-- Latest compiled and minified JavaScript -->
	    <!--<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>-->
	    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
	    
	    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
	    
	    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	    
	    <script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
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
	            <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>  ${userRole}: </a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${userName} <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="#">View Profile</a></li>
	                <li role="separator" class="divider"></li>
	                
	                
	                <li><a href="/mumscrum/logout">Logout</a></li>
	                
	             
	                
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
	                           <!-- Dropdown-->
	                          <li class="${activeMenuProduct} panel panel-default" id="dropdown">
	                              <a data-toggle="collapse" href="#manage_projects_menu">
	                                  <span class="glyphicon glyphicon-th"></span> Products Management <span class="caret"></span>
	                              </a>
	
	                              <!-- Dropdown level 1 -->
	                              <div id="manage_projects_menu" class="panel-collapse collapse">
	                                  <div class="panel-body">
	                                      <ul class="nav navbar-nav">
	                                          <li><a href="/mumscrum/product/productForm">Add New Product</a></li>
	                                          <li><a href="/mumscrum/product/productList">List of Products</a></li>
	                                    
	                                      </ul>
	                                  </div>
	                              </div>
	                          </li>
	                          <li class="panel panel-default" id="dropdown">
	                              <a data-toggle="collapse" href="#manage_releases_menu">
	                                  <span class="glyphicon glyphicon-send"></span> Releases Management <span class="caret"></span>
	                              </a>
	
	                              <!-- Dropdown level 1 -->
	                              <div id="manage_releases_menu" class="panel-collapse collapse">
	                                  <div class="panel-body">
	                                      <ul class="nav navbar-nav">
	                                          <li><a href="/mumscrum/releaseBacklog/releaseBacklogForm">Add New Release</a></li>
	                                          <li><a href="/mumscrum/releaseBacklog/releaseBacklogList">List of Releases</a></li>	                                    
	                                      </ul>
	                                  </div>
	                              </div>
	                          </li>
	                          <li class="panel panel-default" id="dropdown">
	                              <a data-toggle="collapse" href="#manage_sprints_menu">
	                                  <span class="glyphicon glyphicon-th-list"></span> Sprints Management <span class="caret"></span>
	                              </a>
	
	                              <!-- Dropdown level 1 -->
	                              <div id="manage_sprints_menu" class="panel-collapse collapse">
	                                  <div class="panel-body">
	                                      <ul class="nav navbar-nav">
	                                          <li><a href="/mumscrum/sprint/sprintForm">Add New Sprint</a></li>
	                                          <li><a href="/mumscrum/sprint/sprintList">List of Sprints</a></li>
	                                    	  <li><a href="/mumscrum/sprint/burndownChart">View Burndown Chart</a></li>
	                                      </ul>
	                                  </div>
	                              </div>
	                          </li>
	                          <li class="${activeMenuUserStories} panel panel-default" id="dropdown">
	                              <a data-toggle="collapse" href="#manage_userStories_menu">
	                                  <span class="glyphicon glyphicon-cloud"></span> User Stories Management <span class="caret"></span>
	                              </a>
	
	                              <!-- Dropdown level 1 -->
	                              <div id="manage_userStories_menu" class="panel-collapse collapse">
	                                  <div class="panel-body">
	                                      <ul class="nav navbar-nav">
	                                          <li><a href="/mumscrum/userStory/userStoryForm">Add New User Story</a></li>
	                                          <li><a href="/mumscrum/userStory/userStoryList">List of User Stories</a></li>
	                                          <li><a href="/mumscrum/userStory/userStoryListForDevTest">List of User Stories For Dev & Test</a></li>
	                                    
	                                      </ul>
	                                  </div>
	                              </div>
	                          </li>
	                           <li class="panel panel-default" id="dropdown">
	                              <a data-toggle="collapse" href="#manage_employees_menu">
	                                  <span class="glyphicon glyphicon-home"></span> Human Resources Management <span class="caret"></span>
	                              </a>
	
	                              <!-- Dropdown level 1 -->
	                              <div id="manage_employees_menu" class="panel-collapse collapse">
	                                  <div class="panel-body">
	                                      <ul class="nav navbar-nav">
	                                      		<li><a href="/mumscrum/employee/add">Add New Employee</a></li>
	                                      		<li><a href="/mumscrum/employee/employeeList">List of Employees</a></li>
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
	          <div style="text-align: center;" class="panel-heading"><h4>${contentTitle}</h4></div>
	          <div class="panel-body">
	            <jsp:doBody/>  
	          </div>
	        </div>
	    </div>
	    </div>  		
	</body>
</html>
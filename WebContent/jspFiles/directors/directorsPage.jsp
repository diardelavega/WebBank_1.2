<!--%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- <meta charset="utf-8"> -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->
<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../../bootstrap/css/simple-sidebar.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../../bootstrap/css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="../../bootstrap/css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../../bootstrap/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- <style>
    body {
        padding-top: 40px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. 
        Change if height of navigation changes. */
    }
    </style>-->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="./dir.html/dirInit.js"></script>
<title>Directors Page</title>
</head>
<body onload="divhide(); capitalize();">
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Director</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<!--  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>-->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-envelope"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu message-dropdown">
						<li class="message-preview"><a href="#"> <!--<div class="media">-->
								<span class="pull-left"> <img class="media-object"
									src="http://placehold.it/50x50" alt="fing placee holder">
							</span>
								<div class="media-body">
									<h5 class="media-heading">
										<strong>John Smith</strong>
									</h5>
									<p class="small text-muted">
										<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div> <!--</div>-->
						</a></li>
						<li class="message-footer"><a href="#">Read All New
								Messages</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-arrow-up"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu alert-dropdown">
						<li><a href="#">Alert Name <span
								class="label label-default">Alert Badge</span></a></li>

						<li><a href="#">Alert Name <span
								class="label label-danger">Alert Badge</span></a></li>
						<li class="divider"></li>
						<li><a href="#">View All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i>
						${sessionScope.name} <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
						</li>
						<li><a href="#"><i class="fa fa-fw fa-envelope"></i>
								Inbox</a></li>
						<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="../logout.jsp"><i
								class="fa fa-fw fa-power-off"></i> Log Out</a></li>
					</ul></li>
			</ul>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container --> </nav>

		<!-- Sidebar -->
		<jsp:include page="./dir.html/sidebar.html"></jsp:include>
		<!-- /#sidebar-wrapper -->



		<!-- Page Content -->
		<div id="page-content-wrapper" style="background-color: azure">
			<div class="container-fluid">

				<!-- import director main details -->
				<jsp:include page="./mainPageDirPart.jsp"></jsp:include>
				<!-- import employee details -->
				<jsp:include page="./empPageDirPart.jsp"></jsp:include>
				<!-- import employee details -->
				<%-- <jsp:include page="./balancePageDirPart.jsp"></jsp:include> --%>
				

			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="../../bootstrap/js/jquery.js"></script>
	
	<!-- director scripts -->
	<script src="./dir.html/dir.js"></script>
	

	<!-- Bootstrap Core JavaScript -->
	<script src="../../bootstrap/js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	 <script src="../../bootstrap/js/plugins/morris/raphael.min.js"></script>
	<script src="../../bootstrap/js/plugins/morris/morris.min.js"></script>
	<script src="../../bootstrap/js/plugins/morris/morris-data.js"></script>

	<!-- Menu Toggle Script -->
	

</body>
</html>
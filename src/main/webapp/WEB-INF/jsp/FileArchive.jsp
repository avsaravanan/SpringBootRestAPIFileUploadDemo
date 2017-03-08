<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://getbootstrap.com/favicon.ico">

<title>File Upload - Archive</title>

<!-- Bootstrap core CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body ng-app="archiveApp" ng-controller="fileCtrl">

	<div class="container col-md-10">
		<h1>Spring Boot File Upload Project</h1>
		<div class="panel panel-default form-horizontal">
			<div class="panel-heading">
				<h3>REST API File Archive</h3>
			</div>
			<div class="panel-body">

				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="col-md-2">File #</th>
								<th>File Name</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="file in files">
								<td scope=row>{{file.fileId}}</td>
								<td>{{file.fileName}}</td>
							</tr>
						</tbody>
					</table>
					
				</div>

			</div>


		</div>
	</div>
	<hr class="featurette-divider" />

			<!-- FOOTER -->
			<footer> </footer>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

	<script type="text/javascript">
		var app = angular.module('archiveApp', []);

		app.controller('fileCtrl', function($scope, $http) {

			$http.get("http://localhost:8080/rest/getallfiles").success(
					function(response) {
						$scope.files = response;
					});
		});
	</script>

</body>
</html>

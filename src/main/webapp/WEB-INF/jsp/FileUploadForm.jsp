<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>FileUpload - Archive</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" >


   
  </head>

  <body>

    <div class="container">
<div class="panel panel-default form-horizontal">
		<div class="panel-heading">
			<h3 class="panel-title">Spring Boot Rest API File Upload Form</h3>
		</div>
		<div class="panel-body">
			<form id="upform" class="form-horizontal" role="form" enctype="multipart/form-data"method="post" action="/rest/upload">
				
						<input type="hidden" name="fileId" value=""/>

						<input type="hidden" name="fileName" value=""/>

				<div class="form-group">
					<label class="col-lg-3 col-md-3 control-label">Attach File:</label>
					<div class="col-lg-3 col-md-3">
						<input type="file" name="file" id="attachFiles" multiple />
					</div>
				</div>
				<div class="panel panel-default bgsolid">
					<div class="panel-body">
						<button type="submit"
							class="btn btn-primary col-md-2 col-md-offset-4 col-lg-2 col-lg-offset-4 col-sm-2 col-sm-offset-4">
							<strong>Submit &rarr;</strong>
						</button>
					</div>
				</div>
			</form>
		</div>
	

     

</div>

 <hr class="featurette-divider"/>

      <!-- /END THE FEATURETTES -->


      <!-- FOOTER -->
      <footer>
        
	      
      </footer>

    </div>
    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script> 
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript">
	
  </script>
  
</body></html>

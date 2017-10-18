<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE HTML>
<html>
	<head>
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/gscp.css" />" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		<script src="<c:url value="/resources/js/validator.min.js" />"></script>
	</head>
	<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color: #e3f2fd;">
			<img src="<c:url value="/resources/images/logo.png" />" width="30" height="30" alt="">
			<a class="navbar-brand" href="#">GSCP</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
      			<span class="navbar-toggler-icon"></span>
    		</button>
			<div class="collapse navbar-collapse" width="80%" id="navbarColor03">
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item">
          				<a class="nav-link" href="/gscp/profile">Profile</a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item">
          				<a class="nav-link" href="/gscp/application/home">Application <span class="sr-only">(current)</span></a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item active">
          				<a class="nav-link" href="/gscp/accommodation/home">Accommodation</a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item">
          				<a class="nav-link" href="/gscp/trading/home">Trading</a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item">
          				<a class="nav-link" href="/gscp/forum/home">Forum</a>
        			</li>
      			</ul>
    		</div>
		</nav>
		
		<!-- Add your html code here  -->
		<div class="card text-center">
		<nav class="nav nav-pills nav-fill">
  					<a class="nav-item nav-link" href="/gscp/accommodation/home">Find a house</a>
					<a class="nav-item nav-link active" href="/gscp/accommodation/home/post">Post a house</a>
			</nav> 
		<h2>Welcome,${user_first} ${user_last}!</h2>
		<h5>Post Your House Here</h5>
		<form action="/gscp/accommodation/home/post" method="POST" enctype="multipart/form-data">
		<div class="card-body">
      		<div class="form-group row">
	   	 		<label for="Type" class="col-sm-2 col-form-label">Type</label>
	   	 		<div class="col-sm-8">
	    			<input type="input" class="form-control" id="type" name="type" placeholder="Choose from house, unit, apartment" required />
    				</div>
    			</div>
    			<div class="form-group row">
	   	 		<label for="Suburb" class="col-sm-2 col-form-label">Suburb</label>
	   	 		<div class="col-sm-8">
	    			<input type="input" class="form-control" id="suburb" name="suburb" placeholder="input a suburb here" required />
    				</div>
    			</div>
    			<div class="form-group row">
   	 			<label for="pricePw" class="col-sm-2 col-form-label">Weekly rent</label>
   	 			<div class="col-sm-8">
    				<input type="input" class="form-control" id="pricePw" name="pricePw" placeholder="Please input an integer here" required />
    				</div>
    			</div>
    			<div class="form-group row">
   	 			<label for="postcode" class="col-sm-2 col-form-label">Postcode</label>
   	 			<div class="col-sm-8">
    				<input type="input" class="form-control" id="postcode" name="postcode" placeholder="Please input the postcode here" required />
    				</div>
    			</div>
    			<div class="form-group row">
   	 			<label for="bedroom" class="col-sm-2 col-form-label">Bedroom Numbers</label>
   	 			<div class="col-sm-8">
    				<input type="input" class="form-control" id="bedroom" name="bedroom" placeholder="Please input a bedroom number here" required />
    				</div>
    			</div>
    			<div class="form-group row">
   	 			<label for="description" class="col-sm-2 col-form-label">Description</label>
   	 			<div class="col-sm-8">
   	 			<textarea class="form-control" id="content" name="content" rows="5" placeholder="Input the detailed description" required></textarea>
    				</div>
    			</div>
    			<div class="form-group row">
   	 			<label for="fileUpload" class="col-sm-2 col-form-label">Image </label>
   	 			<input type="file" id="fileUpload" name="file" />
   	 			<button type="submit" class="btn btn-success">Submit</button>
   	 		</div>
   	 		
   	 	</div>
   	 	</form>
      </div>
     
	</div>
		
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
          				<a class="nav-link" href="/gscp/application/home">Application</a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item">
          				<a class="nav-link" href="/gscp/accommodation/home">Accommodation</a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item">
          				<a class="nav-link" href="/gscp/trading/home">Trading</a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item active">
          				<a class="nav-link" href="/gscp/forum/home">Forum  <span class="sr-only">(current)</span></a>
        			</li>
      			</ul>
    		</div>
		</nav>
		
		<!-- Add your html code here  -->
		<div class="card">
  			<div class="card-body">
  				<div class="text-center">
    				<h2>Welcome, ${current_user.first} ${current_user.last}!</h2>
    				<c:if test="${success != null}">
    					<div class="alert alert-success" role="alert">
    						${success}
    					</div>
    				</c:if>
    			</div>
   			 	<nav class="nav nav-pills nav-fill">
  					<a class="nav-item nav-link" href="/gscp/trading/repository">Your repository</a>
					<a class="nav-item nav-link" href="/gscp/trading/new_post">Post</a>
					<a class="nav-item nav-link" href="/gscp/trading/market">Search</a>
					<a class="nav-item nav-link" href="/gscp/trading/orders">Order</a>
				</nav>
				<div class="col-12">
   			 		<form action="/gscp/trading/new_post" method="POST">
   			 			<div class="form-group row">
  	 						<label for="title" class="col-sm-2 col-form-label">Title</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="title" name="title" placeholder="Input book title here..." required />
   							</div>
  	 					</div>
     					<div class="form-group row">
  	 						<label for="edition" class="col-sm-2 col-form-label">Edition</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="edition" name="edition" placeholder="Input book edition here..." required />
   							</div>
  	 					</div>
  	 					<div class="form-group row">
  	 						<label for="author" class="col-sm-2 col-form-label">Author</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="author" name="author" placeholder="Input author here..." required />
   							</div>
  	 					</div>
  	 					<div class="form-group row">
  	 						<label for="year" class="col-sm-2 col-form-label">Year</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="year" name="year" placeholder="Input publish year here..." required />
   							</div>
  	 					</div>
  	 					<div class="form-group row">
  	 						<label for="subject" class="col-sm-2 col-form-label">Subject</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="subject" name="subject" placeholder="Input subject here..." required />
   							</div>
  	 					</div>
  	 					<div class="form-group row">
  	 						<label for="price" class="col-sm-2 col-form-label">Price</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="price" name="price" placeholder="Input price here..." required />
   							</div>
  	 					</div>
	 					<div class="text-center">
	 						<a href="/gscp/trading/home" class="btn btn-secondary">Back</a>
	 						<button type="submit" class="btn btn-primary">Submit</button>
	 					</div>
    			 	</form>
    			 </div>
    		</div>
    	</div>
    </div>
	</body>
</html>
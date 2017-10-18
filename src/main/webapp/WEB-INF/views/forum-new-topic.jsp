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
    			</div>
    			<div class="row">
    			 	<div class="col-2 text-center" style="border-right: 2px solid #ccc;">
    			 		<h4>Navigator</h4>
    			 		<a href="/gscp/forum/home" class="btn btn-dark btn-block">Home</a>
    			 		<a href="/gscp/forum/topics" class="btn btn-primary btn-block">My Topics</a>
    			 		<a href="/gscp/forum/comments" class="btn btn-warning btn-block">My Comments</a>
    			 	</div>
    			 	<div class="col-10">
    			 		<form action="/gscp/forum/new/topic" method="post">
    			 			<div class="form-group row">
   	 							<label for="title" class="col-sm-2 col-form-label">Title</label>
   	 							<div class="col-sm-8">
    								<input type="input" class="form-control" id="title" name="title" placeholder="Input your title here..." required />
    							</div>
   	 						</div>
      						<div class="form-group row">
   	 							<label for="content" class="col-sm-2 col-form-label">Content</label>
   	 							<div class="col-sm-8">
   	 								<textarea class="form-control" id="content" name="content" rows="15" placeholder="Input your content here..." required></textarea>
    							</div>
   	 						</div>
   	 						<div class="text-center">
   	 							<a href="/gscp/forum/home" class="btn btn-secondary">Back</a>
   	 							<button type="submit" class="btn btn-primary">Submit</button>
   	 						</div>
    			 		</form>
    			 	</div>
    			 </div>
  			</div>
		</div>
	</div>
	</body>
</html>
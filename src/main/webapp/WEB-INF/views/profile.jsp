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
        			<li class="nav-item active">
          				<a class="nav-link" href="/gscp/profile">Profile <span class="sr-only">(current)</span></a>
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
          				<a class="nav-link" href="./profile">Trading</a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item">
          				<a class="nav-link" href="./profile">Forum</a>
        			</li>
      			</ul>
    		</div>
		</nav>
		
		<!-- Add your html code here  -->
		<div class="card text-center">
  			<div class="card-body">
    			<h2>Welcome,${user_first} ${user_last}!</h2>
    			<form action="/gscp/application/home" method="post">
    				<div class="form-group row">
        				<label for="email" class="col-sm-2 col-form-label">Email Address:</label>
        				<div class="col-sm-8">
          					<input type="input" class="form-control" id="current_email" name="current_email" value="${user_email}" readonly/>
        				</div>
      				</div>
      				<div class="form-group row">
        				<label for="phone" class="col-sm-2 col-form-label">Phone:</label>
        				<div class="col-sm-8">
          					<input type="input" class="form-control" id="current_phone" name="current_phone" value="${user_phone}" readonly/>
        				</div>
      				</div>
      				<div class="form-group row">
        				<label for="email" class="col-sm-2 col-form-label">Your Role:</label>
        				<div class="col-sm-8">
          					<input type="input" class="form-control" id="current_role" name="current_role" value="${user_role}" readonly/>
        				</div>
      				</div>
    			</form>
  			</div>
		</div>
	</div>
	</body>
</html>
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
	</head>
	<body>
	<div class="container">
		<div class="card text-center">
  			<div class="card-body">
    			<h4 class="card-title">Welcome the GSCP!</h4>
    			<h6 class="card-subtitle mb-2 text-muted">Global Student Communication Platform</h6>
    			<form action="./register" method="POST" role="form" data-toggle="validator">
    				<div class="form-group row">
   	 					<label for="userName" class="col-sm-2 col-form-label">User Name</label>
   	 					<div class="col-sm-8">
    						<input type="input" class="form-control" id="userName" name="username" placeholder="User Name" required />
    					</div>
   	 				</div>
					<div class="form-group row">
    					<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
    					<div class="col-sm-8">
    						<input type="email" class="form-control" id="inputEmail3" name="email" placeholder="Email" data-error="Bruh, that email address is invalid" required />
    						<div class="help-block with-errors"></div>
    					</div>
    				</div>
    				<div class="form-group row">
      					<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
      					<div class="col-sm-8">
        					<input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password" required />
      					</div>
   	 				</div>
   	 				<div class="form-group row">
      					<label for="confirmPassword" class="col-sm-2 col-form-label">Confirm Password</label>
      					<div class="col-sm-8">
        					<input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password" data-match="#inputPassword" data-match-error="Whoops, these passwords don't match" required />
        					<div class="help-block with-errors"></div>
      					</div>
   	 				</div>
   	 				<div class="form-group row">
   	 					<label for="firstName" class="col-sm-2 col-form-label">First Name</label>
   	 					<div class="col-sm-8">
    						<input type="input" class="form-control" id="firstName" name="firstname" placeholder="First Name" required />
    					</div>
   	 				</div>
   	 				<div class="form-group row">
   	 					<label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
   	 					<div class="col-sm-8">
    						<input type="input" class="form-control" id="lastName" name="lastname" placeholder="Last Name" required />
    					</div>
   	 				</div>
   	 				 <div class="form-group row">
   	 					<label for="phone" class="col-sm-2 col-form-label">Phone</label>
   	 					<div class="col-sm-8">
    						<input type="input" class="form-control" id="phone" name="phone" placeholder="Phone" required />
    					</div>
   	 				</div>
   	 				<a href="./index" class="btn btn-secondary">Back</a>
    				<button type="submit" class="btn btn-primary"> Sign Up Now!</button>
    			</form>
  			</div>
  		</div>
  	</div>
	</body>
</html>
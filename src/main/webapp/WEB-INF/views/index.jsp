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
		<div class="card text-center">
  			<div class="card-body">
    			<h4 class="card-title">Welcome the GSCP!</h4>
    			<h6 class="card-subtitle mb-2 text-muted">Global Student Communication Platform</h6>
    			<c:if test="${not empty message}" >
    				<div class="alert alert-danger" role="alert">
						${message}
					</div>
				</c:if>
    			<form action="./index" method="POST" role="form" data-toggle="validator">
    				<div class="form-group row">
   	 					<label for="userName" class="col-sm-2 col-form-label">Account</label>
   	 					<div class="col-sm-8">
    						<input type="input" class="form-control" id="account" name="account" placeholder="User Name or Email" required />
    					</div>
   	 				</div>
   	 				<div class="form-group row">
      					<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
      					<div class="col-sm-8">
        					<input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password" required />
      					</div>
   	 				</div>
   	 				
    				<button type="submit" class="btn btn-primary">Login</button>
    				<a href="./register" class="btn btn-warning">Register Now!</a>
    		</div>
    	</div>
    </div>
	</body>
</html>
<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE HTML>
<html>
	<head>
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/gscp.css" />" rel="stylesheet">
	</head>
	<body>
	<div class="container">
		<div class="card text-center">
  			<div class="card-body">
    			<h4 class="card-title">Welcome the GSCP!</h4>
    			<h6 class="card-subtitle mb-2 text-muted">Global Student Communication Platform</h6>
    			<form action="./register" method="POST">
    				<button type="submit" class="btn btn-primary"> Sign Up Now!</button>
    			</form>
  			</div>
  		</div>
  	</div>
	</body>
</html>
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
    			<div class="row">
    			 	<div class="col-2 text-center" style="border-right: 2px solid #ccc;">
    			 		<h4>Navigator</h4>
    			 		<a href="/gscp/forum/home" class="btn btn-dark btn-block">Home</a>
    			 		<a href="/gscp/forum/topics" class="btn btn-primary btn-block">My Topics</a>
    			 		<a href="/gscp/forum/comments" class="btn btn-warning btn-block">My Comments</a>
    			 		<a href="/gscp/forum/new/topic" class="btn btn-success btn-block">New Topics</a>
    			 	</div>
    			 	<div class="col-10">
    			 		<div class="row">
    			 			<div class="col-9" style="padding-left: 30px;">
    			 				<h4>Topics</h4>
    			 			</div>
    			 			<div class="col-3">
    			 				<h4>Date</h4>
    			 			</div>
    			 			<c:forEach items="${topics}" var="topic">
    			 				<div class="col-9" style="padding-left: 30px;">
    			 					<a href="/gscp/forum/${phrase}/${topic.id}">${topic.title}</a>
    			 				</div>
    			 				<div class="col-3">
    			 					<p>${topic.date}</p>
    			 				</div>
    			 			</c:forEach>
    			 		</div>
    			 		
    			 	</div>
    			 </div>
  			</div>
		</div>
	</div>
	</body>
</html>
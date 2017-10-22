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
	<script>
	function LinkFormatter(value, row, index) {
		  return "<a href='"+row.url+"'>"+value+"</a>";
		}
    </script>
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
					<a class="nav-item nav-link" href="/gscp/application/student/history">Order</a>
				</nav>
				
				<table class="table table-hover">
				    <thead>
				      <tr>
				        <th>#</th>
				        <th>Title</th>
				        <th>Edition</th>
				        <th>Author</th>
				        <th>Year</th>
				        <th>Subject</th>
				        <th>Price</th>
				        <th>Option</th>
				      </tr>
				    </thead>
				    
				    <tbody>
				    <c:forEach items="${books}" var="book">
				    	<tr>
					    	<td>${ book.id }</td>
					        <td>${ book.title }</td>
					        <td>${ book.edition }</td>
					        <td>${ book.author }</td>
					        <td>${ book.year }</td>
					        <td>${ book.subject }</td>
					        <td>${ book.price }</td>
					        <td></td>
					    </tr>
				    </c:forEach>
				    </tbody>
				 </table>
			 </div>
		 </div>
	 </div>
	 </body>
</html>
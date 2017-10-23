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
  					<a class="nav-item nav-link active" href="/gscp/trading/repository">Your repository</a>
					<a class="nav-item nav-link" href="/gscp/trading/new_post">Post</a>
					<a class="nav-item nav-link" href="/gscp/trading/market">Search</a>
					<a class="nav-item nav-link" href="/gscp/trading/orders">Order</a>
				</nav>
				<br>
				<c:if test="${type == 'view'}">
 			 	<div class="table-responsive">          
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
				        <th>Status</th>
				        <th>Edit</th>
				        <th>Option</th>
				      </tr>
				    </thead>
				    <tbody>
				    
				    <c:forEach items="${books}" var="book"> 
				    	<c:set var="count" value="${ book.id }" scope="page" />
					    	<tr class='clickable-row' data-href='url:/gscp/trading/home'>
					    		<td>${ book.id }</td>
						        <td>${ book.title }</td>
						        <td>${ book.edition }</td>
						        <td>${ book.author }</td>
						        <td>${ book.year }</td>
						        <td>${ book.subject }</td>
						        <td>${ book.price }</td>
						        <td>${ book.status }</td>
						        <td>
						        	<a href="/gscp/trading/repository/${count}" class="btn btn-primary">Edit</a>
						        </td>
						        <td>
				        			<c:if test="${book.status == 'Host'}">
					        			<form action="/gscp/trading/repository/status" method="POST">
					        				<input type="hidden" name = "book-id" value="${ book.id }">
					        				<button type="submit" class="btn btn-info">Post</button>
					        			</form>
				        			</c:if>
				        			<c:if test="${book.status == 'Post'}">
					        			<form action="/gscp/trading/repository/status" method="POST">
					        				<input type="hidden" name = "book-id" value="${ book.id }">
					        				<button type="submit" class="btn btn-danger">Cancel</button>
					        			</form>
				        			</c:if>

						        </td>
					      	</tr>
				    </c:forEach>
				    </tbody>
				  </table>
				</div>
				</c:if>
				<c:if test="${type == 'details'}">
					<div class="col-12">
   			 		<form action="/gscp/trading/repository" method="POST">
   			 			<input type="hidden" name="book-id" value="${book.id}" />
   			 			<div class="form-group row">
  	 						<label for="title" class="col-sm-2 col-form-label">Title</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="title" name="title" value = "${book.title}" required />
   							</div>
  	 					</div>
     					<div class="form-group row">
  	 						<label for="edition" class="col-sm-2 col-form-label">Edition</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="edition" name="edition" value = "${book.edition}" required />
   							</div>
  	 					</div>
  	 					<div class="form-group row">
  	 						<label for="author" class="col-sm-2 col-form-label">Author</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="author" name="author" value = "${book.author}" required />
   							</div>
  	 					</div>
  	 					<div class="form-group row">
  	 						<label for="year" class="col-sm-2 col-form-label">Year</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="year" name="year" value = "${book.year}" required />
   							</div>
  	 					</div>
  	 					<div class="form-group row">
  	 						<label for="subject" class="col-sm-2 col-form-label">Subject</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="subject" name="subject" value = "${book.subject}" required />
   							</div>
  	 					</div>
  	 					<div class="form-group row">
  	 						<label for="price" class="col-sm-2 col-form-label">Price</label>
  	 						<div class="col-sm-8">
   								<input type="text" class="form-control" id="price" name="price" value = "${book.price}" required />
   							</div>
  	 					</div>
	 					<div class="text-center">
	 						<a href="/gscp/trading/repository" class="btn btn-secondary">Back</a>
	 						<button type="submit" class="btn btn-success">Update</button>
	 					</div>
    			 	</form>
    			 </div>
				</c:if>
    		</div>
    	</div>
    </div>
	</body>
</html>
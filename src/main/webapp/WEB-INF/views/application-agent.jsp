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
		<script src="<c:url value="/resources/js/update-application.js" />"></script>
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
        			<li class="nav-item active">
          				<a class="nav-link" href="/gscp/application/home">Application <span class="sr-only">(current)</span></a>
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
        			<li class="nav-item">
          				<a class="nav-link" href="/gscp/forum/home">Forum</a>
        			</li>
      			</ul>
    		</div>
		</nav>
		
		<!-- Add your html code here  -->
		<div class="card text-center">
  			<div class="card-body">
    			<nav class="nav nav-pills nav-fill">
  					<a class="nav-item nav-link" href="/gscp/application/home">Home</a>
					<a class="nav-item nav-link active" href="/gscp/application/agent">Student Applications</a>
				</nav>
				<h2>Students' Applications</h2>
				<c:if test="${type == 'list'}">
				<div class="row">
					<c:set var="count" value="1" scope="page" />
					<c:forEach items="${applications}" var="application">
						<c:forEach items="${degrees}" var="degree">
							<c:if test="${application.degreeId == degree.id }">
								<c:set var="degree_name" value="${degree.name}" scope="page"/>
								<c:set var="uni_id" value="${degree.uniId}" scope="page"/>
							</c:if>
						</c:forEach>
						<c:forEach items="${universities}" var="university">
							<c:if test="${uni_id == university.id }">
								<c:set var="university_name" value="${university.name}" scope="page"/>
								<c:set var="university_image" value="${university.image}" scope="page"/>
							</c:if>
						</c:forEach>		
						<div class="card" style="width: 20rem;">
  							<img class="card-img-top" src="<c:url value="/resources/images/${university_image}" />" alt="Card image cap">
  							<div class="card-body">
    							<h4 class="card-title">${university_name}</h4>
    							<h6 class="card-subtitle mb-2 text-muted">${degree_name}</h6>
    							<p class="card-text">${application.title}</p>
    							<a href="/gscp/application/agent/${count}" class="btn btn-primary">Details</a>
  							</div>
						</div>
						<c:set var="count" value="${count + 1}" scope="page" />
					</c:forEach>
				</div>
				</c:if>
				<c:if test="${type == 'details'}">
				<div class="media">
  					<img class="d-flex align-self-center mr-3" src="<c:url value="/resources/images/${university.image}" />" alt="Generic placeholder image">
  					<div class="media-body">
    					<h4 class="mt-0">${university.name}</h4>
    					<h6 class="mt-0">${degree.name}</h6>
    					<form action="/gscp/application/agent" method="POST">
    						<div class="form-group row">
   	 							<label for="title" class="col-sm-2 col-form-label">Title</label>
   	 							<div class="col-sm-8">
    								<input type="input" class="form-control" id="title" name="title" value="${application.title}" required />
    							</div>
   	 						</div>
      						<div class="form-group row">
   	 							<label for="content" class="col-sm-2 col-form-label">Content</label>
   	 							<div class="col-sm-8">
   	 								<textarea class="form-control" id="content" name="content" rows="15" required>${application.content}</textarea>
    							</div>
   	 						</div>
   	 						<input type="hidden" name="application-id" value="${application.id}" />
   	 						<c:forEach items="${documents}" var="document">
   	 							<a href="/gscp/downloads/${document.path}"> ${document.name} </a>
   	 						</c:forEach>
   	 						<c:if test="${application.status == 0}">
   	 							<div class="progress">
  									<div id="status-bar" class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">Submitted</div>
								</div>
   	 						</c:if>
   	 						<c:if test="${application.status == 1}">
   	 							<div class="progress">
  									<div id="status-bar" class="progress-bar bg-warning" role="progressbar" style="width: 50%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">Editing</div>
								</div>
   	 						</c:if>
   	 						<c:if test="${application.status == 2}">
   	 							<div class="progress">
  									<div id="status-bar" class="progress-bar bg-info" role="progressbar" style="width: 75%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">Processing</div>
								</div>
   	 						</c:if>
   	 						<c:if test="${application.status == 3}">
   	 							<div class="progress">
  									<div id="status-bar" class="progress-bar bg-success" role="progressbar" style="width: 100%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">Successful</div>
								</div>
   	 						</c:if>
   	 						<c:if test="${application.status == 4}">
   	 							<div class="progress">
  									<div id="status-bar" class="progress-bar bg-danger" role="progressbar" style="width: 100%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">Failed</div>
								</div>
   	 						</c:if>
   	 						<div class="btn-group" role="group" aria-label="Basic example">
   	 							<button type="button" class="btn btn-secondary" onclick="updateStatus('submitted')">Submitted</button>
   	 							<button type="button" class="btn btn-secondary" onclick="updateStatus('editing')">Editing</button>
   	 							<button type="button" class="btn btn-secondary" onclick="updateStatus('processing')">Processing</button>
   	 							<button type="button" class="btn btn-secondary" onclick="updateStatus('successful')">Successful</button>
   	 							<button type="button" class="btn btn-secondary" onclick="updateStatus('failed')">Failed</button>
   	 						</div>
   	 						<input id="status-value" type="hidden" value="${application.status}" name="status"/>
   	 						<br><br>
   	 						<button type="submit" class="btn btn-success">Update</button>
    					</form>
    				</div>
				</div>
				</c:if>
  			</div>
		</div>
	</div>
	</body>
</html>
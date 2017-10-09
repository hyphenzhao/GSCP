<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE HTML>
<html>
	<head>
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/gscp.css" />" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
		<script src="<c:url value="/resources/js/validator.min.js" />"></script>
		<script src="<c:url value="/resources/js/new-application.js" />"></script>
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
          				<a class="nav-link" href="/gscp/profile">Profile <span class="sr-only">(current)</span></a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item active">
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
					<a class="nav-item nav-link active" href="/gscp/application/student/new">New Applications</a>
					<a class="nav-item nav-link" href="/gscp/application/student/history">My Applications</a>
				</nav>
				<form action="/gscp/application/student/new" method="POST" enctype="multipart/form-data">
				
				<!-- ++++++++++++++++++++++++++++++FORM START++++++++++++++++++++++++++++++ -->		
<div id="accordion" role="tablist">
<div class="card">
    <div class="card-header" role="tab" id="headingOne">
      <h5 class="mb-0">
        <a data-toggle="collapse" id="university_selection" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          University
        </a>
      </h5>
    </div>

    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body">
        <div class="row">
        <!-- ++++++++++++++++++++++++++++++Content One++++++++++++++++++++++++++++++ -->
        <c:forEach items="${universities}" var="uni">
			<div class="card" style="width: 20rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${uni.image}" />" alt="${uni.name} Images">
  				<div class="card-body">
    				<h4 class="card-title">${uni.name}</h4>
    				<p class="card-text">${uni.description}<a href="${uni.url}">More...</a></p>
    				<button type="button" class="btn btn-info" onclick="selectUniversity('${uni.id}','${uni.name}')">Select</button>
  				</div>
			</div>
		</c:forEach>
		<!-- ++++++++++++++++++++++++++++++Content One++++++++++++++++++++++++++++++ -->
      </div>
      <input id="university_selection_value" type="hidden" name="university" />
    </div>
  </div>
</div>
  <div class="card">
    <div class="card-header" role="tab" id="headingTwo">
      <h5 class="mb-0">
        <a class="collapsed" data-toggle="collapse" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" id="degree_selection">
          Degree
        </a>
      </h5>
    </div>
    <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo" data-parent="#accordion">
      <div class="card-body">
      <div class="row">
		<c:forEach items="${degrees}" var="degree">
			<c:forEach items="${universities}" var="uni">
				<c:if test="${degree.uniId == uni.id}">			
					<div class="card degree-selection" style="width: 20rem;" name="${uni.name}">
  						<img class="img-rounded" src="<c:url value="/resources/images/${uni.image}" />" alt="${uni.name} Images">
  						<div class="card-body">
    						<h4 class="card-title">${degree.name}</h4>
    						<p class="card-text">${degree.description}<a href="${uni.url}">More...</a></p>
    						<button type="button" class="btn btn-info" onclick="selectDegree('${degree.id}','${degree.name}')">Select</button>
  						</div>
					</div>
				</c:if>
			</c:forEach>
		</c:forEach>
	  </div>
	  <input id="degree_selection_value" type="hidden" name="degree" /> 
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" role="tab" id="headingThree">
      <h5 class="mb-0">
        <a class="collapsed" data-toggle="collapse" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree" id="agent_selection">
          Agent
        </a>
      </h5>
    </div>
    <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree" data-parent="#accordion">
      <div class="card-body">
      	<c:forEach items="${agents}" var="agent">
			<div class="card" style="width: 20rem;">
  				<img class="img-rounded" width="256" src="<c:url value="/resources/images/photo.png" />" alt="Agent Profile Images">
  				<div class="card-body">
    				<h4 class="card-title">${agent.first} ${agent.last}</h4>
    				<p class="card-text">
    					Email: ${agent.email} <br>
    					Phone: ${agent.phone}
    				</p>
    				<button type="button" class="btn btn-info" onclick="selectAgent('${agent.id}','${agent.first} ${agent.last}')">Select</button>
  				</div>
			</div>
		</c:forEach>
      </div>
       <input id="agent_selection_value" type="hidden" name="agent" /> 
    </div>
  </div>
  <div class="card">
    <div class="card-header" role="tab" id="headingFour">
      <h5 class="mb-0">
        <a class="collapsed" data-toggle="collapse" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
          Document
        </a>
      </h5>
    </div>
    <div id="collapseFour" class="collapse" role="tabpanel" aria-labelledby="headingFour" data-parent="#accordion">
      <div class="card-body">
      	<div class="form-group row">
   	 		<label for="title" class="col-sm-2 col-form-label">Title</label>
   	 		<div class="col-sm-8">
    			<input type="input" class="form-control" id="title" name="title" placeholder="Input your application title here..." required />
    		</div>
   	 	</div>
      	<div class="form-group row">
   	 		<label for="content" class="col-sm-2 col-form-label">Content</label>
   	 		<div class="col-sm-8">
   	 			<textarea class="form-control" id="content" name="content" rows="15" placeholder="Input your application content here..." required></textarea>
    		</div>
   	 	</div>
   	 	<div class="form-group row">
   	 		<label for="fileUpload" class="col-sm-2 col-form-label">Attachment: </label>
   	 		<input type="file" id="fileUpload" name="file" />
   	 		<button type="submit" class="btn btn-success">Submit</button>
   	 	</div>
      </div>
    </div>
  </div>
</div>
				<!-- ++++++++++++++++++++++++++++++FORM END++++++++++++++++++++++++++++++ -->
				</form>    			
  			</div>
		</div>
	</div>
	</body>
</html>
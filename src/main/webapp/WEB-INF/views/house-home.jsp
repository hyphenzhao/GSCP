<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE HTML>
<html>
	<head>
		<style> 
		input[type=text] {
		    width: 600px;
		    box-sizing: border-box;
		    border: 2px solid #ccc;
		    border-radius: 4px;
		    font-size: 16px;
		    background-color: white;
		    background-image: url('<c:url value="/resources/images/searchicon.png" />');
		    background-size: 40px 40px;
		    background-position: 0px 5px; 
		    background-repeat: no-repeat;
		    padding: 12px 20px 12px 40px;
		    -webkit-transition: width 0.4s ease-in-out;
		    transition: width 0.4s ease-in-out;
		}
		
		input[type=text]:focus {
		    width: 100%;
		}
		.div-inline{display:inline}
		.btn{min-width:90px;
		max-height:40px}
		select#types{
			background-color:#91EB76;
		    width: 100px;
		    padding: 5px;
		    font-size: 16px;
		    border: 1px solid #ccc;
		    height: 34px;
		}
		select#price{
			background-color:#FFD700;
		    width: 100px;
		    padding: 5px;
		    font-size: 16px;
		    border: 1px solid #ccc;
		    height: 34px;
		}
		select#bedrooms{
			background-color:#ADD8E6;
		    width: 100px;
		    padding: 5px;
		    font-size: 16px;
		    border: 1px solid #ccc;
		    height: 34px;
		}
		</style>
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
          				<a class="nav-link" href="/gscp/profile">Profile <span class="sr-only">(current)</span></a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item">
          				<a class="nav-link" href="/gscp/application/home">Application</a>
        			</li>
      			</ul>
      			<ul class="navbar-nav mr-auto">
        			<li class="nav-item active">
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
    			<h4>Hi ${user_first}!  Find yourself a lovely place</h4>
    			
			<form>
			  <input type="text" name="search" placeholder="Search by suburb or postcode">
			</form>
			<section>
				<div class="div-inline">
					<select id="types">
					<option value="all">Types</option>
					<option value="House">House</option>
		  			<option value="Apartment">Apartment</option>
					<option value="Unit">Unit</option>
					</select>
					<select id = "price">
					<option value="all">Min price</option>
					<option value="200">100</option>
					<option value="200">200</option>
					<option value="300">300</option>
		  			<option value="400">400</option>
					<option value="500">500</option>
					</select>
					<select id = "price">
					<option value="all">Max price</option>
					<option value="200">100</option>
					<option value="200">200</option>
					<option value="300">300</option>
		  			<option value="400">400</option>
					<option value="500">more than 500</option>
					</select>
					<select id = "bedrooms">
					<option value="all">Bedroom</option>
					<option value="1">1</option>
					<option value="2">2</option>
		  			<option value="3">3</option>
					<option value="4">4</option>
					</select>
			</section>
  			</div>
		</div>
		<div class="card text-center">
		<div class="card-body">
        <div class="row">
			<c:forEach items="${houses}" var="houses">
				<div class="card" style="width: 22.85rem;">
	  				<img class="img-rounded" src="<c:url value="/resources/images/${houses.image}"/>" width=370px height = 300px>
	  				<div class="card-body">
	    				<p class="card-text">Type: ${houses.type} </p>
	    				<p class="card-text">Weekly price: ${houses.price}</p>
	    				<p class="card-text">Suburb: ${houses.subrub} Postcode: ${houses.postcode}</p>
	  				</div>
				</div>
			</c:forEach>
		</div>
		</div>
		</div>
	</div>
	</body>
</html>
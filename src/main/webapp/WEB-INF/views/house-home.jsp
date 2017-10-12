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
		.w-widget-map label {
		  width: auto;
		  display: inline;
		}
		.w-widget-map img {
		  max-width: inherit;
		}
		.w-widget-map .gm-style-iw {
		  width: 90% !important;
		  height: auto !important;
		  top: 7px !important;
		  left: 6% !important;
		  display: inline;
		  text-align: center;
		  overflow: hidden;
		}
		.w-widget-map .gm-style-iw + div {
		  display: none;
		}
		</style>
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/gscp.css" />" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		<script src="<c:url value="/resources/js/validator.min.js" />"></script>
	</head>
	
	<body onload=start()>
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
					<select id="types" onchange="showTypes()">
					<option value="all">Types </option>
					<option value="House">House</option>
		  			<option value="Apartment">Apartment</option>
					<option value="Unit">Unit</option>
					</select>
					
					<select id = "price">
					<option value="all">price</option>
					<option value="min">minimum</option>
					<option value="200">200-300</option>
					<option value="300">300-400</option>
					<option value="400">400-500</option>
		  			<option value="max">more than 500</option>
					</select>
					
					<select id = "bedrooms">
					<option value="all">Bedroom</option>
					<option value="1">1</option>
					<option value="2">2</option>
		  			<option value="3">3</option>
					<option value="4">4</option>
					</select>
					</div>
			</section>
		</div>
		
		<div class="card text-center">
		<h5>Your current location</h5>
		<div id="mapholder" data-widget-latlng="-33.8688197,151.2092955" class="w-widget-map"></div>
		<h3>House list</h3>
		<div class="card-body">
        <div class="row">
			<c:forEach items="${houses}" var="houses">
				<div class="card" style="width: 22.80rem;">
	  				<img class="img-rounded" src="<c:url value="/resources/images/${houses.image}"/>" width=370px height = 300px>
	  				<div class="card-body">
	    				<p class="card-text">Type: ${houses.type} </p>
	    				<p class="card-text">Weekly price: ${houses.price}</p>
	    				<p class="card-text">Suburb: ${houses.subrub} Postcode: ${houses.postcode}</p>
	  				</div>
				</div>
			</c:forEach>
		</div>
		<div class="row" id="ap">
		<c:forEach items="${apartmentHouse}" var="apartmentHouse">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${apartmentHouse.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${apartmentHouse.type} </p>
    				<p class="card-text">Weekly price: ${apartmentHouse.price}</p>
    				<p class="card-text">Suburb: ${apartmentHouse.subrub} Postcode: ${apartmentHouse.postcode}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		<div class="row" id="hh">
		<c:forEach items="${houseHouse}" var="houseHouse">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${houseHouse.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${houseHouse.type} </p>
    				<p class="card-text">Weekly price: ${houseHouse.price}</p>
    				<p class="card-text">Suburb: ${houseHouse.subrub} Postcode: ${houseHouse.postcode}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		<div class="row" id="un">
		<c:forEach items="${unitHouse}" var="unitHouse">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${unitHouse.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${unitHouse.type} </p>
    				<p class="card-text">Weekly price: ${unitHouse.price}</p>
    				<p class="card-text">Suburb: ${unitHouse.subrub} Postcode: ${unitHouse.postcode}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		</div>
		</div>
	</div>
	</body>
	<script>
		function start(){
			$("#ap").hide();
			$("#hh").hide();
			$("#un").hide();
			getLocation();
		}
		
		function hide(){
			$(".row").hide();
		}
		function showTypes(){
			var x = document.getElementById("types").value;
			if(x=="House"){
				showHouse();
			}else if(x=="Apartment"){
				showApartment();
			}else if(x=="Unit"){
				showUnit();
			}else{
				$(".row").show();
				start();
			}
		}
		function showHouse(){
			hide();
			$("#hh").show();
		}
		function showApartment(){
			hide();
			$("#ap").show();
		}
		function showUnit(){
			hide();
			$("#un").show();
		}
		</script>

 <script src="https://maps.google.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU"></script>
<script>
var x=document.getElementById("demo");
function getLocation()
  {
  if (navigator.geolocation)
    {
    navigator.geolocation.getCurrentPosition(showPosition,showError);
    }
  else{x.innerHTML="Geolocation is not supported by this browser.";}
  }

function showPosition(position)
  {
  var lat=position.coords.latitude;
  var lon=position.coords.longitude;
  var latlon=new google.maps.LatLng(lat, lon)
  var mapholder=document.getElementById('mapholder')
  mapholder.style.height='250px';
  mapholder.style.width='100%';

  var myOptions={
  center:latlon,zoom:14,
  mapTypeId:google.maps.MapTypeId.ROADMAP,
  mapTypeControl:false,
  navigationControlOptions:{style:google.maps.NavigationControlStyle.SMALL}
  };
  var map=new google.maps.Map(document.getElementById("mapholder"),myOptions);
  var marker=new google.maps.Marker({position:latlon,map:map,title:"You are here!"});
  }

function showError(error)
  {
  switch(error.code) 
    {
    case error.PERMISSION_DENIED:
      x.innerHTML="User denied the request for Geolocation."
      break;
    case error.POSITION_UNAVAILABLE:
      x.innerHTML="Location information is unavailable."
      break;
    case error.TIMEOUT:
      x.innerHTML="The request to get user location timed out."
      break;
    case error.UNKNOWN_ERROR:
      x.innerHTML="An unknown error occurred."
      break;
    }
  }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
<script src="<c:url value="/resources/js/webflow.js" />" type="text/javascript"></script>
</html>
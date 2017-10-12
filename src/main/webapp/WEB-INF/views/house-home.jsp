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
			  <input id = "search" type="text" name="search" onkeypress="return runScript(event)" placeholder="Search by suburb">
			
			</form>
			<section>
				<div class="div-inline">
					<select id="types" onchange="showTypes()">
					<option value="all">Types </option>
					<option value="House">House</option>
		  			<option value="Apartment">Apartment</option>
					<option value="Unit">Unit</option>
					</select>
					
					<select id = "price" onchange="showPrice()">
					<option value="all">Price</option>
					<option value="0">0-200</option>
					<option value="200">200-400</option>
					<option value="400">400-600</option>
		  			<option value="600">more than 600</option>
					</select>
					
					<select id = "bedrooms" onchange="showBedrooms()">
					<option value="all">Bedroom</option>
					<option value="1">1</option>
					<option value="2">2</option>
		  			<option value="3">more than 3</option>
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
	    				<p class="card-text">Details: ${houses.description}</p>
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
    				<p class="card-text">Details: ${apartmentHouse.description}</p>
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
    				<p class="card-text">Details: ${houseHouse.description}</p>
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
    				<p class="card-text">Details: ${unitHouse.description}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		
		
		
		
		<div class="row" id="house0">
		<c:forEach items="${house0}" var="house0">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${house0.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${house0.type} </p>
    				<p class="card-text">Weekly price: ${house0.price}</p>
    				<p class="card-text">Suburb: ${house0.subrub} Postcode: ${house0.postcode}</p>
    				<p class="card-text">Details: ${house0.description}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		<div class="row" id="house2">
		<c:forEach items="${house2}" var="house2">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${house2.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${house2.type} </p>
    				<p class="card-text">Weekly price: ${house2.price}</p>
    				<p class="card-text">Suburb: ${house2.subrub} Postcode: ${house2.postcode}</p>
    				<p class="card-text">Details: ${house2.description}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		<div class="row" id="house4">
		<c:forEach items="${house4}" var="house4">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${house4.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${house4.type} </p>
    				<p class="card-text">Weekly price: ${house4.price}</p>
    				<p class="card-text">Suburb: ${house4.subrub} Postcode: ${house4.postcode}</p>
    				<p class="card-text">Details: ${house4.description}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		<div class="row" id="house6">
		<c:forEach items="${house6}" var="house6">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${house6.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${house6.type} </p>
    				<p class="card-text">Weekly price: ${house6.price}</p>
    				<p class="card-text">Suburb: ${house6.subrub} Postcode: ${house6.postcode}</p>
    				<p class="card-text">Details: ${house6.description}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		
		
		<div class="row" id="bed1">
		<c:forEach items="${houseBed1}" var="houseBed1">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${houseBed1.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${houseBed1.type} </p>
    				<p class="card-text">Weekly price: ${houseBed1.price}</p>
    				<p class="card-text">Suburb: ${houseBed1.subrub} Postcode: ${houseBed1.postcode}</p>
    				<p class="card-text">Details: ${houseBed1.description}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		<div class="row" id="bed2">
		<c:forEach items="${houseBed2}" var="houseBed2">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${houseBed2.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${houseBed2.type} </p>
    				<p class="card-text">Weekly price: ${houseBed2.price}</p>
    				<p class="card-text">Suburb: ${houseBed2.subrub} Postcode: ${houseBed2.postcode}</p>
    				<p class="card-text">Details: ${houseBed2.description}</p>
  				</div>
			</div>
		</c:forEach>
		</div>
		<div class="row" id="bed3">
		<c:forEach items="${houseBed3}" var="houseBed3">
			<div class="card" style="width: 22.80rem;">
  				<img class="img-rounded" src="<c:url value="/resources/images/${houseBed3.image}"/>" width=370px height = 300px>
  				<div class="card-body">
    				<p class="card-text">Type: ${houseBed3.type} </p>
    				<p class="card-text">Weekly price: ${houseBed3.price}</p>
    				<p class="card-text">Suburb: ${houseBed3.subrub} Postcode: ${houseBed3.postcode}</p>
    				<p class="card-text">Details: ${houseBed3.description}</p>
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
			$("#house0").hide();
			$("#house2").hide();
			$("#house4").hide();
			$("#house6").hide();
			$("#bed1").hide();
			$("#bed2").hide();
			$("#bed3").hide();
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
		function showPrice(){
			var x = document.getElementById("price").value;
			if(x=="0"){
				showPrice0()
			}else if(x=="200"){
				showPrice2()
			}else if(x=="400"){
				showPrice4()
			}else if(x=="600"){
				showPrice6()
			}else{
				$(".row").show();
				start();
			}
		}
		function showBedrooms(){
			var x = document.getElementById("bedrooms").value;
			if(x=="1"){
				showBed1()
			}else if(x=="2"){
				showBed2()
			}else if(x=="3"){
				showBed3()
			}else{
				$(".row").show();
				start();
			}
		}
		function showBed1(){
			hide();
			$("#bed1").show();
		}
		function showBed2(){
			hide();
			$("#bed2").show();
		}
		function showBed3(){
			hide();
			$("#bed3").show();
		}
		function showPrice0(){
			hide();
			$("#house0").show();
		}
		function showPrice2(){
			hide();
			$("#house2").show();
		}
		function showPrice4(){
			hide();
			$("#house4").show();
		}
		function showPrice6(){
			hide();
			$("#house6").show();
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
<script>
function runScript(e){
	if(e.keyCode == 13){
		var tb = document.getElementById("search");
		eval(tb.value);
		return false;
	}
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
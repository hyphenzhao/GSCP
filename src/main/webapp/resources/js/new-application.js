function selectUniversity(id, name) {
	document.getElementById("university_selection").innerHTML = "University: " + name;
	document.getElementById("university_selection_value").value = id;
	var degreeCards = document.getElementsByClassName("degree-selection");
	for(var i = 0; i < degreeCards.length; i++) {
		if(degreeCards[i].attributes["name"].value != name) {
			degreeCards[i].style.display = 'none';
		} else {
			degreeCards[i].style.display = 'block';
		}
	}
	$("#collapseTwo").collapse('toggle');
}

function selectDegree(id, name) {
	document.getElementById("degree_selection").innerHTML = "Degree: " + name;
	document.getElementById("degree_selection_value").value = id;
	$("#collapseThree").collapse('toggle');
}

function selectAgent(id, name) {
	document.getElementById("agent_selection").innerHTML = "Agent: " + name;
	document.getElementById("agent_selection_value").value = id;
	$("#collapseFour").collapse('toggle');
}
function selectUniversity(id, name) {
	document.getElementById("university_selection").innerHTML = "University: " + name;
	document.getElementById("university_selection_value").value = id;
	$("#collapseOne").collapse('toggle');
	$("#collapseTwo").collapse('toggle');
}
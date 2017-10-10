function updateStatus(status) {
	var status_bar = document.getElementById("status-bar");
	var status_value = document.getElementById("status-value");
	switch(status) {
		case "submitted":
			status_bar.setAttribute("class", "progress-bar");
			status_bar.setAttribute("style", "width: 25%;");
			status_bar.innerHTML = "Submitted";
			status_value.value = "0";
			break;
		case "editing":
			status_bar.setAttribute("class", "progress-bar bg-warning");
			status_bar.setAttribute("style", "width: 50%;");
			status_bar.innerHTML = "Editing";
			status_value.value = "1";
			break;
		case "processing":
			status_bar.setAttribute("class", "progress-bar bg-info");
			status_bar.setAttribute("style", "width: 75%;");
			status_bar.innerHTML = "Processing";
			status_value.value = "2";
			break;
		case "successful":
			status_bar.setAttribute("class", "progress-bar bg-success");
			status_bar.setAttribute("style", "width: 100%;");
			status_bar.innerHTML = "Successful";
			status_value.value = "3";
			break;
		case "failed":
			status_bar.setAttribute("class", "progress-bar bg-danger");
			status_bar.setAttribute("style", "width: 100%;");
			status_bar.innerHTML = "Failed";
			status_value.value = "4";
			break;
	}
}
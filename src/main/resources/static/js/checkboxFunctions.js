function checkedOrFalse() {
	var checkboxes = Array.from(document.getElementsByName("neighborhoods"));
	var salesman = $('.salesmanDiv').data('object')
	console.log(salesman)
	for (i = 0; i < checkboxes.length; i++) {
		if ((salesman.indexOf(checkboxes[i].value)) >= 0) {
			document.getElementById(checkboxes[i].id).checked = true;
			document.getElementById(checkboxes[i].id).disabled = false;
		}
	}
}

function validate() {
	console.log("oi")
	var i = 0, counter = 0, neighborhoods;
	neighborhoods = document.forms[0].neighborhoods;
	for (; i < neighborhoods.length; i++) {
		if (!neighborhoods[i].disabled) {
			if (neighborhoods[i].checked) {
				counter++;
			}
		}
	}
	if (counter == 0) {
		alert("Selecione pelo menos um bairro!")
		return false;
	}
	return true;
}
checkedOrFalse();
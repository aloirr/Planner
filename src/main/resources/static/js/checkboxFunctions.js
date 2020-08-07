var checkboxes = Array.from(document.getElementsByName("neighborhoods"));
var salesman = Array.from($('.salesmanDiv').data('object').split(","));
function checkedOrFalse() {
	for (i = 0; i < checkboxes.length; i++) {
		if ((salesman.indexOf(checkboxes[i].value)) >= 0) {
			document.getElementById(checkboxes[i].id).checked = true;
			document.getElementById(checkboxes[i].id).disabled = false;
		}
	}
}
checkedOrFalse();
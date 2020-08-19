let map


var mapModels = JSON.parse(document.getElementById("mapDiv").getAttribute("data-object"))
console.log(mapModels);

function initialize() {
	latlng = new google.maps.LatLng(2.819929, -60.672833)
	var options = {
		center: latlng,
		zoom: 15,
	}
	map = new google.maps.Map(document.getElementById("mapDiv"), options);
}
function loadCustomersMarks() {
	var jsonSize = (Object.keys(mapModels).length - 1);
	var myMap = new Map();
	let title = "";
	let latitude;
	let longitude
	for (var i = 0; i < jsonSize; i++) {
		var obj = jsonSize > 1 ? $.parseJSON(mapModels[i].attributes) : $.parseJSON(mapModels.attributes);
		for (var key in obj) {
			if (obj[key]['key'] == "latitude") {
				latitude = obj[key]['value'];
			}
			else if (obj[key]['key'] == "longitude") {
				longitude = obj[key]['value'];
			}
			title = title + " " + obj[key]['value'];
		}
		createMarker(latitude, longitude, title, map);
		map.center = new google.maps.LatLng(latitude, longitude);
		title = "";
//		document.addEventListener("dragend", changeMarker(map, marker));
	}
}
function createMarker(latitude, longitude, title, map) {
	var marker = new google.maps.Marker({
		position: new google.maps.LatLng(latitude, longitude),
		title: title,
		draggable: true,
		map: map
	});
}
// METODO PARA ESCUTAR EVENTOS NO GOOGLE MAPS
// google.maps.event.addDomListener(mapDiv, "click", () => {
//    window.alert("Map was clicked!");
//  });
initialize()
loadCustomersMarks()
let map
//var lat = parseFloat($('.mapa').attr('data-latitude'))
//var lng = parseFloat($('.mapa').attr('data-longitude'))

//const $customers = JSON.stringify($('.map').data('object'))
const $customers = JSON.parse(JSON.stringify($('.map').data('object')))
//const customers = JSON.parse($div.data('object'))
function initialize() {
	latlng = new google.maps.LatLng(2.819929, -60.672833)
	var options = {
		center: latlng,
		zoom: 15,
		//		mapTypeId: google.maps.MapTypeId.ROADMAP
	}
	map = new google.maps.Map(document.getElementById("mapDiv"), options);
}
function loadCustomersMarks() {
	$.each($customers, function(index, customer) {
		var marker = new google.maps.Marker({
			position: new google.maps.LatLng(customer.latitude, customer.longitude),
			title: customer.customerId + " - " + customer.tradeName + " - " + customer.place + " - " + customer.city,
			draggable: true,
			map: map
		});
		map.center = new google.maps.LatLng(customer.latitude, customer.longitude)
		document.addEventListener("dragend", changeMarker(map, marker))
	});
}

// METODO PARA ESCUTAR EVENTOS NO GOOGLE MAPS
// google.maps.event.addDomListener(mapDiv, "click", () => {
//    window.alert("Map was clicked!");
//  });
initialize()
loadCustomersMarks()

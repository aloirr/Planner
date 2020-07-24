let map;
var lat = parseFloat($('.mapa').attr('data-latitude'))
var lng = parseFloat($('.mapa').attr('data-longitude'))
function initialize() {
	latlng = new google.maps.LatLng(lat, lng)
	var options = {
		center: latlng,
		zoom: 18,
		//		mapTypeId: google.maps.MapTypeId.ROADMAP
	}
	map = new google.maps.Map(document.getElementById("map"), options);
}
function carregarPonto() {
	var marker = new google.maps.Marker({
		position: new google.maps.LatLng(lat, lng),
		title: "Marcador cliente",
		map: map
	});
}
function carregarPontos() {

	$.getJSON('js/pontos.json', function(pontos) {

		$.each(pontos, function(index, ponto) {

			var marker = new google.maps.Marker({
				position: new google.maps.LatLng(ponto.Latitude, ponto.Longitude),
				title: "Meu ponto personalizado! :-D",
				map: map
			});
		});
	});
}
function newPopup(page){
varWindow = window.open (page, 'popup')
}
console.log(parseFloat(lat))
console.log(parseFloat(lng))
initialize()
carregarPonto()
document.addEventListener('DOMContentLoaded', function () {
    if (document.querySelectorAll('#map').length > 0)
    {
        if (document.querySelector('html').lang)
            lang = document.querySelector('html').lang;
        else
            lang = 'en';

        var js_file = document.createElement('script');
        js_file.type = 'text/javascript';
        js_file.src = 'https://maps.googleapis.com/maps/api/js?&callback=initMap&signed_in=true&language=' + lang;
        document.getElementsByTagName('head')[0].appendChild(js_file);
    }
});
var app = (function(){
    var map;
    var coordenadas;

    var initMap = function() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });
        plotMarkers(coordenadas);
    }

    function plotMarkers(m) {
        markers = [];
        bounds = new google.maps.LatLngBounds();
        var position = new google.maps.LatLng(marker.lat, marker.lng);
        m.forEach(function (marker) {
        console.log("-------------------------------");
        console.log(position);
        markers.push(
            new google.maps.Marker({
                position: position,
                map: map,
                animation: google.maps.Animation.DROP
            })
        );
        });

        map.fitBounds(bounds);
    }

    var buildTable = function(virus) {
        console.log(virus.data.covid19Stats);
        let table = $("#id_table > tbody");
        table.empty();

        virusByCountry = virus.data.covid19Stats.map(({province,deaths,confirmed,recovered}) =>({
            province: province,
            deaths:deaths,
            confirmed:confirmed,
            recovered:recovered,
        }))
        virusByCountry.forEach(({province,deaths,confirmed,recovered}) => {
            table.append(
                `<tr>
                      <th>${province}</th>
                      <th>${deaths}</th>
                      <th>${confirmed}</th>
                      <th>${recovered}</th>
                </tr>`
            );
        })
    }

    var ubicaciones = function(propiedades) {
        var json2 = JSON.stringify(propiedades); //posible
        var json = propiedades[0];
        coordenadas = [];
        var coordenadasJson = {lat:json.latlng[0], lng:json.latlng[1]};
        coordenadas.push(coordenadasJson);
        console.log(coordenadas);
        initMap();
    }

    return {
        getCountry: function(name) {
            apiclient.getCountry(name,buildTable);
        },
        getUbicaciones: function(name) {
            apiclient.getUbicaciones(name,ubicaciones)
            app.getCountry(name);
        },
        initMap:initMap
    }
})();
var apiclient = (function(){
    return {
        getCountry : function(country, callback) {
            var promise = $.getJSON({
                url: "/countries" + "/" + country
            });
            promise
                .then(response => callback(response))
                .catch(err => console.log(err));
        },
        getUbicaciones : function(country, callback) {
            var promise = $.getJSON({
                url: "/countries" + "/" + country + "/" + country
            });
            promise
                .then(response => callback(response))
                .catch(err => console.log(err));
        }
    }
})();
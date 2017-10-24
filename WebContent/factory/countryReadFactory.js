app.factory("countryReadFactory", function($http, $q){
    
    console.log("Async call 2");
    
    var object = {
        
       updateCountry: function (Country) {

            var pr = $q.defer();
            $http({

                url: location.origin+"/finessy/countryCtrl",
                method: "post",
                params: {
                    method: "update",
                    dto_obj: Country
                }
            }).then(function (data) {
                pr.resolve(data);
            }, function (er) {
                pr.reject(er);
            });
            return pr.promise;
        },

        readCountry: function (Country) {

            var pr = $q.defer();
            $http({

                url: location.origin+"/finessy/countryCtrl",
                method: "post",
                params: {
                    method: "read",
                    dto_obj: Country
                }
            }).then(function (data) {
                pr.resolve(data);
            }, function (er) {
                pr.reject(er);
            });
            return pr.promise;
        },

        getCountryList: function(){
            var pr = $q.defer();
            $http({
                
                url: location.origin+"/finessy/countryCtrl",
                method: "post",
                params: {
                    method: "readAll"
                    
                }
            }).then(function(data){
            	console.log(data);
                pr.resolve("DATA:", data);
            }, function(er){
            	console.log("error", er);
                pr.reject(er);
            });
            return pr.promise;
        }
        
    };
    console.log("factory exit");
    return object;
});
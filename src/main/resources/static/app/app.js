var app = angular.module('leilaoApp',['ngAlertify', 'ngRoute']);

var SERVER_APP = "/leilao";

app.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {	
	
	
	/* ******************** Interceptor ******************** */
	$httpProvider.responseInterceptors.push('HttpInterceptor');

    /* ******************** Loading Gif ******************** */
    var spinnerFunction = function (data) {
            $('#spinner').show();
            return data; 
    };      
    
    $httpProvider.defaults.transformRequest.push(spinnerFunction); 	

}]); 

app.run(['$rootScope', function($rootScope) {
    $rootScope.SERVER_APP = SERVER_APP;
}]);

app.factory('HttpInterceptor',['$q', '$window', '$rootScope', function($q, $window, $rootScope) {
	/********************************************************************************************
     * Tratamento do retorno do response(ajax)...
	 ********************************************************************************************/
	
	var _isSessionInvalid = function(responseText) {
		return responseText != null && responseText.indexOf("Sessão Encerrada") > -1;
	};       	

	return function (promise) { 
    return promise.then(function (resp) {
        if(_isSessionInvalid(JSON.stringify(resp.data))) {
            $window.location.href = SERVER_APP;
        }    	
        $('#spinner').hide();  
        return resp;

    }, function (errorResp) {
        $('#spinner').hide();
    	console.log(errorResp);    	 
		if (errorResp.status == 404) {
			$window.location.href = SERVER_APP + "/#/404";
		}else if (errorResp.status != 501) {
			$rootScope.errorMessage = errorResp.data;
			return $q.reject(errorResp);
		}
		return errorResp;
    });
};
   
}]);
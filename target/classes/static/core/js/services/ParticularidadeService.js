app.factory('ParticularidadeService', ['$http', function($http) {
		
	var _findNaoVinculadas = function(solCarga){
		return $http.post( "/mesa/particularidade/find/nao/vinculadas", solCarga);
	};
	
	return {
		findNaoVinculadas : _findNaoVinculadas
	};
	
}]);
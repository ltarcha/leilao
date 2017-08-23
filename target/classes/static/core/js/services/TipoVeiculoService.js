app.factory('TipoVeiculoService', ['$http', function($http) {
		
	var _findAll = function(){
		return $http.post( "/mesa/tipo/veiculo/find/all");
	};
	
	return {
		findAll : _findAll
	};
	
}]);
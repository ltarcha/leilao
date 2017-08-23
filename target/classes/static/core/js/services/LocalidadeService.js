app.factory('LocalidadeService', ['$http', function($http) {
		
	var _findNaoVinculadasOrigem = function(localidades, descricao){
		return $http.post( "/mesa/localidade/find/origem/nao/vinculadas?descricao=" + descricao, localidades);
	};
	
	var _findNaoVinculadasDestino = function(localidades, descricao){
		return $http.post( "/mesa/localidade/find/destino/nao/vinculadas?descricao=" + descricao, localidades);
	};	
	
	return {
		findNaoVinculadasOrigem : _findNaoVinculadasOrigem,
		findNaoVinculadasDestino : _findNaoVinculadasDestino
	};
	
}]);
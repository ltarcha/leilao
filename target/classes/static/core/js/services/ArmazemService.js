app.factory('ArmazemService', ['$http', function($http) {
		
	var _findAll = function(armazem){
		return $http.post( "/mesa/armazem/find/all", armazem);
	};
	
	var _findByRotaUsuarioLogado = function(armazem){
		return $http.post( "/mesa/armazem/find/by/rota", armazem);
	};	
	
	return {
		findAll : _findAll,
		findByRotaUsuarioLogado :  _findByRotaUsuarioLogado
	};
	
}]);
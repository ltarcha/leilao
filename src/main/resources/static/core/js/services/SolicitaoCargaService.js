app.factory('SolicitaoCargaService', ['$http', function($http) {
		
	var _findOne = function(solcarga){
		return $http.post( "/mesa/solicitacao/carga/find/one", solcarga );
	};
	
	var _findByArmazem = function(armazem){
		return $http.post( "/mesa/solicitacao/carga/find/by/armazem", armazem );
	};
	
	var _save = function(solCarga){
		return $http.post( "/mesa/solicitacao/carga/save", solCarga );
	};
	
	var _cancelar = function(solCarga){
		return $http.post( "/mesa/solicitacao/carga/cancelar", solCarga );
	};	
	
	return {
		findOne	: _findOne,
		findByArmazem : _findByArmazem,
		save : _save,
		cancelar : _cancelar
	};
	
}]);
app.factory('ProdutoCadastroService', ['$http', function($http) {
		
//	var _findOne = function(solcarga){
//		return $http.post( "/mesa/solicitacao/carga/find/one", solcarga );
//	};
	var _save = function(produto){
		return $http.post( "/leilao/produto/save", produto );
	};
	
	return {
		save : _save
	};
	
}]);
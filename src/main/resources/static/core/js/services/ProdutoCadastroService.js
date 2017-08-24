app.factory('ProdutoCadastroService', ['$http', function($http) {
		

	var _save = function(produto){
		return $http.post( "/leilao/produto/save", produto );
	};
	
	return {
		save : _save
	};
	
}]);
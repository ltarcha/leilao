app.factory('ProdutoConsultaService', ['$http', function($http) {
		

	var _search = function(produto){
		return $http.post( "/leilao/produto/consulta/" + produto.id);
	};
	
	var _findAll = function(produto){
		return $http.post( "/leilao/produto/consulta/all");
	};
	
	var _deleteProduto = function(item){
		return $http.post( "/leilao/produto/delete", item);
	};
	
	return {
		save : _search,
		findAll : _findAll,
		deleteProduto : _deleteProduto
	};
	
}]);
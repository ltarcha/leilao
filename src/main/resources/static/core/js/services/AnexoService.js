app.factory('AnexoService', ['$http', function($http) {
		

	var _search = function(id){
		return $http.post("/leilao/anexo/find/" + id);
	};
	
	return {
		search : _search
	};
	
}]);
app.factory('UsuarioCadastroService', ['$http', function($http) {
		

	var _save = function(usuario){
		return $http.post( "/leilao/usuario/login/insert", usuario );
	};
	
	return {
		save : _save
	};
	
}]);
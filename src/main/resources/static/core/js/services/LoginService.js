app.factory('LoginService', ['$http', function($http) {
		

	var _login = function(usuario){
		var url = "/leilao/usuario/login/set/" + usuario.login + "/" + usuario.senha
		return $http.post( url );
	};
	
	return {
		login : _login
	};
	
}]);
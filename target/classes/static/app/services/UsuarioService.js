app.factory('UsuarioService', ['$http', function($http){
	
	var _getUsuarioSessao = function(conjunto){
		return $http.get(SERVER_APP + '/usuario/login/getusuariosessao');
	}
	
	var _logout = function() {
		return $http.get(SERVER_APP + '/usuario/login/logout');
	}
	
	return {
		
		getUsuarioSessao: _getUsuarioSessao,
		
		logout: _logout
		
	}
}])
app.controller('UsuarioController', ['$http','$scope', 'alertify','UsuarioService',
                                               function($http, $scope, alertify, UsuarioService){
	
	var self = this;

	self.isLogged = false;

	self._init = function(){
		UsuarioService.getUsuarioSessao()
		.then(function(resp){
			self.usuarioLogado = resp.data;
			self.isLogged = resp.data != null && resp.data != undefined && resp.data != {};
		}, function(error){
			alertify.log(error.data.error);
		});
	}
	
	// encerra sessao
	self.logout = function(){
		window.location.href = SERVER_APP + '/usuario/login/logout';
	}
	
	self._init();
}]);
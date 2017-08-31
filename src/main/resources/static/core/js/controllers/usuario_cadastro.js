app.controller('UsuarioCadastroController', ['UsuarioCadastroService', '$http','$filter', '$location', '$window', '$scope',
                                     function(UsuarioCadastroService, $http, $filter, $location, $window, $scope){
	
	
	var self = this;

	self.save = function() {
		UsuarioCadastroService.save(self.usuario).then(function(resp){
			self.usuario = resp.data;
			alertify.success('Cadastrado com sucesso!');
		}, function(error) {
			alertify.error(JSON.stringify(error.data));
		});
	};
}]);
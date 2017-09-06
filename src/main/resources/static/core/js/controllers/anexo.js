app.controller('AnexoController', ['AnexoService', '$http','$filter', '$location', '$window', '$scope',
                                     function(AnexoService, $http, $filter, $location, $window, $scope){
	
	
	var self = this;
	self.produto = {};
	
	self.init = function() {
		AnexoService.search(self.produto.id).then(function(resp){
			console.log(resp.data);
			self.listAnexos = resp.data;
		}, function(error) {
			alertify.error(JSON.stringify(error.data));
		});
	};
	
	self.teste = function() {
		console.log(self.produto);
	};
	
	
}]);
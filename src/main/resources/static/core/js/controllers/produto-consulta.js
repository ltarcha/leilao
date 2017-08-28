app.controller('ProdutoConsultaController', ['ProdutoConsultaService', '$http','$filter', '$location', '$window', '$scope',
                                     function(ProdutoConsultaService, $http, $filter, $location, $window, $scope){
	
	
	var self = this;
	self.listProdutos = {};
	
	self.init = function() {
		ProdutoConsultaService.findAll().then(function(resp){
			self.listProdutos = resp.data;
		}, function(error) {
			alertify.error(JSON.stringify(error.data));
		});
	};
	
	self.deleteProduto = function(item) {
		ProdutoConsultaService.deleteProduto(item).then(function(resp){
			alertify.success('Deletado com sucesso!');
		}, function(error) {
			alertify.error(JSON.stringify(error.data));
		});
	};
	
	self.init();
	
}]);
app.controller('LoginController', ['LoginService', '$http','$filter', '$location', '$window', '$scope',
                                     function(LoginService, $http, $filter, $location, $window, $scope){
	
	
	var self = this;
	
	self.login = function() {
		LoginService.login(self.usuario).then(function(resp){
			$scope.usuario = resp.data;
			window.location = "/leilao"
		}, function(error) {
			alertify.error(JSON.stringify(error.data));
		});
	};
	
}]);
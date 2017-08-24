app.controller('ProdutoCadastroController', ['ProdutoCadastroService', '$http','$filter', '$location', '$window', '$scope',
                                     function(ProdutoCadastroService, $http, $filter, $location, $window, $scope){
	
	
	var self = this;

	self.save = function() {
		ProdutoCadastroService.save(self.produto).then(function(resp){
			self.produto = resp.data;
			alertify.success('Cadastrado com sucesso!');
		}, function(error) {
			alertify.error(JSON.stringify(error.data));
		});
	};
	
//	self.view_tab = 'tabConsulta';
//	
//	self.init = function() {
//		self.disabledFields = true;
//		
//		ArmazemService.findByRotaUsuarioLogado().then(function(resp) {
//			self.ArmazemConsulta = resp.data;
//		}, function(error) {
//			alertify.error(JSON.stringify(error.data));
//		});
//		
//		TipoVeiculoService.findAll().then(function(resp) {
//			self.listaTipoVeiculo = resp.data;
//		}, function(error) {
//			alertify.error(JSON.stringify(error.data));
//		});		
//	};
//	
//	self.novo = function() {
//		self.solcarga = {};
//		self.solcarga.solicitacaoOrigem = [];
//		self.solcarga.solicitacaoDestino = [];
//		self.solcarga.particularidades = [];
//		self.disabledFields = false;
//		
//		ParticularidadeService.findNaoVinculadas(self.solcarga).then(function(resp){
//			self.listParticularidadesNaoVinculada = resp.data;
//		}, function(error) {
//			alertify.error(JSON.stringify(error.data));
//		});	
//	}; 
//	
//	self.edit = function(item) {
//		self.solcarga = item;
//		self.changeTab('tabCadastro');
//		self.disabledFields = false;
//		
//		ParticularidadeService.findNaoVinculadas(self.solcarga).then(function(resp){
//			self.listParticularidadesNaoVinculada = resp.data;
//		}, function(error) {
//			alertify.error(JSON.stringify(error.data));
//		});	
//	};
//	
//	self.buscaSolicitacaoCarga = function(armazem) {
//		SolicitaoCargaService.findByArmazem(armazem).then(function(resp){
//			self.listaSolicitacaoCarga = resp.data;
//		}, function(error) {
//			alertify.error(JSON.stringify(error.data));
//		});
//	};
//	
//	self.buscaOrigemNaoVinculados = function(descricao) {
//		if(descricao.length >= 3){
//			LocalidadeService.findNaoVinculadasOrigem(self.solcarga.solicitacaoOrigem, descricao).then(function(resp){
//				self.listLocalidadesNaoVinculadaOrigem = resp.data;
//			}, function(error) {
//				alertify.error(JSON.stringify(error.data));
//			});
//		}else{
//			self.listLocalidadesNaoVinculadaOrigem = [];
//		}
//	};
//	
//	self.buscaDestinoNaoVinculados = function(descricao) {
//		if(descricao.length >= 3){
//			LocalidadeService.findNaoVinculadasDestino(self.solcarga.solicitacaoDestino, descricao).then(function(resp){
//				self.listLocalidadesNaoVinculadaDestino = resp.data;
//			}, function(error) {
//				alertify.error(JSON.stringify(error.data));
//			});
//		}else{
//			self.listLocalidadesNaoVinculadaDestino = [];
//		}
//	};	
//	
//	self.pesquisaSolicitacaoCarga = function(){
//		SolicitaoCargaService.findOne(self.solcarga).then(function(resp){
//			self.solcarga = resp.data;
//		
//			ParticularidadeService.findNaoVinculadas(self.solcarga).then(function(resp){
//				self.listParticularidadesNaoVinculada = resp.data;
//			}, function(error) {
//				alertify.error(JSON.stringify(error.data));
//			});			
//		}, function(error) {
//			alertify.error(JSON.stringify(error.data));
//		});	
//	};
//	
//	
//	self.cancelar = function(codigo) {
//		SolicitaoCargaService.cancelar(self.solcarga).then(function(resp){
//			self.solcarga = resp.data;
//			alertify.log('Cancelado com sucesso!');
//		}, function(error) {
//			alertify.error(JSON.stringify(error.data));
//		});		
//	}
//	
//	/*ADD AND REMOVE PARTICULARIDADES/ORIGEM/DESTINO*/
//	self.addParticularidade= function() {
//		var countSelected = 0;
//		for(var i = 0; i <= self.listParticularidadesNaoVinculada.length-1; i++) {
//			if(self.listParticularidadesNaoVinculada[i].selecionado) countSelected++;
//		};
//		
//		if(countSelected == 0){
//			alertify.error('Escolha pelo menos uma Particularidade não vinculada');
//		};
//		
//		for(var i = 0; i <= self.listParticularidadesNaoVinculada.length-1; i++) {
//			if(self.listParticularidadesNaoVinculada[i].selecionado) {
//				var particularidades = {};
//				particularidades.particularidade = {};
//				particularidades.solicitacaoCarga = self.solcarga.codigo;
//				particularidades.particularidade.codigo = self.listParticularidadesNaoVinculada[i].codigo;
//				particularidades.particularidade.descricao = self.listParticularidadesNaoVinculada[i].descricao;
//				self.solcarga.particularidades.push(particularidades);
//				self.listParticularidadesNaoVinculada.splice(i, 1);
//				i--;
//			}
//		};
//	};
//	
//	self.removeParticularidade= function() {
//		var countSelected = 0;
//		for(var i = 0; i <= self.solcarga.particularidades.length-1; i++) {
//			if(self.solcarga.particularidades[i].selecionado) countSelected++;
//		};
//		
//		if(countSelected == 0){
//			alert('Escolha pelo menos uma Particularidade vinculada');
//		};
//		
//		for(var i = 0; i <= self.solcarga.particularidades.length-1; i++) {
//			if(self.solcarga.particularidades[i].selecionado) {
//				var particularidade = {};
//				particularidade.codigo = self.solcarga.particularidades[i].particularidade.codigo;
//				particularidade.descricao = self.solcarga.particularidades[i].particularidade.descricao;
//				self.listParticularidadesNaoVinculada.push(particularidade);
//				self.solcarga.particularidades.splice(i, 1);
//				i--;
//			}
//		};
//	};
//	
//	self.addOrigem= function() {
//		var countSelected = 0;
//		for(var i = 0; i <= self.listLocalidadesNaoVinculadaOrigem.length-1; i++) {
//			if(self.listLocalidadesNaoVinculadaOrigem[i].selecionado) countSelected++;
//		};
//		
//		if(countSelected == 0){
//			alertify.error('Escolha pelo menos uma rota para ser liberada');
//		};
//		
//		for(var i = 0; i <= self.listLocalidadesNaoVinculadaOrigem.length-1; i++) {
//			if(self.listLocalidadesNaoVinculadaOrigem[i].selecionado) {
//				var solicitacaoOrigem = {};
//			    solicitacaoOrigem.localidade = {};
//			    solicitacaoOrigem.solicitacao = self.solcarga.codigo;
//				solicitacaoOrigem.localidade.codigo = self.listLocalidadesNaoVinculadaOrigem[i].codigo;
//				solicitacaoOrigem.localidade.descricao = self.listLocalidadesNaoVinculadaOrigem[i].descricao;
//				self.solcarga.solicitacaoOrigem.push(solicitacaoOrigem);
//				self.listLocalidadesNaoVinculadaOrigem.splice(i, 1);
//				i--;
//			}
//		};
//	};
//	
//	self.removeOrigem= function() {
//		var countSelected = 0;
//		for(var i = 0; i <= self.solcarga.solicitacaoOrigem.length-1; i++) {
//			if(self.solcarga.solicitacaoOrigem[i].selecionado) countSelected++;
//		};
//		
//		if(countSelected == 0){
//			alertify.error('Escolha pelo menos uma rota para ser liberada');
//		};
//		
//		for(var i = 0; i <= self.solcarga.solicitacaoOrigem.length-1; i++) {
//			if(self.solcarga.solicitacaoOrigem[i].selecionado) {
//				var localidadeNaoVinculada = {};
//				localidadeNaoVinculada.codigo = self.solcarga.solicitacaoOrigem[i].localidade.codigo;
//				localidadeNaoVinculada.descricao = self.solcarga.solicitacaoOrigem[i].localidade.descricao;
//				self.listLocalidadesNaoVinculadaOrigem.push(localidadeNaoVinculada);
//				self.solcarga.solicitacaoOrigem.splice(i, 1);
//				i--;
//			}
//		};
//	};	
//	
//	self.addDestino= function() {
//		var countSelected = 0;
//		for(var i = 0; i <= self.listLocalidadesNaoVinculadaDestino.length-1; i++) {
//			if(self.listLocalidadesNaoVinculadaDestino[i].selecionado) countSelected++;
//		};
//		
//		if(countSelected == 0){
//			alertify.error('Escolha pelo menos uma rota para ser liberada');
//		};
//		
//		for(var i = 0; i <= self.listLocalidadesNaoVinculadaDestino.length-1; i++) {
//			if(self.listLocalidadesNaoVinculadaDestino[i].selecionado) {
//				var solicitacaoDestino = {};
//			    solicitacaoDestino.localidade = {};
//			    solicitacaoDestino.solicitacao = self.solcarga.codigo;
//				solicitacaoDestino.localidade.codigo = self.listLocalidadesNaoVinculadaDestino[i].codigo;
//				solicitacaoDestino.localidade.descricao = self.listLocalidadesNaoVinculadaDestino[i].descricao;
//				self.solcarga.solicitacaoDestino.push(solicitacaoDestino);
//				self.listLocalidadesNaoVinculadaDestino.splice(i, 1);
//				i--;
//			}
//		};
//	};
//	
//	self.removeDestino= function() {
//		var countSelected = 0;
//		for(var i = 0; i <= self.solcarga.solicitacaoDestino.length-1; i++) {
//			if(self.solcarga.solicitacaoDestino[i].selecionado) countSelected++;
//		};
//		
//		if(countSelected == 0){
//			alertify.error('Escolha pelo menos uma rota para ser liberada');
//		};
//		
//		for(var i = 0; i <= self.solcarga.solicitacaoDestino.length-1; i++) {
//			if(self.solcarga.solicitacaoDestino[i].selecionado) {
//				var localidadeNaoVinculada = {};
//				localidadeNaoVinculada.codigo = self.solcarga.solicitacaoDestino[i].localidade.codigo;
//				localidadeNaoVinculada.descricao = self.solcarga.solicitacaoDestino[i].localidade.descricao;
//				self.listLocalidadesNaoVinculadaDestino.push(localidadeNaoVinculada);
//				self.solcarga.solicitacaoDestino.splice(i, 1);
//				i--;
//			}
//		};
//	};		
//	
//	/*ALTERAR NAV-TAB*/
//	self.changeTab = function(tab) {
//	    self.view_tab = tab;
//	};
//	
//	/*FILTROS CONSULTA*/
//	self.filterSolicitados = function(buscaSolicitados) {
//		return function(item) {
//			if(buscaSolicitados){
//				if((item.dtCancelamento == '' || item.dtCancelamento == undefined) && (item.valorFrete == '' || item.valorFrete == undefined) && (item.veiculoDisp == '' || item.veiculoDisp == undefined)){
//					return item;
//				}			
//			}else{
//				return item;
//			}
//		};
//	};
//	
//	self.filterCancelados = function(buscaCancelados) {
//		return function(item) {
//			if(buscaCancelados){
//				if(item.dtCancelamento != null && item.dtCancelamento != undefined){
//					return item;
//				}			
//			}else{
//				return item;
//			}
//		};
//	};
//	
//	self.filterFretes = function(buscaFretes) {
//		return function(item) {
//			if(buscaFretes){
//				if(item.valorFrete != null && item.valorFrete != undefined){
//					return item;
//				}			
//			}else{
//				return item;
//			}
//		};
//	};
//	
//	self.filterContratados = function(buscaContratados) {
//		return function(item) {
//			if(buscaContratados){
//				if(item.veiculoDisp != null && item.veiculoDisp != undefined){
//					return item;
//				}			
//			}else{
//				return item;
//			}
//		};
//	};
//	
//	self.init();
//	
}]);
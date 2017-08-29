package br.com.tcc.leilao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcc.leilao.models.Produto;
import br.com.tcc.leilao.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
		return this.produtoRepository.save(produto);
	}
}

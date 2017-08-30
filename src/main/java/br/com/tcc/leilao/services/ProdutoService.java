package br.com.tcc.leilao.services;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcc.leilao.models.Produto;
import br.com.tcc.leilao.models.Usuario;
import br.com.tcc.leilao.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private NextSequenceService nextSequenceService;
	
	public Produto save(Produto produto, HttpSession session) {
		if(produto.getId() == null || produto.getId().equals(0L)) {
			produto.setId(nextSequenceService.getNextSequence("Sq_id_Produto"));
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			produto.setIdProprietario(usuario.getId());
			Calendar dataCadastro = Calendar.getInstance();
			produto.setDataCadastro(dataCadastro);
		}
		return this.produtoRepository.save(produto);
	}
	
	public List<Produto> buscaPorUsuario(HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		return produtoRepository.findByIdProprietario(usuario.getId());
	}
	
	public void delete(Produto produto) {
		this.produtoRepository.delete(produto);
	}
}

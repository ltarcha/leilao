package br.com.tcc.leilao.services;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.tcc.leilao.models.Anexo;
import br.com.tcc.leilao.repositories.AnexoRepository;
import br.com.tcc.leilao.util.TransferenciaArquivos;

@Service
public class AnexoService {

	@Autowired
	private AnexoRepository anexoRepository;
	
	@Autowired
	private String storage;
	
	@Autowired
	private NextSequenceService nextSequenceService;
	
	public List<Anexo> findByIdProduto(Long idProduto){
		return anexoRepository.findByIdProduto(idProduto);
	}

	public void save(Long produto_id, MultipartFile file) {
		TransferenciaArquivos tranf = new TransferenciaArquivos();
		Anexo anexo = new Anexo();
		String link = tranf.upload(file, produto_id, storage);
		anexo.setIdProduto(produto_id);
		anexo.setPath(File.separator + "leilao" + File.separator + link);
		anexo.setId(nextSequenceService.getNextSequence("Sq_id_Anexo"));
		anexoRepository.save(anexo);
	}
}

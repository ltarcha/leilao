package br.com.tcc.leilao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.leilao.models.Anexo;
import java.lang.Long;
import java.util.List;

@Repository
public interface AnexoRepository extends MongoRepository<Anexo, Long>{

	List<Anexo> findByIdProduto(Long idproduto);
	
}

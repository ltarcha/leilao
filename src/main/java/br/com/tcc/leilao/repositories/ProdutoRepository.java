package br.com.tcc.leilao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.leilao.models.Produto;
import java.lang.Long;
import java.util.List;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Long> {

	List<Produto> findByIdProprietario(Long idproprietario);
}

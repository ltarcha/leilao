package br.com.tcc.leilao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.leilao.models.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Long> {

}

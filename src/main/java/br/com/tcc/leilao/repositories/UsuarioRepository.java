package br.com.tcc.leilao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.leilao.models.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long>{

	Usuario findByLogin(String login);
	
	Usuario findByLoginAndSenha(String login, String senha);
	
}

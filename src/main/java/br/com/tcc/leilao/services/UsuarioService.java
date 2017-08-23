package br.com.tcc.leilao.services;

import org.springframework.stereotype.Service;

import br.com.tcc.leilao.models.Usuario;

@Service
public class UsuarioService {

	public Usuario getUsuario(String login, String senha) {
		try{
			//TODO: DESCOMENTAR QUANDO FIZER O BANCO DE DADOS
			//return this.usuarioRepository.findByLoginSenha(login, senha);
			Usuario usuario = new Usuario();
			usuario.setId(1L);
			usuario.setLogin("ltarcha");
			usuario.setNome("Lucas Tarcha Marchetto");
			return usuario;
		} catch (RuntimeException e) {
			e.printStackTrace();			
			throw new RuntimeException(e.getMessage());
		}
	}

}

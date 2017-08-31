package br.com.tcc.leilao.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcc.leilao.models.Usuario;
import br.com.tcc.leilao.repositories.UsuarioRepository;
import br.com.tcc.leilao.util.Crypto;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private NextSequenceService nextSequenceService;

	public Usuario getUsuario(String login, String senha) {
		Crypto crypto = new Crypto();
		try{
			senha = crypto.encrypt(senha);
			Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senha);
			
			if(usuario == null) {
				throw new RuntimeException("Usuario/Senha Incorretos");
			}
			
			return usuarioRepository.findByLoginAndSenha(login, senha);
		} catch (Exception e) {
			e.printStackTrace();			
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Usuario save(Usuario usuario) {
		Crypto crypto = new Crypto();
		try {
			this.validaUsuario(usuario);

			if(usuario.getId() == null || usuario.getId().equals(0L)) {
				usuario.setId(nextSequenceService.getNextSequence("Sq_id_usuario"));
				usuario.setSenha(crypto.encrypt(usuario.getSenha()));
			}
			return usuarioRepository.save(usuario);
		}catch (Exception e) {
			e.printStackTrace();			
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	public void validaUsuario(Usuario usuario) {
		
		if(this.existLogin(usuario))
			throw new RuntimeException("Login já está em uso");
		
		if(!this.isEmailIdValid(usuario.getEmail()))
			throw new RuntimeException("Email Não valido");
			
	}
	
	public boolean existLogin(Usuario usuario) {
		
		Usuario usuarioBusca = usuarioRepository.findByLogin(usuario.getLogin());
		
		if(usuarioBusca != null) {
			return true;
		}
		
		return false;
	}
	
	public boolean isEmailIdValid(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }	
	
}

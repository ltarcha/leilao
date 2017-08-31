package br.com.tcc.leilao.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tcc.leilao.models.Usuario;
import br.com.tcc.leilao.services.UsuarioService;

@Controller
@RequestMapping("/usuario/login")
public class LoginController {
	
	@Autowired 
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "login");
		return mv;
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "usuario_cadastro");
		return mv;
	}
	
	@RequestMapping( value="/insert", method=RequestMethod.POST, consumes="application/json", produces="application/json; charset=utf-8" )
	public @ResponseBody ResponseEntity<String> insert(@RequestBody Usuario usuario, HttpSession session){
		try {
			Usuario save = usuarioService.save(usuario);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(save), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * @param usuario
	 * @throws SQLException
	 * 
//	 */
	@RequestMapping(value = "/set/{usuario}/{senha}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> login(@PathVariable String usuario, @PathVariable String senha, HttpSession session, HttpServletRequest request){
		try {
			Usuario usuarioLogado = usuarioService.getUsuario(usuario, senha);
			session.setAttribute("usuarioLogado", usuarioLogado);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	/**
	 * 
	 * Destroy Session
	 * @param session
	 * @param model 
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session, Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "core/logout");
		session.invalidate();
		return mv;
	}	
	
	
}

package br.com.tcc.leilao.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	/**
	 * 
	 * @param usuario
	 * @throws SQLException
	 * 
//	 */
	@RequestMapping(value = "/set/{usuario}/{senha}", method = RequestMethod.POST)
	public String login(@PathVariable String usuario, @PathVariable String senha, HttpSession session, HttpServletRequest request){
		Usuario usuarioLogado = usuarioService.getUsuario(usuario, senha);
		session.setAttribute("usuarioLogado", usuarioLogado);
		return "redirect:/";
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

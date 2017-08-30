package br.com.tcc.leilao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LeilaoController {

	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "leilao");
		return mv;
	}

}

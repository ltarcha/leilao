package br.com.tcc.leilao.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tcc.leilao.models.Produto;

@Controller
@RequestMapping(value="/produto")
public class ProdutoController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "produto");
		return mv;
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "produto_cadastro");
		return mv;
	}
	
	@RequestMapping( value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json; charset=utf-8" )
	public @ResponseBody ResponseEntity<String> insert(@RequestBody Produto produto, HttpSession session){
		try {
			Produto save = new Produto();
			save = produto;
			save.setId(1L);
			
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(save), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}	
	
}

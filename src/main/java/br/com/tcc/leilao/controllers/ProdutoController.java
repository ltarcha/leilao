package br.com.tcc.leilao.controllers;


import java.util.Arrays;
import java.util.List;

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

import br.com.tcc.leilao.models.Produto;
import br.com.tcc.leilao.services.ProdutoService;

@Controller
@RequestMapping(value="/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService; 

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
	
	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public ModelAndView consultar(Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "produto_consulta");
		return mv;
	}	
	
	
	@RequestMapping( value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json; charset=utf-8" )
	public @ResponseBody ResponseEntity<String> insert(@RequestBody Produto produto, HttpSession session){
		try {
			Produto save = produtoService.save(produto);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(save), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@RequestMapping( value="/consulta/{id}", method=RequestMethod.POST, produces="application/json; charset=utf-8" )
	public @ResponseBody ResponseEntity<String> findOne(@PathVariable String id, HttpSession session){
		try {
			Produto produto = new Produto();
			produto.setId(1L);
			
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(produto), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@RequestMapping( value="/consulta/all", method=RequestMethod.POST, produces="application/json; charset=utf-8" )
	public @ResponseBody ResponseEntity<String> findAll(HttpSession session){
		try {
			Produto produto = new Produto();
			produto.setId(1L);
			produto.setValorInicio(new Float("200.00"));
			produto.setDescricao("TESTE - DESCRICAO");
			List<Produto> list = Arrays.asList(produto, produto, produto); 
			
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@RequestMapping( value="/delete", method=RequestMethod.POST, consumes="application/json", produces="application/json; charset=utf-8" )
	public @ResponseBody ResponseEntity<String> delete(@RequestBody Produto produto, HttpSession session){
		try {
			//TODO: INPLEMENTAR QUANDO FOR IMPLEMENTADO BD
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}	
	
}

package br.com.tcc.leilao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tcc.leilao.models.Anexo;
import br.com.tcc.leilao.services.AnexoService;

@Controller
@RequestMapping(value="/anexo")
public class AnexoController {

	@Autowired
	private AnexoService anexoService;
	
	@RequestMapping( value="/{idProduto}", method=RequestMethod.GET)
	public ModelAndView home(@PathVariable("idProduto") Long idProduto){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "anexo");
		mv.addObject("produto_codigo", idProduto);
		return mv;
	}
	
	@RequestMapping( value="/find/{idProduto}", method=RequestMethod.POST, produces="application/json; charset=utf-8" )
	public @ResponseBody ResponseEntity<String> find(@PathVariable("idProduto") Long idProduto){
		try {
			List<Anexo> list = anexoService.findByIdProduto(idProduto);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping( value="/save", method=RequestMethod.POST)
	public  ModelAndView insert(Long produto_id, @RequestParam("file") MultipartFile file){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "anexo");
		mv.addObject("produto_codigo", produto_id);
		anexoService.save(produto_id, file);
		return mv;
	}
	
	
}

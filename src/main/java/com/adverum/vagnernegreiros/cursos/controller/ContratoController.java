package com.adverum.vagnernegreiros.cursos.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adverum.vagnernegreiros.cursos.model.Contrato;
import com.adverum.vagnernegreiros.cursos.repository.ContratoRepository;

@Controller
public class ContratoController {

	@Autowired
	private ContratoRepository contratoRepository;
	
	@RequestMapping(value = "/contrato/list-contrato" ,method = RequestMethod.GET)
	public ModelAndView list() {	
		ModelAndView model = new ModelAndView("contrato/list-contrato");
		
		// Create an empty list 
        List<Contrato> listContrato = new ArrayList<>(); 
  
        contratoRepository.findAll().forEach(listContrato::add);         
		
        model.addObject("listContrato", listContrato);
		
		return model;
	}
	
	@RequestMapping(value = "/contrato/create-contrato" ,method = RequestMethod.GET)
	public ModelAndView createContratoPage() {	
		ModelAndView model = new ModelAndView("contrato/create-contrato");
		
		Contrato contrato = new Contrato();
		   
        model.addObject("contrato", contrato);
		
		return model;
	}
	
	@PostMapping("/contrato/createContrato")
	public ModelAndView save(@Valid Contrato contrato, BindingResult result) {
		
		ModelAndView model = new ModelAndView("contrato/list-contrato");
		
		if(result.hasErrors()) {
			model.setViewName("contrato/create-contrato");			
	        model.addObject("showError", true);
	        model.addObject("error", "Preencha todos os campos corretamente");
			return model;
		}

		contratoRepository.save(contrato);
		
		// Create an empty list 
        List<Contrato> listContrato = new ArrayList<>(); 
  
        contratoRepository.findAll().forEach(listContrato::add);         
		
        model.addObject("listContrato", listContrato);
        model.addObject("showSuccess", true);
        model.addObject("message", "Contrato cadastrado com sucesso!");
        
		
		return model;
	}
	
	@RequestMapping(value = "/contrato/edit-contrato/{id}" ,method = RequestMethod.GET)
	public ModelAndView editContratoPage(@PathVariable("id") String id) {	
		ModelAndView model = new ModelAndView("contrato/edit-contrato");
		
		Long idContrato = Long.parseLong(id);		
		
		Contrato contrato = contratoRepository.findById(Long.parseLong(id)).get();
		   
        model.addObject("contrato", contrato);
		
		return model;
	}
	
	@PostMapping("/contrato/editContrato")
	public ModelAndView editContrato(@Valid Contrato contrato, BindingResult result) {
		
		ModelAndView model = new ModelAndView("contrato/list-contrato");
		
		if(result.hasErrors()) {
			model.setViewName("contrato/create-contrato");			
	        model.addObject("showError", true);
	        model.addObject("error", "Preencha todos os campos corretamente");
			return model;
		}
		contratoRepository.save(contrato);
		
		// Create an empty list 
        List<Contrato> listContrato = new ArrayList<>(); 
  
        contratoRepository.findAll().forEach(listContrato::add);         
		
        model.addObject("listContrato", listContrato);
        model.addObject("showSuccess", true);
        model.addObject("message", "Contrato atualizado com sucesso!");
        
		
		return model;
	}
	
	@RequestMapping(value = "/contrato/delete-contrato/{id}" ,method = RequestMethod.GET)
	public ModelAndView deleteContrato(@PathVariable("id") String id) {	
		
		ModelAndView model = new ModelAndView("contrato/list-contrato");
		
		Long idContrato = Long.parseLong(id);		
		
		Contrato contrato = contratoRepository.findById(Long.parseLong(id)).get();
	
		contratoRepository.delete(contrato);
		
		// Create an empty list 
        List<Contrato> listContrato = new ArrayList<>(); 
  
        contratoRepository.findAll().forEach(listContrato::add);         
		
        model.addObject("listContrato", listContrato);
        model.addObject("showSuccess", true);
        model.addObject("message", "Contrato removido com sucesso!");        
		
		return model;
	}
	
	
}

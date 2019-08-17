package com.adverum.vagnernegreiros.cursos.controller;

import java.util.ArrayList;
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

import com.adverum.vagnernegreiros.cursos.model.Aluno;
import com.adverum.vagnernegreiros.cursos.repository.AlunoRepository;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;

	@RequestMapping(value = "/aluno/list-aluno" ,method = RequestMethod.GET)
	public ModelAndView list() {	
		ModelAndView model = new ModelAndView("aluno/list-aluno");
		
		// Create an empty list 
        List<Aluno> listAluno = new ArrayList<>(); 
  
        alunoRepository.findAll().forEach(listAluno::add);         
		
        model.addObject("listAluno", listAluno);
		
		return model;
	}
	
	@RequestMapping(value = "/aluno/create-aluno" ,method = RequestMethod.GET)
	public ModelAndView createAlunoPage() {	
		ModelAndView model = new ModelAndView("aluno/create-aluno");
		
		Aluno aluno = new Aluno();
		   
        model.addObject("aluno", aluno);
		
		return model;
	}
	
	@PostMapping("/aluno/createAluno")
	public ModelAndView save(@Valid Aluno aluno, BindingResult result) {
		
		ModelAndView model = new ModelAndView("aluno/list-aluno");
		
		if(result.hasErrors()) {
			model.setViewName("aluno/create-aluno");			
	        model.addObject("showError", true);
	        model.addObject("error", "Preencha todos os campos corretamente");
			return model;
		}
		
		if(!alunoRepository.findByCPFOrEmail(aluno.getCpf(), aluno.getEmail()).isEmpty()) {
			model.setViewName("aluno/create-aluno");			
	        model.addObject("showError", true);
	        model.addObject("error", "Já existe um aluno com cpf ou email cadastrado");
			return model;
		};
		
		alunoRepository.save(aluno);
		
		// Create an empty list 
        List<Aluno> listAluno = new ArrayList<>(); 
  
        alunoRepository.findAll().forEach(listAluno::add);         
		
        model.addObject("listAluno", listAluno);
        model.addObject("showSuccess", true);
        model.addObject("message", "Aluno cadastrado com sucesso!");
        
		
		return model;
	}
	
	@RequestMapping(value = "/aluno/edit-aluno/{id}" ,method = RequestMethod.GET)
	public ModelAndView editAlunoPage(@PathVariable("id") String id) {	
		ModelAndView model = new ModelAndView("aluno/edit-aluno");
		
		Long idAluno = Long.parseLong(id);		
		
		Aluno aluno = alunoRepository.findById(Long.parseLong(id)).get();
		   
        model.addObject("aluno", aluno);
		
		return model;
	}
	
	@PostMapping("/aluno/editAluno")
	public ModelAndView editAluno(@Valid Aluno aluno, BindingResult result) {
		
		ModelAndView model = new ModelAndView("aluno/list-aluno");
		
		if(result.hasErrors()) {
			model.setViewName("aluno/create-aluno");			
	        model.addObject("showError", true);
	        model.addObject("error", "Preencha todos os campos corretamente");
			return model;
		}
		
		alunoRepository.save(aluno);
		
		// Create an empty list 
        List<Aluno> listAluno = new ArrayList<>(); 
  
        alunoRepository.findAll().forEach(listAluno::add);         
		
        model.addObject("listAluno", listAluno);
        model.addObject("showSuccess", true);
        model.addObject("message", "Aluno atualizado com sucesso!");
        
		
		return model;
	}
	
	@RequestMapping(value = "/aluno/delete-aluno/{id}" ,method = RequestMethod.GET)
	public ModelAndView deleteAluno(@PathVariable("id") String id) {	
		
		ModelAndView model = new ModelAndView("aluno/list-aluno");
		
		Long idAluno = Long.parseLong(id);		
		
		Aluno aluno = alunoRepository.findById(Long.parseLong(id)).get();
	
		alunoRepository.delete(aluno);
		
		// Create an empty list 
        List<Aluno> listAluno = new ArrayList<>(); 
  
        alunoRepository.findAll().forEach(listAluno::add);         
		
        model.addObject("listAluno", listAluno);
        model.addObject("showSuccess", true);
        model.addObject("message", "Aluno removido com sucesso!");        
		
		return model;
	}
	
}

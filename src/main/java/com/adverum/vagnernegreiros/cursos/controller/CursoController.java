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

import com.adverum.vagnernegreiros.cursos.model.Curso;
import com.adverum.vagnernegreiros.cursos.repository.CursoRepository;

@Controller
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@RequestMapping(value = "/curso/list-curso" ,method = RequestMethod.GET)
	public ModelAndView list() {	
		ModelAndView model = new ModelAndView("curso/list-curso");
		
		// Create an empty list 
        List<Curso> listCurso = new ArrayList<>(); 
  
        cursoRepository.findAll().forEach(listCurso::add);         
		
        model.addObject("listCurso", listCurso);
		
		return model;
	}
	
	@RequestMapping(value = "/curso/create-curso" ,method = RequestMethod.GET)
	public ModelAndView createCursoPage() {	
		ModelAndView model = new ModelAndView("curso/create-curso");
		
		Curso curso = new Curso();
		   
        model.addObject("curso", curso);
		
		return model;
	}
	
	@PostMapping("/curso/createCurso")
	public ModelAndView save(@Valid Curso curso, BindingResult result) {
		
		ModelAndView model = new ModelAndView("curso/list-curso");
		
		curso.setDataInclusao(new Date());
		curso.setDataAlteracao(new Date());
		
		if(result.hasErrors()) {
			model.setViewName("curso/create-curso");			
	        model.addObject("showError", true);
	        model.addObject("error", "Preencha todos os campos corretamente");
			return model;
		}

		cursoRepository.save(curso);
		
		// Create an empty list 
        List<Curso> listCurso = new ArrayList<>(); 
  
        cursoRepository.findAll().forEach(listCurso::add);         
		
        model.addObject("listCurso", listCurso);
        model.addObject("showSuccess", true);
        model.addObject("message", "Curso cadastrado com sucesso!");
        
		
		return model;
	}
	
	@RequestMapping(value = "/curso/edit-curso/{id}" ,method = RequestMethod.GET)
	public ModelAndView editCursoPage(@PathVariable("id") String id) {	
		ModelAndView model = new ModelAndView("curso/edit-curso");
		
		Long idCurso = Long.parseLong(id);		
		
		Curso curso = cursoRepository.findById(Long.parseLong(id)).get();
		   
        model.addObject("curso", curso);
		
		return model;
	}
	
	@PostMapping("/curso/editCurso")
	public ModelAndView editCurso(@Valid Curso curso, BindingResult result) {
		
		ModelAndView model = new ModelAndView("curso/list-curso");
		
		if(result.hasErrors()) {
			model.setViewName("curso/create-curso");			
	        model.addObject("showError", true);
	        model.addObject("error", "Preencha todos os campos corretamente");
			return model;
		}
		
		curso.setDataAlteracao(new Date());
		cursoRepository.save(curso);
		
		// Create an empty list 
        List<Curso> listCurso = new ArrayList<>(); 
  
        cursoRepository.findAll().forEach(listCurso::add);         
		
        model.addObject("listCurso", listCurso);
        model.addObject("showSuccess", true);
        model.addObject("message", "Curso atualizado com sucesso!");
        
		
		return model;
	}
	
	@RequestMapping(value = "/curso/delete-curso/{id}" ,method = RequestMethod.GET)
	public ModelAndView deleteCurso(@PathVariable("id") String id) {	
		
		ModelAndView model = new ModelAndView("curso/list-curso");
		
		Long idCurso = Long.parseLong(id);		
		
		Curso curso = cursoRepository.findById(Long.parseLong(id)).get();
	
		cursoRepository.delete(curso);
		
		// Create an empty list 
        List<Curso> listCurso = new ArrayList<>(); 
  
        cursoRepository.findAll().forEach(listCurso::add);         
		
        model.addObject("listCurso", listCurso);
        model.addObject("showSuccess", true);
        model.addObject("message", "Curso removido com sucesso!");        
		
		return model;
	}
	
	
}

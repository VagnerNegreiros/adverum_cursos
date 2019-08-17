package com.adverum.vagnernegreiros.cursos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContratoController {

	@RequestMapping(value = "/contrato/list-contrato" ,method = RequestMethod.GET)
	public ModelAndView list() {		
		ModelAndView model = new ModelAndView("contrato/list-contrato");
		
		return model;
	}
	
	
}

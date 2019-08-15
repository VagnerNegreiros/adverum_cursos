package com.adverum.vagnernegreiros.cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adverum.vagnernegreiros.cursos.repository.AlunoRepository;

@Controller
public class ContratoController {

	@RequestMapping(value = "/contrato/list-contrato" ,method = RequestMethod.GET)
	public String list() {		
		return "contrato/list-contrato";
	}
	
	
}

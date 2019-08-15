package com.adverum.vagnernegreiros.cursos.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adverum.vagnernegreiros.cursos.model.Aluno;
import com.adverum.vagnernegreiros.cursos.model.Contrato;
import com.adverum.vagnernegreiros.cursos.repository.AlunoRepository;

@Controller
public class IndexController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@RequestMapping(value = "/" ,method = RequestMethod.GET)
	public String index() {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Valter Negreiros");
		aluno.setEmail("email@email.com");
		aluno.setCpf("09799592410");
		aluno.setTelefone("81983196747");
		aluno.setContratos(Collections.emptySet());
		
		System.out.println("Printando Aluno");
		System.out.println(aluno.toString());
		
		alunoRepository.save(aluno);
		
		return "index";
	}
	

}

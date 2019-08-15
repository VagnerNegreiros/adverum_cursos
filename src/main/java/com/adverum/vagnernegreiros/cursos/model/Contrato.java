package com.adverum.vagnernegreiros.cursos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contrato")
public class Contrato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	Aluno aluno;
	
	@NotNull
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	Curso curso;
	
	@NotEmpty
	String codigoCompra;
	
	public Contrato(Aluno aluno, Curso curso, String codigoCompra) {
		super();
		this.aluno = aluno;
		this.curso = curso;
		this.codigoCompra = codigoCompra;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(String codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

}

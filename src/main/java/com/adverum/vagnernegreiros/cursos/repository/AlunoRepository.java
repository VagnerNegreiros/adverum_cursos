package com.adverum.vagnernegreiros.cursos.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adverum.vagnernegreiros.cursos.model.Aluno;

@Repository
@Transactional
public interface AlunoRepository extends CrudRepository<Aluno, Long>{
	
	@Query("SELECT a FROM Aluno a WHERE a.cpf=:cpf or a.email=:email")
    List<Aluno> findByCPFOrEmail(@Param("cpf") String cpf,@Param("email") String email);

}


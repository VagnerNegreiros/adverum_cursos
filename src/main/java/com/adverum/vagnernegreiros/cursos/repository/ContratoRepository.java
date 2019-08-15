package com.adverum.vagnernegreiros.cursos.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adverum.vagnernegreiros.cursos.model.Contrato;

@Repository
@Transactional
public interface ContratoRepository extends CrudRepository<Contrato, Long>{

}


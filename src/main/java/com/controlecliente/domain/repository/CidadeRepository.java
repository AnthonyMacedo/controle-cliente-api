package com.controlecliente.domain.repository;

import org.springframework.stereotype.Repository;

import com.controlecliente.domain.model.Cidade;

@Repository
public interface CidadeRepository extends CustomJpaRepository<Cidade, Long> {

}

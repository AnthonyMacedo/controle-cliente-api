package com.controlecliente.domain.repository;

import org.springframework.stereotype.Repository;

import com.controlecliente.domain.model.Endereco;

@Repository
public interface EnderecoRepository extends CustomJpaRepository<Endereco, Long> {

}

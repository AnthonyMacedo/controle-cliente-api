package com.controlecliente.domain.repository;

import org.springframework.stereotype.Repository;

import com.controlecliente.domain.model.Cliente;

@Repository
public interface ClienteRepository extends CustomJpaRepository<Cliente, Long>, ClienteRepositoryQueries {

}

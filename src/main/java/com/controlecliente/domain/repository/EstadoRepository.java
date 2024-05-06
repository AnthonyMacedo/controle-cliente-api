package com.controlecliente.domain.repository;

import org.springframework.stereotype.Repository;

import com.controlecliente.domain.model.Estado;

@Repository
public interface EstadoRepository extends CustomJpaRepository<Estado, Long> {

}

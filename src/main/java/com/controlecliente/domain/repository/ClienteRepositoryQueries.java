package com.controlecliente.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.controlecliente.domain.model.Cliente;

public interface ClienteRepositoryQueries {

	Page<Cliente> buscarTodos(Pageable pageable);
}

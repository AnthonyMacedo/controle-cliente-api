package com.controlecliente.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.controlecliente.domain.model.Cliente;
import com.controlecliente.domain.repository.ClienteRepository;
import com.controlecliente.domain.repository.ClienteRepositoryQueries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class ClienteRepositoryImpl implements ClienteRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	@Lazy
	private ClienteRepository despesaOrcamentariaRepository;

	public Page<Cliente> buscarTodos(Pageable pageable) {
		TypedQuery<Cliente> query = manager.createQuery("from Cliente ", Cliente.class);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList());
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
}

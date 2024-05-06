package com.controlecliente.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlecliente.domain.exception.CidadeNaoEncontradaException;
import com.controlecliente.domain.model.Cidade;
import com.controlecliente.domain.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public Cidade porId(Long id) {
		return  cidadeRepository.findById(id).orElseThrow(() -> new CidadeNaoEncontradaException(id));
	}
	
	public List<Cidade> buscarTodos() {
		return cidadeRepository.findAll();
	}
	
}

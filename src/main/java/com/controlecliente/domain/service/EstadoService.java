package com.controlecliente.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlecliente.domain.exception.EstadoNaoEncontradoException;
import com.controlecliente.domain.model.Estado;
import com.controlecliente.domain.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public Estado porId(Long id) {
		return  estadoRepository.findById(id).orElseThrow(() -> new EstadoNaoEncontradoException(id));
	}
	
	public List<Estado> buscarTodos() {
		return estadoRepository.findAll();
	}
	
}

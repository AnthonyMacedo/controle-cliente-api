package com.controlecliente.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlecliente.domain.exception.EnderecoNaoEncontradaException;
import com.controlecliente.domain.model.Endereco;
import com.controlecliente.domain.repository.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Transactional
	public Endereco salvar(Endereco cliente) {
		return enderecoRepository.save(cliente);
	}
	
	public Endereco porId(Long id) {
		return  enderecoRepository.findById(id).orElseThrow(() -> new EnderecoNaoEncontradaException(id));
	}
	
	public List<Endereco> buscarTodos() {
		return enderecoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long id) {
		Endereco enderecoAtual = porId(id);
		enderecoRepository.delete(enderecoAtual);
		enderecoRepository.flush();
	}
}

package com.controlecliente.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.controlecliente.domain.exception.ClienteNaoEncontradaException;
import com.controlecliente.domain.model.Cliente;
import com.controlecliente.domain.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente porId(Long id) {
		return  clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradaException(id));
	}
	
	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}
	
	public Page<Cliente> buscarTodos(Pageable pageable) {
		return clienteRepository.buscarTodos(pageable);
	}
	
	@Transactional
	public void remover(Long id) {
		Cliente clienteAtual = porId(id);
		clienteRepository.delete(clienteAtual);
		clienteRepository.flush();
	}
}

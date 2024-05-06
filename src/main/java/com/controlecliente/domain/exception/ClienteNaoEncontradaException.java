package com.controlecliente.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public ClienteNaoEncontradaException(Long id) {
		this(String.format("Não existe um cadastro de cliente com código %d", id));
	}
}

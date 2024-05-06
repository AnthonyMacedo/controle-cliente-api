package com.controlecliente.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EnderecoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public EnderecoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public EnderecoNaoEncontradaException(Long id) {
		this(String.format("Não existe um cadastro de endereço com código %d", id));
	}
}

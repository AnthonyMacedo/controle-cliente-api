package com.controlecliente.api.v1.model.input;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {

	@NotEmpty
	private String logradouro;
	@NotEmpty
	private String numero;
	
	private String complemento;
	@NotEmpty
	private String bairro;
	@NotEmpty
	private String cep;
	
	private CidadeIdInput cidade;
	
	private CoordenadaGeograficaInput coordenadaGeografica;
	
}

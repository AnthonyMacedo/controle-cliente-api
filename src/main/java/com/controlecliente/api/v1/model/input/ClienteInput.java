package com.controlecliente.api.v1.model.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInput {

	@NotEmpty
	private String nome;
	@NotEmpty
	private String cnpj;
	
	@NotNull
	private EnderecoInput endereco;
	
}

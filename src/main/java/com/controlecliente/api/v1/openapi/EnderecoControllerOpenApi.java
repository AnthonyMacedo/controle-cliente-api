package com.controlecliente.api.v1.openapi;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.controlecliente.api.v1.model.EnderecoModel;
import com.controlecliente.api.v1.model.input.EnderecoInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endereços" )
public interface EnderecoControllerOpenApi {

	@Operation(summary = "Adiciona um endereço na base de dados.", 
				responses = @ApiResponse(responseCode = "201") )
	EnderecoModel adicionar(@PathVariable("clienteId")Long clienteId, @RequestBody(description = "Representação de um endereço", required = true) EnderecoInput endereçoInput);
	
	@Operation(summary = "Retorna uma representação de todos os endereços.")
	List<EnderecoModel> buscarTodos();
	
	@Operation(summary = "Retorna uma representação de endereço por ID.")
	EnderecoModel porId(@PathVariable("enderecoId") Long enderecoId);
	
	@Operation(summary = "Remove um endereço da base de dados por ID.", responses = @ApiResponse(responseCode = "204"))
	void remover(@PathVariable("enderecoId") Long enderecoId);
	
}

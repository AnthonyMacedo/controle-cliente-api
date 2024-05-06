package com.controlecliente.api.v1.openapi;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import com.controlecliente.api.v1.model.ClienteModel;
import com.controlecliente.api.v1.model.input.ClienteInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clientes" )
public interface ClienteControllerOpenApi {

	@Operation(summary = "Adiciona um cliente na base de dados.", 
				responses = @ApiResponse(responseCode = "201"))
	ClienteModel adicionar(@RequestBody(description = "Representação de um cliente", required = true) ClienteInput clienteInput);
	
	@Operation(summary = "Retorna uma representação de todos os clientes.")
	Page<ClienteModel> buscarTodos(Pageable pageable);
	
	@Operation(summary = "Retorna uma representação de cliente por ID.")
	ClienteModel porId(@PathVariable("id") Long id);
	
	@Operation(summary = "Remove um cliente da base de dados por ID.", responses = @ApiResponse(responseCode = "204"))
	void remover(@PathVariable("id") Long id);
}

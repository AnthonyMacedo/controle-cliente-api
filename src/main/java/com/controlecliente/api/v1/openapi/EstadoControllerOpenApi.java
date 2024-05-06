package com.controlecliente.api.v1.openapi;


import java.util.List;

import com.controlecliente.api.v1.model.EstadoModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Estados" )
public interface EstadoControllerOpenApi {

	@Operation(summary = "Retorna uma representação de todos os estados.")
	List<EstadoModel> buscarTodos();
	
}

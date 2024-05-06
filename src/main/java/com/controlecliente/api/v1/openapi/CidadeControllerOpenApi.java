package com.controlecliente.api.v1.openapi;


import java.util.List;

import com.controlecliente.api.v1.model.CidadeModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cidades" )
public interface CidadeControllerOpenApi {

	@Operation(summary = "Retorna uma representação de todas as cidades.")
	List<CidadeModel> buscarTodas();
	
}

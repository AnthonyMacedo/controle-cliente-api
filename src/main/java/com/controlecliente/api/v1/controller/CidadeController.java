package com.controlecliente.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlecliente.api.v1.assembler.CidadeModelAssembler;
import com.controlecliente.api.v1.model.CidadeModel;
import com.controlecliente.api.v1.openapi.CidadeControllerOpenApi;
import com.controlecliente.domain.service.CidadeService;

@RestController
@RequestMapping(value = "/api/v1/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
public class CidadeController implements CidadeControllerOpenApi {

	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private CidadeModelAssembler cidadeModelAssembler;
	
	@GetMapping
	public List<CidadeModel> buscarTodas() {
		return cidadeModelAssembler.toCollectionModel(cidadeService.buscarTodos());
	}
	
	
}

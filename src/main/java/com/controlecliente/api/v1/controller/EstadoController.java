package com.controlecliente.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlecliente.api.v1.assembler.EstadoModelAssembler;
import com.controlecliente.api.v1.model.EstadoModel;
import com.controlecliente.api.v1.openapi.EstadoControllerOpenApi;
import com.controlecliente.domain.service.EstadoService;

@RestController
@RequestMapping(value = "/api/v1/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController implements EstadoControllerOpenApi {

	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private EstadoModelAssembler estadoModelAssembler;
	
	@GetMapping
	public List<EstadoModel> buscarTodos() {
		return estadoModelAssembler.toCollectionModel(estadoService.buscarTodos());
	}
	
	
}

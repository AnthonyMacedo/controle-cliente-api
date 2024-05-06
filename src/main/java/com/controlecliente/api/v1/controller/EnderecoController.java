package com.controlecliente.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controlecliente.api.v1.assembler.EnderecoModelAssembler;
import com.controlecliente.api.v1.assembler.disassembler.EnderecoInputDisassembler;
import com.controlecliente.api.v1.model.EnderecoModel;
import com.controlecliente.api.v1.model.input.EnderecoInput;
import com.controlecliente.api.v1.openapi.EnderecoControllerOpenApi;
import com.controlecliente.domain.model.Endereco;
import com.controlecliente.domain.service.EnderecoService;

@RestController
@RequestMapping(value = "/api/v1/enderecos")
public class EnderecoController implements EnderecoControllerOpenApi {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoModelAssembler enderecoAssembler;
	
	@Autowired
	private EnderecoInputDisassembler enderecoDisassembler;

	@PostMapping("/{clienteId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public EnderecoModel adicionar(@PathVariable("clienteId")Long clienteId, @RequestBody EnderecoInput enderecoInput) {
		Endereco endereco = enderecoDisassembler.toDomainObject(enderecoInput);
		
		return enderecoAssembler.toModel(enderecoService.salvar(endereco));
	}
	
	@GetMapping
	public List<EnderecoModel> buscarTodos() {
		return enderecoAssembler.toCollectionModel(enderecoService.buscarTodos());
	}

	@GetMapping("/{enderecoId}")
	public EnderecoModel porId(@PathVariable("enderecoId") Long enderecoId) {
		return enderecoAssembler.toModel(enderecoService.porId(enderecoId));
	}

	@DeleteMapping("/{enderecoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable("enderecoId") Long enderecoId) {
		enderecoService.remover(enderecoId);
	}

}

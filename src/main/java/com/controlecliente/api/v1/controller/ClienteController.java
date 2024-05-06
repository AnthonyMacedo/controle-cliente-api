package com.controlecliente.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controlecliente.api.v1.assembler.ClienteModelAssembler;
import com.controlecliente.api.v1.assembler.disassembler.ClienteInputDisassembler;
import com.controlecliente.api.v1.assembler.disassembler.EnderecoInputDisassembler;
import com.controlecliente.api.v1.model.ClienteModel;
import com.controlecliente.api.v1.model.input.ClienteInput;
import com.controlecliente.api.v1.openapi.ClienteControllerOpenApi;
import com.controlecliente.domain.exception.NegocioException;
import com.controlecliente.domain.model.Cliente;
import com.controlecliente.domain.model.Endereco;
import com.controlecliente.domain.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController implements ClienteControllerOpenApi {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteModelAssembler clienteAssembler;

	@Autowired
	private ClienteInputDisassembler clienteDisassembler;

	@Autowired
	private EnderecoInputDisassembler enderecoDisassembler;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClienteModel adicionar(@RequestBody @Valid ClienteInput clienteInput) {
		try {
			Cliente cliente = clienteDisassembler.toDomainObject(clienteInput);

			Endereco endereco = enderecoDisassembler.toDomainObject(clienteInput.getEndereco());

			endereco.setCliente(cliente);
			cliente.getEndereco().add(endereco);

			return clienteAssembler.toModel(clienteService.salvar(cliente));

		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping
	public Page<ClienteModel> buscarTodos(Pageable pageable) {
		return clienteAssembler.toCollectionModel(clienteService.buscarTodos(pageable));
	}

	@GetMapping("/{id}")
	public ClienteModel porId(@PathVariable("id") Long id) {
		return clienteAssembler.toModel(clienteService.porId(id));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable("id") Long id) {
		clienteService.remover(id);
	}
}

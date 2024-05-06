package com.controlecliente.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.controlecliente.api.v1.model.ClienteModel;
import com.controlecliente.domain.model.Cliente;

@Component
public class ClienteModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ClienteModel toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteModel.class);
	}

	public List<ClienteModel> toCollectionModel(List<Cliente> clientes) {
		return clientes.stream().map(cliente -> toModel(cliente)).collect(Collectors.toList());
	}
	
	public Page<ClienteModel> toCollectionModel(Page<Cliente> clientes) {
		return new PageImpl<>(clientes.stream().map(cliente -> toModel(cliente)).collect(Collectors.toList()));
	}
}

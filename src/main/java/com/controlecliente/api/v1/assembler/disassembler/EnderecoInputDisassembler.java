package com.controlecliente.api.v1.assembler.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controlecliente.api.v1.model.input.EnderecoInput;
import com.controlecliente.domain.model.Endereco;

@Component
public class EnderecoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Endereco toDomainObject(EnderecoInput enderecoInput) {
		return modelMapper.map(enderecoInput, Endereco.class);
	}

	public void copyToDomainObject(EnderecoInput enderecoInput, Endereco endereco) {
		modelMapper.map(enderecoInput, endereco);
	}

}

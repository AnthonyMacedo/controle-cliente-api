
package com.controlecliente.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		 
//		mapEnderecoToEnderecoModel(modelMapper);
		 
		
		return modelMapper;
	}

//	private void mapEnderecoToEnderecoModel(ModelMapper modelMapper) {
//		TypeMap<Endereco, EnderecoModel> enderecoToEnderecoModel = modelMapper.createTypeMap(Endereco.class, EnderecoModel.class); 
//		
//		enderecoToEnderecoModel.<String>addMapping(
//				enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(),
//				(dest, value) -> dest.getCidade().setEstado(value));
//	}
	
}

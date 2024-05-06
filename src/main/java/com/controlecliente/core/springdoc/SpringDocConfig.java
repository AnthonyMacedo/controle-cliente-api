package com.controlecliente.core.springdoc;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SpringDocConfig {

	@Bean
	OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Controle de Clientes API")
						.version("v1")
						.description("Aplicação rest destinada a armazenar dados dos cliente e endereço com localização geográfica.")
					  )
				.tags(
						Arrays.asList(
								new Tag().name("Clientes").description("Controle de clientes."),
								new Tag().name("Endereços").description("Controle de endereços."),
								new Tag().name("Estados").description("Listagem de estados."),
								new Tag().name("Cidades").description("Listagem de cidades.") )
								
					  );
	}
	
}

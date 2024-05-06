-- sistema.estado definition

-- Drop table

-- DROP TABLE sistema.estado;

CREATE TABLE sistema.estado (
	id bigserial NOT NULL,
	nome varchar(120) NULL,
	uf varchar(2) NULL,
	CONSTRAINT estado_pkey PRIMARY KEY (id)
);

-- sistema.cidade definition

-- Drop table

-- DROP TABLE sistema.cidade;

CREATE TABLE sistema.cidade (
	id bigserial NOT NULL,
	estado_id bigint NULL,
	nome varchar(120) NULL,
	CONSTRAINT cidade_pkey PRIMARY KEY (id),
	CONSTRAINT fk_cidade_estado_id FOREIGN KEY (estado_id) REFERENCES sistema.estado(id)
);

-- sistema.coordenada_geografica definition

-- Drop table

-- DROP TABLE sistema.coordenada_geografica;

CREATE TABLE sistema.coordenada_geografica (
	latitude double precision NULL,
	longitude double precision NULL,
	id bigserial NOT NULL,
	CONSTRAINT coordenada_geografica_pkey PRIMARY KEY (id)
);

-- sistema.cliente definition

-- Drop table

-- DROP TABLE sistema.cliente;

CREATE TABLE sistema.cliente (
	id bigserial NOT NULL,
	nome varchar(120) NOT NULL,
	cnpj varchar(18) NOT NULL,
	data_cadastro TIMESTAMP WITH TIME ZONE NOT NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id)
);

-- sistema.endereco definition

-- Drop table

-- DROP TABLE sistema.endereco;

CREATE TABLE sistema.endereco (
	id bigserial NOT NULL,
	endereco_bairro varchar(80) NULL,
	endereco_cep varchar(10) NULL,
	endereco_logradouro varchar(120) NULL,
	endereco_complemento varchar(120) NULL,
	endereco_numero varchar(20) NULL,
	cidade_id bigint NULL,
	cliente_id bigint NOT NULL,
	coordenada_geografica_id bigint NULL,
	CONSTRAINT endereco_pkey PRIMARY KEY (id),
	CONSTRAINT fk_endereco_cliente_id FOREIGN KEY (cliente_id) REFERENCES sistema.cliente(id)
);
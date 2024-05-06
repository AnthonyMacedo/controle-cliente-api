package com.controlecliente.domain.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "sistema")
@EqualsAndHashCode(of = "id")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "endereco_logradouro")
	private String logradouro;

	@Column(name = "endereco_numero")
	private String numero;

	@Column(name = "endereco_complemento")
	private String complemento;

	@Column(name = "endereco_bairro")
	private String bairro;

	@Column(name = "endereco_cep")
	private String cep;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cidade_id", foreignKey = @ForeignKey(name = "fk_endereco_cidade_id"))
	private Cidade cidade;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coordenada_geografica_id", foreignKey = @ForeignKey(name = "fk_endereco_coordenada_geografica_id"))
	private CoordenadaGeografica coordenadaGeografica;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "fk_endereco_cliente_id"))
	private Cliente cliente;
}

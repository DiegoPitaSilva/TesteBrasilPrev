package br.com.brasilprev.Avaliacao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import br.com.brasilprev.Avaliacao.security.SQLInjectionBrasilPrev;
import lombok.Getter;
import lombok.Setter;

@Entity

public class Produtos extends AbstractModel<Long> {

	@Getter
	@Setter
	@ManyToOne(cascade = {CascadeType.ALL},optional=true)
	@JoinColumn(name = "idCategoria")
	private Categorias categoria;
	
	@Getter
	@Setter
	
	private String produto;
	
	@Getter
	@Setter
	private Double preco;
	@Getter
	@Setter
	private Integer quantidade;

	@Getter
	@Setter

	private String descricao;

	@Lob
	@Column(name = "foto", nullable = false, columnDefinition = "bytea")
	@Getter
	@Setter
	private byte[] imagem;

}

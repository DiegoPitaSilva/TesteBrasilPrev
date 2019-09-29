package br.com.brasilprev.Avaliacao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidoItens")
public class PedidoItens extends AbstractModel<Long> {
	
	@Getter
	@Setter
	@ManyToOne(cascade = {CascadeType.ALL},optional=true)
	@JoinColumn(name = "idPedido")
	private Pedidos pedidos;
	
	@Getter
	@Setter
	@ManyToOne(cascade = {CascadeType.ALL},optional=true)
	@JoinColumn(name = "idProduto")
	private Produtos produtos;
	@Getter
	@Setter
	private String produto;
	
	@Getter
	@Setter
	private Integer quantidade;

	@Getter
	@Setter
	private Double valor;
	
	@Getter
	@Setter
	private Double subtotal;
	
}

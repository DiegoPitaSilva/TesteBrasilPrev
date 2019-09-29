package br.com.brasilprev.Avaliacao.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Pedidos extends AbstractModel<Long> {

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@ManyToOne(cascade = {CascadeType.PERSIST},optional=false)
	
	@JoinColumn(name = "idCliente")
	@Getter
	@Setter
	private Clientes cliente;
	
	@Getter
	@Setter
	private String status;
	
	@Getter
	@Setter
	private String sessao;
	
}

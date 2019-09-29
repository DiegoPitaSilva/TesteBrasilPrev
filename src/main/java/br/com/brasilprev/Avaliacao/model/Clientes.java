package br.com.brasilprev.Avaliacao.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.com.brasilprev.Avaliacao.security.SQLInjectionBrasilPrev;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Clientes extends AbstractModel<Long> {
	
	@NotNull
	@Getter
	@Setter

	private String nome;
	@Getter
	@Setter
	private String email;
	
	@NotNull
	@Getter
	@Setter

	private String senha;
	
	@Getter
	@Setter
	private String rua;

	@Getter
	@Setter
	private String cidade;
	@Getter
	@Setter
	private String bairro;

	@Getter
	@Setter
	private String cep;
	
	@Getter
	@Setter
	private String estado;

}

package br.com.brasilprev.Avaliacao.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Categorias extends AbstractModel<Long> {

	@Getter
	@Setter
	private String categoria;
	
}

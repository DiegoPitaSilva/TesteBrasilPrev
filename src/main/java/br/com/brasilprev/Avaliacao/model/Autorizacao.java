package br.com.brasilprev.Avaliacao.model;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Autorizacao extends AbstractModel<Long> implements GrantedAuthority {

	private String nome;
	
	@Override
	public String getAuthority() {
		
		return getNome();
	}
	
}

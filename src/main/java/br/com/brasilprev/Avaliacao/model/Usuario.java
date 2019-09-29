package br.com.brasilprev.Avaliacao.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity

public class Usuario extends AbstractModel<Long> implements UserDetails {
	
	@Column(name = "username")

	@Setter
	private String username;
	@Getter
	@Setter
	private String senha;
	@Getter
	@Setter
	private boolean contaExpirada;
	@Getter
	@Setter
	private boolean acessoExpirado;
	@Getter
	@Setter
	private boolean credencialExpirada;
	@Getter
	@Setter
	private boolean ativo;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USUARIOS_AUTORIZACAO", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "autorizacao_id", referencedColumnName = "id"))
	private Collection<Autorizacao> autorizacoes;

	@Override
	@OrderBy
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}

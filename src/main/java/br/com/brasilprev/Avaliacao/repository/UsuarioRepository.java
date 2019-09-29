package br.com.brasilprev.Avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brasilprev.Avaliacao.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 *
	 * @param username
	 * @return @{@link Usuario}
	 */
	Usuario findOneByUsername(String username);
}

package br.com.brasilprev.Avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.brasilprev.Avaliacao.model.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {
	
	@Query("SELECT cliente  from Clientes as cliente WHERE cliente.dataExclusao is  null ")
	List<Clientes> findAllClientes();

}

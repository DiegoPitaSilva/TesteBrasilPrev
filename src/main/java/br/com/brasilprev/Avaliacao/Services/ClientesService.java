package br.com.brasilprev.Avaliacao.Services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.brasilprev.Avaliacao.model.Clientes;

public interface ClientesService {

	ResponseEntity<List<Clientes>> findAllCliente();

	ResponseEntity<Clientes> saveCliente(Clientes u);
	
	ResponseEntity<String> deleteCliente(Clientes id);

	ResponseEntity<Clientes> findOneCliente(Long id);
	
	ResponseEntity<Clientes> atualizaClientes(Clientes cat) throws SQLException;

}

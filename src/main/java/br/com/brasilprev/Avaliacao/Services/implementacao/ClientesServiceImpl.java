package br.com.brasilprev.Avaliacao.Services.implementacao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.brasilprev.Avaliacao.Services.AbstractService;
import br.com.brasilprev.Avaliacao.Services.ClientesService;
import br.com.brasilprev.Avaliacao.errorControls.ClienteServiceErrorAdvice;
import br.com.brasilprev.Avaliacao.exceptions.ClienteServiceNotFoundException;
import br.com.brasilprev.Avaliacao.exceptions.ClientesServiceException;
import br.com.brasilprev.Avaliacao.exceptions.ClientesServiceValidationException;
import br.com.brasilprev.Avaliacao.model.Clientes;
import br.com.brasilprev.Avaliacao.repository.ClienteRepository;
import br.com.brasilprev.Avaliacao.utils.ConstraintsValue;

@Service
public class ClientesServiceImpl extends AbstractService<Clientes, Long> implements ClientesService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	protected JpaRepository<Clientes, Long> getRepository() {
		
		return clienteRepository;
	}
	
	@Override
	public ResponseEntity<List<Clientes>> findAllCliente() {
	List<Clientes> clientes = clienteRepository.findAllClientes();
	 if (clientes != null && clientes.size() >0){
		 
		 return new ResponseEntity<List<Clientes>>(clientes,HttpStatus.OK);
		 
	 }else{
		 
		 
		 throw new ClienteServiceNotFoundException("Não foi possivel achar o usuário");
	 }
	}
	
	@Override
	public ResponseEntity<Clientes> saveCliente(Clientes u) {
		
		try {

			clienteRepository.save(u);

			return new ResponseEntity<Clientes>(u,HttpStatus.OK);

		} catch (ClienteServiceNotFoundException cliente) {
			
			 throw new ClienteServiceNotFoundException("Não foi possivel achar o usuário");
		}
	}
	
	@Override
	public ResponseEntity<String> deleteCliente(Clientes cliente) {
		
		if (cliente != null) {
			Date date = new Date();
			date.getTime();
			cliente.setDataExclusao(date);

			try {

				save(cliente);
				return new ResponseEntity<String>(ConstraintsValue.jsonReponseOk,HttpStatus.OK);

			} catch (ClienteServiceNotFoundException c) {
				 throw new ClienteServiceNotFoundException("Não foi possivel achar o usuário");

				
			}catch(ClientesServiceValidationException c){
				throw new ClientesServiceValidationException("Não foi possivel achar o usuário");
			}catch(ClientesServiceException s){
				
				throw new ClientesServiceException("Não foi possivel achar o usuário");
			}

		} else {
			
			 throw new ClienteServiceNotFoundException("não achado");
		}
	}
	
	@Override
	public ResponseEntity<Clientes> findOneCliente(Long id) {
		 
		Clientes cliente = get(id);
		if(cliente !=null){
			return new ResponseEntity<Clientes>(cliente,HttpStatus.OK);
		}else{
			
			throw new ClienteServiceNotFoundException("Não foi possível achar o cliente");
		}
		
		 
		
	}
	
	@Override
	public ResponseEntity<Clientes> atualizaClientes(Clientes cat) throws SQLException {
		update(cat);
		return new ResponseEntity<Clientes>(cat,HttpStatus.OK);
	}

}

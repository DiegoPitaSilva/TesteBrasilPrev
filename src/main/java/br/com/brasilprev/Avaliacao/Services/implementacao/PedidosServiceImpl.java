package br.com.brasilprev.Avaliacao.Services.implementacao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.brasilprev.Avaliacao.Services.AbstractService;
import br.com.brasilprev.Avaliacao.Services.PedidosService;
import br.com.brasilprev.Avaliacao.exceptions.PedidoNotFoundException;
import br.com.brasilprev.Avaliacao.exceptions.PedidoNotFoundServiceException;
import br.com.brasilprev.Avaliacao.model.Pedidos;
import br.com.brasilprev.Avaliacao.repository.PedidoRepository;
import br.com.brasilprev.Avaliacao.utils.ConstraintsValue;

@Service
public class PedidosServiceImpl extends AbstractService<Pedidos, Long> implements PedidosService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	protected JpaRepository<Pedidos, Long> getRepository() {

		return pedidoRepository;
	}
	
	@Override
	public ResponseEntity<List<Pedidos>> findAllPedidos() {
		
		List<Pedidos> listaPedidos = pedidoRepository.findAll();
		if (listaPedidos !=null && listaPedidos.size()>0){
		   
			return new ResponseEntity<List<Pedidos>>(listaPedidos,HttpStatus.OK);
		
		}else{
			
			throw new  PedidoNotFoundServiceException("nao achado");
		}
	}
	
	@Override
	public ResponseEntity<Pedidos> savePedido(Pedidos u) {
		try {

			this.save(u);

			return new ResponseEntity<Pedidos>(u,HttpStatus.OK);

		} catch (PedidoNotFoundServiceException e) {
			throw new  PedidoNotFoundServiceException(e.getMessage());
			

		}
		
	}
	
	@Override
	public ResponseEntity<String> deletePedido(Pedidos pedido) {

		if (pedido != null) {
			Date date = new Date();
			date.getTime();
			pedido.setDataExclusao(date);

			try {

				save(pedido);
				return new ResponseEntity<String>(ConstraintsValue.jsonReponseOk,HttpStatus.OK);

			} catch (PedidoNotFoundServiceException e) {
				throw new  PedidoNotFoundServiceException(e.getMessage());
				
				
			}
			}else{
				throw new  PedidoNotFoundServiceException("Não foi achado");
			}
				
	}
	
	@Override
	public ResponseEntity<Pedidos> findOnePedido(Long id) {
          Pedidos pedido = get(id);
          
          if (pedido!=null){
        	  
        	  return new  ResponseEntity<Pedidos> (pedido,HttpStatus.OK);
          }
          else{
        	  throw new  PedidoNotFoundException("Error");
          }
	}

	@Override
	public ResponseEntity<Pedidos> atualizaPedido(Pedidos cat) {
		try {
			update(cat);
			return new ResponseEntity<Pedidos> (cat,HttpStatus.OK);
			
		} catch (PedidoNotFoundServiceException e) {

			throw new PedidoNotFoundServiceException(e.getMessage());
		}
	}

}

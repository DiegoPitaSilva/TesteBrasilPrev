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
import br.com.brasilprev.Avaliacao.Services.PedidosItensService;
import br.com.brasilprev.Avaliacao.exceptions.PedidoItemNotFoundException;
import br.com.brasilprev.Avaliacao.exceptions.PedidoItemServiceValidationException;
import br.com.brasilprev.Avaliacao.model.PedidoItens;
import br.com.brasilprev.Avaliacao.repository.PedidoItensRepository;
import br.com.brasilprev.Avaliacao.utils.ConstraintsValue;

@Service
public class PedidosItensServiceImpl extends AbstractService<PedidoItens, Long> implements PedidosItensService {
	
	@Autowired
	private PedidoItensRepository pedidoItensRepository;

	@Override
	protected JpaRepository<PedidoItens, Long> getRepository() {
		// TODO Auto-generated method stub
		return pedidoItensRepository;
	}

	@Override
	public ResponseEntity<List<PedidoItens>> findAllPedidosItens() {
		
	  List<PedidoItens> lista =pedidoItensRepository.findAllPedidoItens();
	    if (lista!=null && lista.size()>0){
	    	
	    	return new ResponseEntity<List<PedidoItens>>(lista,HttpStatus.OK);
	    }else{
	    	
	    	throw new PedidoItemNotFoundException("Nada disponivel");
	    }
	  
		
	}

	@Override
	public ResponseEntity<PedidoItens> savePedidoItens(PedidoItens u) {
		// TODO Auto-generated method stub
		
		try {
			
			this.save(u);
			
			return new ResponseEntity<PedidoItens>(u,HttpStatus.OK);
			
		} catch (PedidoItemNotFoundException exc){
			
			throw new PedidoItemNotFoundException(exc.getMessage());
			
		}
	}

	@Override
	public ResponseEntity<String> deletePedidoItens(PedidoItens pedidoItens) {

		if (pedidoItens != null) {
			Date date = new Date();
			date.getTime();
			pedidoItens.setDataExclusao(date);
			
			try {
				
				save(pedidoItens);

				return new ResponseEntity<String>(ConstraintsValue.jsonReponseOk,HttpStatus.OK);
				
			} catch (PedidoItemNotFoundException exp){
				throw new PedidoItemNotFoundException("erro");
				
			}
		}else{
			throw new PedidoItemNotFoundException("não foi atualizado");
		}
	}

	@Override
	public ResponseEntity<PedidoItens> findOnePedidoItens(Long id) {
		 PedidoItens pedidoItens = get(id);
		 if (pedidoItens !=null){
			 return new ResponseEntity<PedidoItens>(pedidoItens,HttpStatus.OK);
		 }
		 else{
			 throw new PedidoItemNotFoundException("não foi atualizado");
			 
		 }
	}
	
	@Override
	public ResponseEntity<PedidoItens> atualizaPedidoItens(PedidoItens cat) {
		try {
			update(cat);
			return new ResponseEntity<PedidoItens>(cat,HttpStatus.OK);

		} catch (PedidoItemNotFoundException exception) {
			
			throw new PedidoItemNotFoundException("não foi atualizado");
		}
	}

}

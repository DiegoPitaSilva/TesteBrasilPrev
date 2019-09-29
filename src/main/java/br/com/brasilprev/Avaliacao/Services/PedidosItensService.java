package br.com.brasilprev.Avaliacao.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.brasilprev.Avaliacao.model.PedidoItens;

public interface PedidosItensService {
	
	ResponseEntity<List<PedidoItens>> findAllPedidosItens();

	ResponseEntity<PedidoItens> savePedidoItens(PedidoItens u);
	
	ResponseEntity<String> deletePedidoItens(PedidoItens id);

	ResponseEntity<PedidoItens> findOnePedidoItens(Long id);

	ResponseEntity<PedidoItens> atualizaPedidoItens(PedidoItens cat);
}

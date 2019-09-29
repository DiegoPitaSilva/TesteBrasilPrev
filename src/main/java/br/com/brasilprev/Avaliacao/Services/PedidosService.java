package br.com.brasilprev.Avaliacao.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.brasilprev.Avaliacao.model.Pedidos;

public interface PedidosService {

	ResponseEntity<List<Pedidos>> findAllPedidos();
	
	ResponseEntity<Pedidos> savePedido(Pedidos u);

	ResponseEntity<String> deletePedido(Pedidos id);
	
	ResponseEntity<Pedidos> findOnePedido(Long id);

	ResponseEntity<Pedidos> atualizaPedido(Pedidos cat);
}

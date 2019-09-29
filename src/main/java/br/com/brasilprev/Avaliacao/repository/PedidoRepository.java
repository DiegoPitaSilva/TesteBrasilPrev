package br.com.brasilprev.Avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.brasilprev.Avaliacao.model.Pedidos;

public interface PedidoRepository extends JpaRepository<Pedidos, Long> {
	
	@Query("SELECT pedido  from Pedidos as pedido WHERE pedido.dataExclusao is  null ")
	List<Pedidos> findAllPedido();
	
}

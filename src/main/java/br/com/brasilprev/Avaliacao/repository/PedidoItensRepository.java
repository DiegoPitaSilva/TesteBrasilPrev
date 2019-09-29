package br.com.brasilprev.Avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.brasilprev.Avaliacao.model.PedidoItens;

public interface PedidoItensRepository extends JpaRepository<PedidoItens, Long> {

	@Query("SELECT pedidoItens  from PedidoItens as pedidoItens WHERE pedidoItens.dataExclusao is  null ")
	List<PedidoItens> findAllPedidoItens();

}

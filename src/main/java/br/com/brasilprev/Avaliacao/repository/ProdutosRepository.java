package br.com.brasilprev.Avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.brasilprev.Avaliacao.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	@Query("SELECT produto  from Produtos as produto WHERE produto.dataExclusao is  null ")
	List<Produtos> findAllProdutos();

}

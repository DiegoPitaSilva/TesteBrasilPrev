package br.com.brasilprev.Avaliacao.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.brasilprev.Avaliacao.model.Produtos;

public interface ProdutosService {

	ResponseEntity<List<Produtos>> findAllProdutos();
	
	ResponseEntity<Produtos> saveProdutos(Produtos u);

	ResponseEntity<String> deleteProduto(Produtos id);
	
	ResponseEntity<Produtos> findOneProduto(Long id);

	ResponseEntity <Produtos> atualizaProdutos(Produtos cat);
	
}

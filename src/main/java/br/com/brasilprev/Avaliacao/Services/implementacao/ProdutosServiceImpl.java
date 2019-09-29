package br.com.brasilprev.Avaliacao.Services.implementacao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.brasilprev.Avaliacao.Services.AbstractService;
import br.com.brasilprev.Avaliacao.Services.ProdutosService;
import br.com.brasilprev.Avaliacao.exceptions.ProdutosNotFoundException;
import br.com.brasilprev.Avaliacao.model.Produtos;
import br.com.brasilprev.Avaliacao.repository.ProdutosRepository;
import br.com.brasilprev.Avaliacao.utils.ConstraintsValue;

@Service
public class ProdutosServiceImpl extends AbstractService<Produtos, Long> implements ProdutosService {

	@Autowired
	
	private ProdutosRepository produtosRepository;
	
	@Override
	protected JpaRepository<Produtos, Long> getRepository() {
		
		return produtosRepository;
	}

	@Override
	public ResponseEntity<List<Produtos>> findAllProdutos() {
		List<Produtos> listaProduto = produtosRepository.findAllProdutos();
		
		if (listaProduto !=null && listaProduto.size()>0){
			
			return new ResponseEntity<List<Produtos>>(listaProduto,HttpStatus.OK);
		}else{
			
			throw new ProdutosNotFoundException("NÃO EXISTEM DADOS NA LISTA");
		}
	}

	@Override
	public ResponseEntity<Produtos> saveProdutos(Produtos u) {
		try {

			this.save(u);

			return new  ResponseEntity<Produtos>(u,HttpStatus.OK);

		} catch (ProdutosNotFoundException ex){
			
			throw new ProdutosNotFoundException(ex.getMessage());
		}
	}

	@Override
	public ResponseEntity<String> deleteProduto(Produtos produtos) {

		if (produtos != null) {
			Date date = new Date();
			date.getTime();
			produtos.setDataExclusao(date);

			try {

				save(produtos);
				return new  ResponseEntity<String>(ConstraintsValue.jsonReponseOk,HttpStatus.OK);

			} catch (ProdutosNotFoundException e) {
				throw new ProdutosNotFoundException(e.getMessage());
			}

		} else {
			
			throw new ProdutosNotFoundException("Produto não foi achado");
		}
	}

	@Override
	public ResponseEntity<Produtos> findOneProduto(Long id) {
		
		Produtos produto = get(id);
		if (produto !=null){
			return new ResponseEntity<Produtos>(produto,HttpStatus.OK);
		}else{
			throw new ProdutosNotFoundException("Produto não foi achado");
		}
		
	}
	
	@Override
	public ResponseEntity<Produtos> atualizaProdutos(Produtos cat) {
		try {
			update(cat);
			return new ResponseEntity<Produtos>(cat,HttpStatus.OK);

		} catch (ProdutosNotFoundException e) {
			
			throw new ProdutosNotFoundException(e.getMessage());
		}
	}
	
}

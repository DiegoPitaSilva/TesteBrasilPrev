package br.com.brasilprev.Avaliacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.Avaliacao.Services.ProdutosService;
import br.com.brasilprev.Avaliacao.model.Categorias;
import br.com.brasilprev.Avaliacao.model.Produtos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("brasilPrevContextPatternSecured/produtos")
@Api(value = "Cadastro de Produto", description = "Produtos Controller .")
public class ProdutoController {
	
	@Autowired
	private ProdutosService produtoService;
	
	@ApiOperation(value = "Retorna uma lista com PRODUTOS")
	@RequestMapping(value = "/getProdutos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	public ResponseEntity<List<Produtos>> findAllCategoria() {
		return produtoService.findAllProdutos();
		
	}
	
	@ApiOperation(value = "Retorna um Produto pelo ID")
	@RequestMapping(value = "/getProduto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<Produtos> findCategoriaById(@PathVariable(value = "id") long id) {
		
		return produtoService.findOneProduto(id);
		
	}
	
	@ApiOperation(value = "Salva um produto ", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null' ")
	@RequestMapping(value = "/saveProduto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<Produtos> Post(@Valid @RequestBody Produtos produtos) {
		
		
		return produtoService.saveProdutos(produtos);
	}
	
	@ApiOperation(value = "Esse metodo apaga de forma lógica do banco de dados um pedido item", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/deleteProduto", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})

	public ResponseEntity<String> delete(@Valid @RequestBody Produtos produto) {
		return produtoService.deleteProduto(produto);
	}
	
	
	@ApiOperation(value = "Esse metodo atualiza um Produto", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/updateCategoria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<Produtos> atualiza(@Valid @RequestBody Produtos produto) {

		return produtoService.atualizaProdutos(produto);
	}
}

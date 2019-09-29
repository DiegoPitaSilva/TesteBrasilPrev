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

import br.com.brasilprev.Avaliacao.Services.PedidosItensService;
import br.com.brasilprev.Avaliacao.model.Categorias;
import br.com.brasilprev.Avaliacao.model.PedidoItens;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("brasilPrevContextPatternSecured/pedidoItens")
@Api(value = "Pedido Itens Controller", description = "Pedidos Itens Controller .")

public class PedidoItensController {
	@Autowired
	private PedidosItensService pedidoService;
	
	@ApiOperation(value = "Retorna uma lista com todos os pedidos")
	@RequestMapping(value = "/getProdutosItens", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	public ResponseEntity<List<PedidoItens>> findAllCategoria() {
		return pedidoService.findAllPedidosItens();
		
	}
	
	@ApiOperation(value = "Retorna um Cliente pelo ID")
	@RequestMapping(value = "/getPedidoItens/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})

	public ResponseEntity<PedidoItens> findCategoriaById(@PathVariable(value = "id") long id) {

		return pedidoService.findOnePedidoItens(id);
		
	}
	
	@ApiOperation(value = "Salva ou atualizar  na tabela pedido itens", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/savePeditoItens", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<PedidoItens> Post(@Valid @RequestBody PedidoItens pedidoItens) {
		return pedidoService.savePedidoItens(pedidoItens);
	}
	
	@ApiOperation(value = "Esse metodo apaga de forma lógica do banco de dados um pedido item", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/deletePedidoItens", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<String> delete(@Valid @RequestBody PedidoItens pedido) {
		return pedidoService.deletePedidoItens(pedido);
	}
	
	@ApiOperation(value = "Esse metodo atualiza um Pedido Item", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/updatePedidoItem", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<PedidoItens> atualiza(@Valid @RequestBody PedidoItens categoria) {

		return pedidoService.atualizaPedidoItens(categoria);
	}

}

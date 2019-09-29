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

import br.com.brasilprev.Avaliacao.Services.PedidosService;
import br.com.brasilprev.Avaliacao.model.Categorias;
import br.com.brasilprev.Avaliacao.model.Pedidos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("brasilPrevContextPatternSecured/pedido")
@Api(value = "Pedido Controller", description = "Pedidos Controller .")
public class PedidoController {
	@Autowired
	private PedidosService pedidoService;
	
	@ApiOperation(value = "Retorna uma lista com todos os pedidos")
	@RequestMapping(value = "/getPedidos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	public ResponseEntity<List<Pedidos>> findAllCategoria() {
		return pedidoService.findAllPedidos();
		
	}
	
	@ApiOperation(value = "Retorna um Cliente pelo ID")
	@RequestMapping(value = "/getPedido{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})

	public ResponseEntity<Pedidos> findCategoriaById(@PathVariable(value = "id") long id) {

		return pedidoService.findOnePedido(id);
		
	}
	
	@ApiOperation(value = "Salvar ou atualizar um Pedido", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/savePedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<Pedidos> Post(@Valid @RequestBody Pedidos pedido) {
		return pedidoService.savePedido(pedido);
	}
	
	@ApiOperation(value = "Esse metodo apaga de forma lógica do banco de dados um pedido", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/deletePedido", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<String> delete(@Valid @RequestBody Pedidos pedido) {
		return pedidoService.deletePedido(pedido);
	}
	
	@ApiOperation(value = "Esse metodo atualiza uma pedido", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/updatePedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<Pedidos> atualiza(@Valid @RequestBody Pedidos pedido) {

		return pedidoService.atualizaPedido(pedido);
	}

}

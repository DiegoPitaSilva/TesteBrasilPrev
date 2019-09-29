package br.com.brasilprev.Avaliacao.controller;

import java.sql.SQLException;
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

import br.com.brasilprev.Avaliacao.Services.ClientesService;
import br.com.brasilprev.Avaliacao.model.Categorias;
import br.com.brasilprev.Avaliacao.model.Clientes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("brasilPrevContextPatternSecured/clientes")
@Api(value = "Cliente Controller", description = "Cliente Controller .")
public class ClientesController {

	@Autowired
	private ClientesService clienteService;

	@ApiOperation(value = "Retorna uma lista com os clientes")
	@RequestMapping(value = "/getClientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	public ResponseEntity<List<Clientes>> findAllCategoria() {
		return clienteService.findAllCliente();

	}

	@ApiOperation(value = "Retorna um Cliente pelo ID")
	@RequestMapping(value = "/getCliente/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<Clientes> findCategoriaById(@PathVariable(value = "id") long id) {
		
		return clienteService.findOneCliente(id);

	}

	@ApiOperation(value = "Salvar ou atualizar  um Cliente")
	@RequestMapping(value = "/saveCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})

	public ResponseEntity<Clientes> save(@Valid @RequestBody Clientes clientes) {
		return clienteService.saveCliente(clientes);
	}
	
	@ApiOperation(value = "Esse metodo apaga de forma lógica un cliente do banco de dados", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/deleteCliente", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<String> delete(@Valid @RequestBody Clientes cliente) {
		return clienteService.deleteCliente(cliente);
	}
	
	@ApiOperation(value = "Esse metodo atualiza um cliente ", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/updateCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<Clientes> atualiza(@Valid @RequestBody Clientes categoria) throws SQLException {

		return clienteService.atualizaClientes(categoria);
	}
	
}

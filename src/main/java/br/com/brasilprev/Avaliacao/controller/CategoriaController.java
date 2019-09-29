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

import br.com.brasilprev.Avaliacao.Services.CategoriaService;
import br.com.brasilprev.Avaliacao.model.Categorias;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("brasilPrevContextPatternSecured/categoria")
@Api(value = "Categoria Controller", description = "Categoria Controller .")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@ApiOperation(value = "Retorna uma lista com as categorias")
	@RequestMapping(value = "/getCategorias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	public ResponseEntity<List<Categorias>> findAllCategoria() {
		return categoriaService.findCategoria();
		
	}
	
	@ApiOperation(value = "Retorna uma categoria pelo ID")
	@RequestMapping(value = "/getCategoria/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})

	public ResponseEntity<Categorias> findCategoriaById(@PathVariable(value = "id") long id) {

		// return categoriaService.get(id);
		return categoriaService.findOneCategoria(id);
	}
	
	@ApiOperation(value = "Salvar ou atualizar uma Categoria " ,notes="DEIXE SEMPRE a dataexclusão  como 'null' senão o mesmo não exibira na consulta")
	@RequestMapping(value = "/saveCategoria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado" ), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<String> Post(@Valid @RequestBody Categorias categoria) {
		return categoriaService.saveCategoria(categoria);
	}
	
	@ApiOperation(value = "Esse metodo apaga de forma lógica do banco de dados", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/deleteCategoria", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<Categorias> delete(@Valid @RequestBody Categorias categoria) {

		return categoriaService.deleteCategoria(categoria);
	}



	@ApiOperation(value = "Esse metodo atualiza uma categoria", notes = "Atenção DEIXE SEMPRE O VALOR dataExclusão como ->'null'")
	@RequestMapping(value = "/updateCategoria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso na operação"), @ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 403, message = "Negado"), @ApiResponse(code = 404, message = "Não achado"),
			@ApiResponse(code = 500, message = "Falha é necessário contactar o administrador do sistema")})
	
	public ResponseEntity<Categorias> atualiza(@Valid @RequestBody Categorias categoria) {

		return categoriaService.atualizaCategoria(categoria);
	}

}

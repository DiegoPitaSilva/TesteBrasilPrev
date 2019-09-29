package br.com.brasilprev.Avaliacao.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.brasilprev.Avaliacao.exceptions.CategoriaNotFoundException;
import br.com.brasilprev.Avaliacao.model.Categorias;

public interface CategoriaService {
	
	ResponseEntity<List<Categorias>> findCategoria();
	
	ResponseEntity<String> saveCategoria(Categorias u);
	
	ResponseEntity<Categorias> deleteCategoria(Categorias id) throws CategoriaNotFoundException;

	ResponseEntity<Categorias> findOneCategoria(Long id);
	
	ResponseEntity<Categorias> atualizaCategoria(Categorias cat);
}

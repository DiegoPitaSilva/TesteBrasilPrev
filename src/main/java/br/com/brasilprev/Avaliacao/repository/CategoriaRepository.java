package br.com.brasilprev.Avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.brasilprev.Avaliacao.model.Categorias;

public interface CategoriaRepository extends JpaRepository<Categorias, Long> {
	
	@Query("SELECT categoria  from Categorias as categoria WHERE categoria.dataExclusao is  null ")
	List<Categorias> findAllCategoria();

}

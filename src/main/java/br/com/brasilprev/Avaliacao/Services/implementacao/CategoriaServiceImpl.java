package br.com.brasilprev.Avaliacao.Services.implementacao;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.brasilprev.Avaliacao.Services.AbstractService;
import br.com.brasilprev.Avaliacao.Services.CategoriaService;
import br.com.brasilprev.Avaliacao.exceptions.CategoriaNotFoundException;
import br.com.brasilprev.Avaliacao.exceptions.CategoriaServiceException;
import br.com.brasilprev.Avaliacao.exceptions.CategoriaServiceValidationException;
import br.com.brasilprev.Avaliacao.model.Categorias;
import br.com.brasilprev.Avaliacao.repository.CategoriaRepository;
import br.com.brasilprev.Avaliacao.utils.ConstraintsValue;

@Service
public class CategoriaServiceImpl extends AbstractService<Categorias, Long> implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	protected JpaRepository<Categorias, Long> getRepository() {
		// TODO Auto-generated method stub
		return categoriaRepository;
	}
	
	@Override
	public ResponseEntity<List<Categorias>> findCategoria() {
		 List<Categorias> listCategorias = categoriaRepository.findAllCategoria();
		 
		 if (listCategorias != null && listCategorias.size()>0){

		
		return new ResponseEntity<List<Categorias>>(listCategorias,HttpStatus.OK);
		 }else{
			 
			 throw new CategoriaNotFoundException("não existe categorias cadastradas");
		 }
		 
}
	
	@Override
	public ResponseEntity<String> saveCategoria(Categorias u) {

		try {
			save(u);
   
			return new ResponseEntity<String>(ConstraintsValue.jsonReponseOk,HttpStatus.OK) ;
			
		} catch (CategoriaServiceException e) {

			throw new CategoriaServiceException("Error interno no servidor , contacte o administrador do sistema");

		}catch(CategoriaServiceValidationException cat){
			throw new CategoriaServiceValidationException("error");
			
		}
		//return new ResponseEntity<String>(ConstraintsValue.jsonReponseOk,HttpStatus.BAD_GATEWAY) ;

	}

	@Override
	public ResponseEntity<Categorias> deleteCategoria(Categorias categoria) {
		
		if (categoria != null) {
			Date date = new Date();
			date.getTime();
			categoria.setDataExclusao(date);
			
			try {
				
				save(categoria);
				return  new ResponseEntity<Categorias>(categoria,HttpStatus.OK);
				
			} catch (CategoriaNotFoundException exception) {
				
				throw new CategoriaNotFoundException("Não foi achada nenhuma categoria");
				
			}catch(CategoriaServiceException exception){
				
				throw new CategoriaServiceException("Error interno no servidor , contacte o administrador do sistema");
			}catch(CategoriaServiceValidationException csve){
			
				throw new CategoriaServiceException("deu ruim");
			}
			
		} else {
			
			return  new ResponseEntity<Categorias>(categoria,HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Categorias> findOneCategoria(Long id) {
		
		Categorias cat = get(id);
		if (cat !=null){

		return new ResponseEntity<Categorias>(cat,HttpStatus.OK);
		
		}else{
			
			throw new CategoriaNotFoundException("NOT FOUND");
		}
	}

	@Override
	public ResponseEntity<Categorias> atualizaCategoria(Categorias cat) {

		try {
			update(cat);
			return new  ResponseEntity<Categorias> (cat,HttpStatus.OK);
			
		} catch (CategoriaServiceException e) {

			throw new CategoriaServiceException("Error interno no servidor , contacte o administrador do sistema");

		}catch(CategoriaServiceValidationException error){
			throw new CategoriaServiceValidationException("error");
			
		}

	}
	
}

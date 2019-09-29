package br.com.brasilprev.Avaliacao.errorControls;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.brasilprev.Avaliacao.exceptions.CategoriaNotFoundException;
import br.com.brasilprev.Avaliacao.exceptions.CategoriaServiceException;
import br.com.brasilprev.Avaliacao.exceptions.CategoriaServiceValidationException;
import br.com.brasilprev.Avaliacao.utils.ConstraintsValue;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class PedidoServiceErrorAdvice {

	
	
	  
	  @ExceptionHandler({RuntimeException.class})
	    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
	        return error(ConstraintsValue.INTERNAL_SERVER_ERROR, e);
	    }
	  
	   @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ExceptionHandler({CategoriaNotFoundException.class, SQLException.class, NullPointerException.class})
	    public ResponseEntity<String> handleNotFoundException(CategoriaNotFoundException e) {
	        return error(ConstraintsValue.NOT_FOUND, e);
	    }
	    @ExceptionHandler({CategoriaServiceException.class})
	    public ResponseEntity<String> handleDogsServiceException(CategoriaServiceException e){
	        return error(ConstraintsValue.INTERNAL_SERVER_ERROR, e);
	    }
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler({CategoriaServiceValidationException.class})
	    public void handle(CategoriaServiceValidationException e) {
	    	
	    	
	    }
	    
	    
	    private ResponseEntity<String> error(HttpStatus status, Exception e) {
	        log.error("Exception : ", e);
	        return ResponseEntity.status(status).body(e.getMessage());
	    }
	
	    
	    
	
	
}

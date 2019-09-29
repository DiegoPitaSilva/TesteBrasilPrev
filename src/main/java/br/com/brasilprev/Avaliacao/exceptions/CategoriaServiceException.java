package br.com.brasilprev.Avaliacao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CategoriaServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7446560252388371804L;
    
	
	public CategoriaServiceException(String message) {
        super(message);
    }

}

package br.com.brasilprev.Avaliacao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProdutosNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2524617151000833250L;

	 public ProdutosNotFoundException(String message) {
	        super(message);
	    }


}

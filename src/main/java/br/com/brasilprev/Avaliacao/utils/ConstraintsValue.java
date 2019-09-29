package br.com.brasilprev.Avaliacao.utils;

import org.springframework.http.HttpStatus;

public class ConstraintsValue {

   
    public static final HttpStatus INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;
	  public static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
	public static final String jsonReponseError = "{\"response\":fail}";
	public static final String jsonReponseOk = "{\"response\":ok}";
}

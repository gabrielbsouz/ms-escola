package br.com.rest.api.spring.msescola.controllers;

import br.com.rest.api.spring.msescola.errors.Error;
import br.com.rest.api.spring.msescola.exceptions.IdFormatoInvalidoException;
import br.com.rest.api.spring.msescola.exceptions.ProfessorNaoEncontradoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProfessorNaoEncontradoException.class)
    public final ResponseEntity<Error> handleProfessorNaoEncontradoException(ProfessorNaoEncontradoException ex) {

        Error error = new Error(404, "Not Found", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdFormatoInvalidoException.class)
    public final ResponseEntity<Error> handleIdFormatoInvalidoException(IdFormatoInvalidoException ex) {

        Error error = new Error(400, "Bad request", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Error error = new Error(400, "Bad Request", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

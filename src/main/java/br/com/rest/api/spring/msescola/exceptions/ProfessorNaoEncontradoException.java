package br.com.rest.api.spring.msescola.exceptions;

public class ProfessorNaoEncontradoException extends RuntimeException {

    public ProfessorNaoEncontradoException(String exception) {
        super(exception);
    }
}

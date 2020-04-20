package br.com.rest.api.spring.msescola.services;

import br.com.rest.api.spring.msescola.models.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> listaDeJogadores();

    Teacher buscarProfessor(String id);
}

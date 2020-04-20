package br.com.rest.api.spring.msescola.services.impl;

import br.com.rest.api.spring.msescola.exceptions.IdFormatoInvalidoException;
import br.com.rest.api.spring.msescola.exceptions.ProfessorNaoEncontradoException;
import br.com.rest.api.spring.msescola.models.Teacher;
import br.com.rest.api.spring.msescola.repositories.TeacherRepository;
import br.com.rest.api.spring.msescola.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> listaDeJogadores() {

        return teacherRepository.findAll();
    }

    @Override
    public Teacher buscarProfessor(String id) {

        if (id.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")) {

            return teacherRepository.findById(id)
                    .orElseThrow(() -> new ProfessorNaoEncontradoException("Professor com id:" + id + " não encontrado!"));
        } else {

            throw new IdFormatoInvalidoException("Id: " + id + " com formato inválido!");
        }
    }
}

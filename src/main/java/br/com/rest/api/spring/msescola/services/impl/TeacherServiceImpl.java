package br.com.rest.api.spring.msescola.services.impl;

import br.com.rest.api.spring.msescola.exceptions.ProfessorNaoEncontradoException;
import br.com.rest.api.spring.msescola.models.Teacher;
import br.com.rest.api.spring.msescola.repositories.TeacherRepository;
import br.com.rest.api.spring.msescola.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher buscarProfessor(String id) {

        return teacherRepository.findById(id)
                .orElseThrow(() -> new ProfessorNaoEncontradoException("Professor com id:" + id + " não encontrado!"));
    }
}

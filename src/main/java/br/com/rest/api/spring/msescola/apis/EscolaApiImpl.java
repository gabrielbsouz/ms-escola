package br.com.rest.api.spring.msescola.apis;

import br.com.rest.api.spring.msescola.mappers.TeacherMapper;
import br.com.rest.api.spring.msescola.models.Teacher;
import br.com.rest.api.spring.msescola.services.impl.TeacherServiceImpl;
import io.swagger.api.RestApi;
import io.swagger.model.DetalheProfessor;
import io.swagger.model.Professor;
import io.swagger.model.ProfessorArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/api/escola")
public class EscolaApiImpl implements RestApi {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @GetMapping(value = "/v1/professores")
    public ResponseEntity<ProfessorArray> listarProfessores() {

        List<Teacher> teachers = teacherServiceImpl.listaDeProfessores();

        List<Professor> professores = teacherMapper.teachersToProfessores(teachers);

        ProfessorArray professorArray = (ProfessorArray) professores;

        return ResponseEntity.ok(professorArray);
    }


    @GetMapping(value = "/v1/professores/{id}")
    public ResponseEntity<DetalheProfessor> consultarProfessor(@PathVariable String id) {

        Teacher teacher = teacherServiceImpl.buscarProfessor(id);

        DetalheProfessor detalheProfessor = teacherMapper.teacherToDetalheProfessor(teacher);

        return ResponseEntity.ok(detalheProfessor);
    }
}
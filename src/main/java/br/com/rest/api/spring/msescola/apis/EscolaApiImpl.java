package br.com.rest.api.spring.msescola.apis;

import br.com.rest.api.spring.msescola.mappers.TeacherMapper;
import br.com.rest.api.spring.msescola.models.Teacher;
import br.com.rest.api.spring.msescola.services.impl.TeacherServiceImpl;
import io.swagger.api.RestApi;
import io.swagger.model.DetalheProfessor;
import io.swagger.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/escola")
public class EscolaApiImpl implements RestApi {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @GetMapping(value = "/v1/professores")
    public ResponseEntity<List<Professor>> listarProfessores() {

        List<Teacher> teachers = teacherServiceImpl.listaDeJogadores();

        List<Professor> professores = teacherMapper.teachersToProfessores(teachers);

        return ResponseEntity.ok(professores);
    }

    @GetMapping(value = "/v1/professores/{id}")
    public ResponseEntity<DetalheProfessor> consultarProfessor(@PathVariable String id) {

        Teacher teacher = teacherServiceImpl.buscarProfessor(id);

        DetalheProfessor detalheProfessor = teacherMapper.teacherToDetalheProfessor(teacher);

        return ResponseEntity.ok(detalheProfessor);
    }
}

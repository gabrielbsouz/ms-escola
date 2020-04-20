package br.com.rest.api.spring.msescola.mappers;

import br.com.rest.api.spring.msescola.models.Discipline;
import br.com.rest.api.spring.msescola.models.Teacher;
import io.swagger.model.DetalheProfessor;
import io.swagger.model.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mappings({
            @Mapping(target="nome", source="teacher.name"),
            @Mapping(target="cpf", source="teacher.cpf"),
            @Mapping(target="dataNascimento", source="teacher.birthDate"),
            @Mapping(target="disciplinas", source="teacher.disciplines")
    })
    DetalheProfessor teacherToDetalheProfessor(Teacher teacher);

    @Mappings({
            @Mapping(target="name", source="detalheProfessor.nome"),
            @Mapping(target="cpf", source="detalheProfessor.cpf"),
            @Mapping(target="birthDate", source="detalheProfessor.dataNascimento"),
            @Mapping(target="disciplines", source="detalheProfessor.disciplinas")
    })
    Teacher detalheProfessorToTeacher(DetalheProfessor detalheProfessor);

    @Mappings({
            @Mapping(target="nome", source="discipline.name"),
            @Mapping(target="turno", source="discipline.shift")
    })
    Disciplina disciplineToDisciplina(Discipline discipline);

    @Mappings({
            @Mapping(target="name", source="disciplina.nome"),
            @Mapping(target="shift", source="disciplina.turno")
    })
    Discipline disciplinaToDiscipline(Disciplina disciplina);
}

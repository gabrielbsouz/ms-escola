package br.com.rest.api.spring.msescola.repositories;

import br.com.rest.api.spring.msescola.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}

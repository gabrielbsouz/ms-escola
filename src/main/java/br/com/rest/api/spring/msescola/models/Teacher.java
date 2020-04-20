package br.com.rest.api.spring.msescola.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Teacher {

    @Id
    private String id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Discipline> disciplines;
}

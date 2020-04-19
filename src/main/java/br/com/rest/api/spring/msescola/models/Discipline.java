package br.com.rest.api.spring.msescola.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Discipline {

    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Shift shift;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;
}

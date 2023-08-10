package com.example.ToDo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_lembretes", schema = "public")
public class Lembretes {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter @Setter
    private String recado;

    @ManyToOne
    //@JoinColumn(name = "tb_pessoas", nullable = false)
    @Getter @Setter
    private Pessoa pessoa;

}

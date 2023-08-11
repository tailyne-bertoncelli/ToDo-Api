package com.example.ToDo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_lembretes", schema = "public")
@NoArgsConstructor
public class Lembretes {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter @Setter
    private String recado;

    @ManyToOne
    @JoinColumn(name = "pessoa", nullable = false)
    @Getter @Setter
    private Pessoa pessoa;

}

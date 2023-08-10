package com.example.ToDo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pessoas", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String email;

}

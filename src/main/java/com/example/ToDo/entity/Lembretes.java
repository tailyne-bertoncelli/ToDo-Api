package com.example.ToDo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
    @JoinColumn(name = "pessoa_id", nullable = false)
    @Getter @Setter
    private Pessoa pessoa;

    public Lembretes(Long id, String recado, Pessoa pessoa) {
        this.id = id;
        this.recado = recado;
        this.pessoa = pessoa;
    }
}

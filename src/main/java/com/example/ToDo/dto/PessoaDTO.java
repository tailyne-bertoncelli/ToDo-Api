package com.example.ToDo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
        @Getter @Setter
        Long id;
        @Getter @Setter
        String nome;
        @Getter @Setter
        String email;


}

package com.example.ToDo.dto;

import com.example.ToDo.entity.Lembretes;
import com.example.ToDo.entity.Pessoa;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class LembreteDTO{

        @Getter @Setter
        private String recado;
        @Getter @Setter
        private Pessoa pessoa;

//        public LembreteDTO(String recado, Pessoa pessoa) {
//                this.recado = recado;
//                this.pessoa = pessoa;
//        }

        public LembreteDTO(Lembretes entity){
                recado = entity.getRecado();
                pessoa = entity.getPessoa();
        }
}
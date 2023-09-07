package com.example.ToDo.dto;


import com.example.ToDo.entity.Lembretes;
import com.example.ToDo.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class LembreteDTO{
        private Long id;
        @Getter @Setter
        private String recado;
        @Getter @Setter
        private Long pessoa_id;

        public LembreteDTO(Lembretes lembretes) {
                this.id = lembretes.getId();
                this.recado = lembretes.getRecado();
                this.pessoa_id = lembretes.getPessoa().getId();
        }
}
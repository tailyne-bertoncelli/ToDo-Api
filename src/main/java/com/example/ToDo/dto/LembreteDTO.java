package com.example.ToDo.dto;


import com.example.ToDo.entity.Pessoa;
import lombok.Getter;
import lombok.Setter;

public class LembreteDTO{

        @Getter @Setter
        private String recado;
        @Getter @Setter
        private Long pessoa_id;

}
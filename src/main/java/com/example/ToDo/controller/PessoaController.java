package com.example.ToDo.controller;

import com.example.ToDo.dto.PessoaDTO;
import com.example.ToDo.service.PessoaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping@Transactional
    public ResponseEntity<?> cadastra(@RequestBody PessoaDTO pessoaDTO){
        try {
            this.pessoaService.cadastra(pessoaDTO);
            return ResponseEntity.ok(pessoaDTO);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

package com.example.ToDo.controller;

import com.example.ToDo.dto.PessoaDTO;
import com.example.ToDo.entity.Pessoa;
import com.example.ToDo.service.PessoaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<?> buscaPeloId(@RequestBody PessoaDTO pessoaDTO){
        try {
            this.pessoaService.findById(pessoaDTO.id());
            return ResponseEntity.ok(pessoaDTO);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}") @Transactional
    public ResponseEntity<?> altera(@RequestBody Pessoa pessoa, @PathVariable Long id){
        Pessoa pessoa1 = pessoaService.findById(id);
        if (pessoa.getNome() != null){
            pessoa1.setNome(pessoa.getNome());
        }
        if (pessoa.getEmail() != null){
            pessoa1.setEmail(pessoa.getEmail());
        }

        try {
            this.pessoaService.alterar(pessoa1);
            return ResponseEntity.ok(pessoa1);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleta(@PathVariable Long id){
        Pessoa pessoa = pessoaService.findById(id);

        try{
            this.pessoaService.deleta(pessoa);
            return ResponseEntity.ok("Pessoa deletada com sucesso!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

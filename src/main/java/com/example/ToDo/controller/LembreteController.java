package com.example.ToDo.controller;

import com.example.ToDo.dto.LembreteDTO;
import com.example.ToDo.service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lembrete")
public class LembreteController {

    @Autowired
    private LembreteService lembreteService;

    @PostMapping
    public ResponseEntity cadastra(LembreteDTO lembreteDTO){
        try {
            this.lembreteService.cadastra(lembreteDTO);
            return ResponseEntity.ok("Registro cadastrado com sucesso!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaPeloId(@PathVariable Long id){
        try {
            this.lembreteService.buscaPeloId(id);
            return ResponseEntity.ok(this.lembreteService.buscaPeloId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}

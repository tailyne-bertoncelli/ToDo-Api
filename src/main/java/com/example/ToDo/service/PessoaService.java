package com.example.ToDo.service;

import com.example.ToDo.dto.PessoaDTO;
import com.example.ToDo.entity.Pessoa;
import com.example.ToDo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public ResponseEntity cadastra(PessoaDTO pessoaDTO) {
        if (pessoaDTO.email() == null || pessoaDTO.email().isEmpty()){
            throw new RuntimeException("Email não pode ser nulo ou vazio!");
        }
        if (pessoaDTO.nome() == null || pessoaDTO.nome().isEmpty()){
            throw new RuntimeException("Nome não pode ser nulo ou vazio!");
        }

        this.pessoaRepository.save(new Pessoa(null, pessoaDTO.nome(), pessoaDTO.email()));
        return ResponseEntity.ok(pessoaDTO);
    }
}

package com.example.ToDo.service;

import com.example.ToDo.dto.PessoaDTO;
import com.example.ToDo.entity.Pessoa;
import com.example.ToDo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Pessoa findById(Long id) {
        Optional<Pessoa> pessoa = this.pessoaRepository.findById(id);
        return pessoa.orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
    }


    public void alterar(Pessoa pessoa) {
        if (!pessoaRepository.existsById(pessoa.getId())){
            throw new RuntimeException("Pessoa informada não existe!");
        }
        this.pessoaRepository.save(pessoa);
    }

    public void deleta(Pessoa pessoa) {
        this.pessoaRepository.delete(pessoa);
    }
}

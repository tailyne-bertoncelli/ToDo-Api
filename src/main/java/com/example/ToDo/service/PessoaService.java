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

    public PessoaDTO cadastra(PessoaDTO pessoaDTO) {
        if (pessoaDTO.getEmail() == null || pessoaDTO.getEmail().isEmpty()){
            throw new RuntimeException("Email não pode ser nulo ou vazio!");
        }
        if (pessoaDTO.getNome() == null || pessoaDTO.getNome().isEmpty()){
            throw new RuntimeException("Nome não pode ser nulo ou vazio!");
        }
        Pessoa pessoa = new Pessoa(null, pessoaDTO.getNome(), pessoaDTO.getEmail());
        this.pessoaRepository.save(pessoa);
        return pessoaDTO;
    }

    public Pessoa findById(Long id) {
        Pessoa pessoa = this.pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
        return pessoa;
    }


    public PessoaDTO alterar(Pessoa pessoa) {
        if (!pessoaRepository.existsById(pessoa.getId())){
            throw new RuntimeException("Pessoa informada não existe!");
        }
        this.pessoaRepository.save(pessoa);
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
        return pessoaDTO;
    }

    public void deleta(Pessoa pessoa) {
        this.pessoaRepository.delete(pessoa);
    }
}

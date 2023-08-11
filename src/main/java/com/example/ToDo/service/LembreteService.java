package com.example.ToDo.service;

import com.example.ToDo.dto.LembreteDTO;
import com.example.ToDo.entity.Lembretes;
import com.example.ToDo.entity.Pessoa;
import com.example.ToDo.repository.LembreteRepository;
import com.example.ToDo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository lembreteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public void cadastra(LembreteDTO lembreteDTO) {
        if (!pessoaRepository.existsById(lembreteDTO.getPessoa_id())){
            throw new RuntimeException("Pessoa informada não existe!");
        }
        this.lembreteRepository.save(new Lembretes(null, lembreteDTO.getRecado(), lembreteDTO.getPessoa_id()));
    }


    public Lembretes buscaPeloId(Long id) {
        Optional<Lembretes> lembrete = this.lembreteRepository.findById(id);
        return lembrete.orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
    }

}

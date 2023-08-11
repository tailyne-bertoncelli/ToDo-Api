package com.example.ToDo.service;

import com.example.ToDo.dto.LembreteDTO;
import com.example.ToDo.entity.Lembretes;
import com.example.ToDo.repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository lembreteRepository;
    public LembreteDTO cadastra(LembreteDTO lembreteDTO) {
        Lembretes lembretes = new Lembretes();
        salvaLembrete(lembreteDTO, lembretes);
        lembretes = this.lembreteRepository.save(lembretes);
        return new LembreteDTO(lembretes);
    }

    private void salvaLembrete(LembreteDTO lembreteDTO, Lembretes lembretes){
        lembretes.setPessoa(lembreteDTO.getPessoa());
        lembretes.setRecado(lembreteDTO.getRecado());
    }

    public Lembretes buscaPeloId(Long id) {
        Optional<Lembretes> lembrete = this.lembreteRepository.findById(id);
        return lembrete.orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
    }

}

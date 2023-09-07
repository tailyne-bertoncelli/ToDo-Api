package com.example.ToDo.service;

import com.example.ToDo.dto.LembreteDTO;
import com.example.ToDo.entity.Lembretes;
import com.example.ToDo.entity.Pessoa;
import com.example.ToDo.repository.LembreteRepository;
import com.example.ToDo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository lembreteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public LembreteDTO cadastra(LembreteDTO lembreteDTO) {
        Pessoa pessoa = pessoaRepository.findById(lembreteDTO.getPessoa_id())
                .orElseThrow(()-> new RuntimeException("Pessoa informada não existe!"));
        Lembretes lembretes = new Lembretes(null, lembreteDTO.getRecado(), pessoa);
        lembreteRepository.save(lembretes);
        LembreteDTO lembreteDTO1 = new LembreteDTO(lembretes);
        return lembreteDTO1;
    }


    public Lembretes buscaPeloId(Long id) {
        Lembretes lembrete = this.lembreteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
        return lembrete;
    }


    public List<Lembretes> buscaPeloNome(String nome) {
        List<Lembretes> lembretesList = this.lembreteRepository.buscaLembretesPeloNome(nome);
        if (lembretesList.isEmpty()){
            throw new RuntimeException("Essa pessoa não possui nenhum lembrete ou não foi cadastrada!");
        }
        return lembretesList;
    }
}

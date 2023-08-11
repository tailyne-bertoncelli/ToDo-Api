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

    public void cadastra(LembreteDTO lembreteDTO) {
        if (!pessoaRepository.existsById(lembreteDTO.getPessoa_id())){
            throw new RuntimeException("Pessoa informada não existe!");
        }
        var pessoa = pessoaRepository.getReferenceById(lembreteDTO.getPessoa_id());
        lembreteRepository.save(new Lembretes(null, lembreteDTO.getRecado(), pessoa));
    }


    public Lembretes buscaPeloId(Long id) {
        Optional<Lembretes> lembrete = this.lembreteRepository.findById(id);
        return lembrete.orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
    }


    public List<Lembretes> buscaPeloNome(String nome) {
        List<Lembretes> lembretesList = this.lembreteRepository.buscaLembretesPeloNome(nome);
        if (lembretesList.isEmpty()){
            throw new RuntimeException("Essa pessoa não possui nenhum lembrete ou não foi cadastrada!");
        }
        return lembretesList;
    }
}

package com.example.ToDo;

import com.example.ToDo.dto.LembreteDTO;
import com.example.ToDo.entity.Lembretes;
import com.example.ToDo.entity.Pessoa;
import com.example.ToDo.repository.LembreteRepository;
import com.example.ToDo.service.LembreteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class TestLembretes {
    @MockBean
    private LembreteRepository lembreteRepository;

    @Autowired
    private LembreteService lembreteService;

    @BeforeEach
    void obj(){
        Pessoa pessoa = new Pessoa(1L, "Tailyne", "tailyne@tr1.com.br");
        Lembretes lembretes = new Lembretes(1L, "Entregar atividade", pessoa);
        Pessoa pessoa2 = new Pessoa(1L, "Tailyne", "tailyne@tr1.com.br");
        Optional<Lembretes> lembretes2 = Optional.of(new Lembretes(1L, "Entregar atividade", pessoa2));
        Long id = 1L;
        Mockito.when(lembreteRepository.save(lembretes)).thenReturn(lembretes);
        Mockito.when(lembreteRepository.findById(1L)).thenReturn(lembretes2);
    }


    @Test
    public void findById(){
        Lembretes lembrete2 = lembreteService.buscaPeloId(1L);
        Long id = lembrete2.getId().longValue();
        Assert.assertEquals(1L, id, 0);
    }

    @Test
    public void insert(){
        LembreteDTO lembreteDTO = new LembreteDTO(1L, "Entregar tarefa de hoje", 1L);
        var lembrete = lembreteService.cadastra(lembreteDTO);
        Assert.assertEquals(lembreteDTO, lembrete);
    }
}

package com.example.ToDo.repository;

import com.example.ToDo.entity.Lembretes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LembreteRepository extends JpaRepository<Lembretes, Long> {
    @Query("SELECT lembrete FROM Lembretes lembrete INNER JOIN Pessoa pessoa ON lembrete.pessoa = pessoa WHERE pessoa.nome LIKE %:nome%")
    List<Lembretes> buscaLembretesPeloNome (@Param("nome") String nome);
}

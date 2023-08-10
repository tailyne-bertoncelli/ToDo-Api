package com.example.ToDo.repository;

import com.example.ToDo.entity.Lembretes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LembreteRepository extends JpaRepository<Lembretes, Long> {
}

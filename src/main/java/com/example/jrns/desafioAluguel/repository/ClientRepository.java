package com.example.jrns.desafioAluguel.repository;

import com.example.jrns.desafioAluguel.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

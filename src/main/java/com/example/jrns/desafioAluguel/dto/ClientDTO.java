package com.example.jrns.desafioAluguel.dto;


import com.example.jrns.desafioAluguel.entity.Car;
import com.example.jrns.desafioAluguel.entity.Client;

import java.time.LocalDate;

public record ClientDTO (Long id, String nome, String cpf,
         LocalDate dataNascimento,
         LocalDate dataCadastro,
        LocalDate alteracaoCliente) {

    public ClientDTO (Client client) {
        this(client.getId(),client.getNome(),client.getCpf(),client.getDataNascimento(),client.getDataCadastro(),client.getAlteracaoCliente());
    }
}

package com.example.jrns.desafioAluguel.dto;

import com.example.jrns.desafioAluguel.entity.Car;
import com.example.jrns.desafioAluguel.entity.Client;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cpf;
    private Car car;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private LocalDate alteracaoCliente;

    public ClientDTO(Client client) {
        id = client.getId();
        nome = client.getNome();
        cpf = client.getCpf();
        car = client.getCar();
        dataNascimento = client.getDataNascimento();
        dataCadastro = client.getDataCadastro();
        alteracaoCliente = client.getAlteracaoCliente();
    }

}

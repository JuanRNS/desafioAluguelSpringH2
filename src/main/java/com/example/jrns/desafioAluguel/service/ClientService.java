package com.example.jrns.desafioAluguel.service;

import com.example.jrns.desafioAluguel.dto.ClientDTO;
import com.example.jrns.desafioAluguel.entity.Client;
import com.example.jrns.desafioAluguel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Service
public class ClientService implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    @Autowired
    private ClientRepository clientRepository;

    public void cadastrarCliente(Client client) {
        clientRepository.save(client);
    }
    public Client buscarClientePorId(Long id) {
       return clientRepository.findById(id).get();
    }
    public void alterarCliente(Client client) {
        Client client1 = clientRepository.findById(client.getId()).get();
        alterar(client1, client);
        clientRepository.save(client1);
    }
    public void removerCliente(Long id) {
        clientRepository.deleteById(id);
    }
    public List<Client> listarClientes() {
        return clientRepository.findAll();
    }

    public void alterar (Client clientAnt, Client clientAtual) {
        clientAtual.setNome(clientAnt.getNome());
        clientAtual.setCpf(clientAnt.getCpf());
        clientAtual.setDataNascimento(clientAnt.getDataNascimento());
    }
    public Client retornoCliente(ClientDTO client) {
        return new Client(client.id(),client.nome(),client.nome(),client.dataNascimento(),client.dataCadastro(),client.alteracaoCliente());
    }

}

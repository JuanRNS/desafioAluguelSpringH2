package com.example.jrns.desafioAluguel.util;

import com.example.jrns.desafioAluguel.dto.ClientDTO;
import com.example.jrns.desafioAluguel.entity.Client;
import com.example.jrns.desafioAluguel.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<Client> clients = clientService.listarClientes();
        List<ClientDTO> dtos = clients.stream().map(ClientDTO::new).toList();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClientDTO client) {
        Client client1 = clientService.doDto(client);
        clientService.cadastrarCliente(client1);
        URI uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client1.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

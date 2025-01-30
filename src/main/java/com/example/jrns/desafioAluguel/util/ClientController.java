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
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        Client client = clientService.buscarClientePorId(id);
        return ResponseEntity.ok(new ClientDTO(client));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto) {
        Client client = clientService.retornoCliente(dto);
        client.setId(id);
        clientService.alterarCliente(client);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.removerCliente(id);
        return ResponseEntity.noContent().build();
    }


}

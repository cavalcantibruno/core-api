package com.core.api.controllers;

import com.core.domain.entities.Client;
import com.core.domain.repositories.ClientRepository;
import com.core.domain.services.CatalogClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientRepository clientRepository;
    private final CatalogClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> list() {
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return clientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Client create(@Valid @RequestBody Client client) {
        return clientService.create(client);
    }

    @PutMapping
    public ResponseEntity<Client> update(@Valid @RequestBody Client client) {
        if (!clientRepository.existsById(client.getId())) {
            return ResponseEntity.notFound().build();
        }
        client = clientRepository.save(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
           return ResponseEntity.notFound().build();
        }
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

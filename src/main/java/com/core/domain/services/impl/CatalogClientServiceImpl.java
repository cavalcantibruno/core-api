package com.core.domain.services.impl;

import com.core.domain.exception.DomainException;
import com.core.domain.entities.Client;
import com.core.domain.repositories.ClientRepository;
import com.core.domain.services.CatalogClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CatalogClientServiceImpl implements CatalogClientService {

    private final ClientRepository clientRepository;

    public Client search(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new DomainException("Cliente não encontrado"));
    }

    @Override
    public Client create(Client client) {
        boolean clientExists = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(emailExists -> !emailExists.equals(client));
        if(clientExists) {
            throw new DomainException("Já existe um cliente cadastrado com esse e-mail");
        }
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}

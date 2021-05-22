package com.core.domain.services;

import com.core.domain.entities.Client;
import org.springframework.stereotype.Component;

@Component
public interface CatalogClientService {
    Client create(Client client);
    void delete(Long id);
    Client search(Long id);
}

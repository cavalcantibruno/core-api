package com.core.domain.services.impl;

import com.core.domain.entities.Client;
import com.core.domain.entities.Delivery;
import com.core.domain.repositories.DeliveryRepository;
import com.core.domain.services.CatalogClientService;
import com.core.domain.services.CreateDeliveryService;
import com.core.domain.enums.StatusDelivery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Component
public class CreateDeliveryServiceImpl implements CreateDeliveryService {
    private final CatalogClientService catalogClientService;
    private final DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery create(Delivery delivery) {
        Client client = catalogClientService.search(delivery.getClient().getId());
        delivery.setClient(client);
        delivery.setStatusDelivery(StatusDelivery.PENDING);
        delivery.setDateOrder(OffsetDateTime.now());
        return deliveryRepository.save(delivery);
    }
}

package com.core.domain.services.impl;

import com.core.domain.entities.Delivery;
import com.core.domain.entities.Occurrences;
import com.core.domain.exception.DomainException;
import com.core.domain.exception.EntityNotFoundException;
import com.core.domain.repositories.DeliveryRepository;
import com.core.domain.services.RegisterOccurrencesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Component
public class RegisterOccurrencesServiceImpl implements RegisterOccurrencesService {

    private final DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public Occurrences register(Long id, String description) {
        Delivery delivery = searchDelivery(id);
        return delivery.addOccurrences(description);
    }

    public Delivery searchDelivery(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada"));
    }
}

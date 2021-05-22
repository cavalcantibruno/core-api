package com.core.domain.services.impl;

import com.core.domain.entities.Delivery;
import com.core.domain.enums.StatusDelivery;
import com.core.domain.exception.DomainException;
import com.core.domain.repositories.DeliveryRepository;
import com.core.domain.services.CheckoutService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Component
public class CheckoutServiceImpl implements CheckoutService {

    private final DeliveryRepository deliveryRepository;
    private final RegisterOccurrencesServiceImpl occurrencesService;

    @Transactional
    @Override
    public void checkout(Long id) {
        Delivery delivery = occurrencesService.searchDelivery(id);
        delivery.checkout();
        deliveryRepository.save(delivery);

    }
}

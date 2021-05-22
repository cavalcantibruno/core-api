package com.core.domain.services;

import com.core.domain.entities.Delivery;
import org.springframework.stereotype.Service;

@Service
public interface CreateDeliveryService {
    Delivery create(Delivery delivery);
}

package com.core.domain.services;

import com.core.domain.entities.Delivery;
import com.core.domain.entities.Occurrences;
import org.springframework.stereotype.Service;

@Service
public interface RegisterOccurrencesService {
    Occurrences register(Long id, String description);
    Delivery searchDelivery(Long id);
}

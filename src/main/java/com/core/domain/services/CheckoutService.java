package com.core.domain.services;

import org.springframework.stereotype.Service;

@Service
public interface CheckoutService {
    void checkout(Long id);
}

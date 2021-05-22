package com.core.api.controllers;

import com.core.api.assembler.DeliveryAssembler;
import com.core.api.model.request.DeliveryRequest;
import com.core.api.model.response.DeliveryResponse;
import com.core.domain.entities.Delivery;
import com.core.domain.repositories.DeliveryRepository;
import com.core.domain.services.CheckoutService;
import com.core.domain.services.CreateDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    private final DeliveryRepository deliveryRepository;
    private final CreateDeliveryService createDeliveryService;
    private final CheckoutService checkoutService;
    private final DeliveryAssembler deliveryAssembler;

    @GetMapping
    public List<DeliveryResponse> list() {
        return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponse> search(@PathVariable Long id) {
        return deliveryRepository.findById(id)
                .map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryResponse create(@Valid @RequestBody DeliveryRequest deliveryRequest) {
        Delivery newDelivery = deliveryAssembler.toEntity(deliveryRequest);
        return deliveryAssembler.toModel(createDeliveryService.create(newDelivery));
    }

    @PutMapping("/{id}/checkout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void checkout(@PathVariable Long id) {
        checkoutService.checkout(id);
    }
}

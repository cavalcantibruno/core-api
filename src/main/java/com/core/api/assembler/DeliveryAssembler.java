package com.core.api.assembler;

import com.core.api.model.request.DeliveryRequest;
import com.core.api.model.response.DeliveryResponse;
import com.core.domain.entities.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryAssembler {
    private final ModelMapper mapper;

    public DeliveryResponse toModel(Delivery delivery) {
        return mapper.map(delivery, DeliveryResponse.class);
    }

    public List<DeliveryResponse> toCollectionModel(List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryRequest deliveryRequest) {
        return mapper.map(deliveryRequest, Delivery.class);
    }
}

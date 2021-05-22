package com.core.api.model.response;

import com.core.domain.enums.StatusDelivery;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryResponse {
    private Long id;
    private ClientResponse client;
    private RecipientResponse recipient;
    private BigDecimal rate;
    private StatusDelivery status;
    private OffsetDateTime dateOrder;
    private OffsetDateTime dateDelivered;
}

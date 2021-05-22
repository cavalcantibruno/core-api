package com.core.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryRequest {

    @Valid
    @NotNull
    private ClientIdRequest client;
    @Valid
    @NotNull
    private RecipientRequest recipient;
    @NotNull
    private BigDecimal rate;
}

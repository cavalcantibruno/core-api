package com.core.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientIdRequest {
    @NotNull
    private Long id;
}

package com.core.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurrencesRequest {
    @NotBlank
    private String description;
}

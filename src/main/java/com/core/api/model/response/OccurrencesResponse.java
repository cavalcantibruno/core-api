package com.core.api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OccurrencesResponse {
    private Long id;
    private String description;
    private OffsetDateTime dateRegistration;
}

package com.core.api.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientRequest {
    private String name;
    private String street;
    private String number;
    private String complement;
    private String district;
}

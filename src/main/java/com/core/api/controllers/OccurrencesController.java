package com.core.api.controllers;

import com.core.api.assembler.OccurrencesAssembler;
import com.core.api.model.request.OccurrencesRequest;
import com.core.api.model.response.OccurrencesResponse;
import com.core.domain.entities.Delivery;
import com.core.domain.entities.Occurrences;
import com.core.domain.services.RegisterOccurrencesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery/{id}/occurrences")
public class OccurrencesController {
    private final RegisterOccurrencesService registerOccurrencesService;
    private final OccurrencesAssembler occurrencesAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrencesResponse register(@PathVariable Long id,
                                        @Valid @RequestBody OccurrencesRequest occurrencesRequest) {
        return occurrencesAssembler
                .toModel(registerOccurrencesService.register(id, occurrencesRequest.getDescription()));
    }

    @GetMapping
    public List<OccurrencesResponse> list(@PathVariable Long id) {
        Delivery delivery = registerOccurrencesService.searchDelivery(id);
        return occurrencesAssembler.toCollectionModel(delivery.getOccurrences());
    }
}

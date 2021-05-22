package com.core.api.assembler;

import com.core.api.model.response.OccurrencesResponse;
import com.core.domain.entities.Occurrences;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurrencesAssembler {
    private final ModelMapper mapper;

    public OccurrencesResponse toModel(Occurrences occurrences) {
        return mapper.map(occurrences, OccurrencesResponse.class);
    }

    public List<OccurrencesResponse> toCollectionModel(List<Occurrences> occurrences) {
        return occurrences.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}

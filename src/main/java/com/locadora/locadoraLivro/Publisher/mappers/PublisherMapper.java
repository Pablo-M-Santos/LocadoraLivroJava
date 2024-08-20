package com.locadora.locadoraLivro.Publisher.mappers;

import com.locadora.locadoraLivro.Publisher.DTOs.PublisherResponseDTO;
import com.locadora.locadoraLivro.Publisher.models.PublisherModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Component
public class PublisherMapper {

    public List<PublisherResponseDTO> toPublisherResponseList(List<PublisherModel> publisherList){
        return publisherList.stream().map(this::toPublisherResponse).toList();
    }

    public PublisherResponseDTO toPublisherResponse(PublisherModel model){
        return PublisherResponseDTO
                .builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .telephone(model.getTelephone())
                .site(model.getSite())
                .build();
    }
}

package com.steamclone.steam_clone.mapper;

import com.steamclone.steam_clone.domain.Publisher;
import com.steamclone.steam_clone.dto.PublisherDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PublisherMapper {

    PublisherDto toDto(Publisher publisher);

    Publisher toEntity(PublisherDto publisherDto);

    List<PublisherDto> toDtoList(List<Publisher> publishers);

    List<Publisher> toEntityList(List<PublisherDto> publisherDtos);
}



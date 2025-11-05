package com.steamclone.steam_clone.mapper;

import com.steamclone.steam_clone.domain.Developer;
import com.steamclone.steam_clone.dto.DeveloperDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeveloperMapper {

    DeveloperDto toDto(Developer developer);

    Developer toEntity(DeveloperDto developerDto);

    List<DeveloperDto> toDtoList(List<Developer> developers);

    List<Developer> toEntityList(List<DeveloperDto> developerDtos);
}



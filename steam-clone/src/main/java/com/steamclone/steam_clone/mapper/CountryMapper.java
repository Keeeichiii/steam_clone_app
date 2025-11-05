package com.steamclone.steam_clone.mapper;

import com.steamclone.steam_clone.domain.Country;
import com.steamclone.steam_clone.dto.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {

    CountryDto toDto(Country country);

    Country toEntity(CountryDto countryDto);

    List<CountryDto> toDtoList(List<Country> countries);

    List<Country> toEntityList(List<CountryDto> countryDtos);
}



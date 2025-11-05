package com.steamclone.steam_clone.mapper;

import com.steamclone.steam_clone.domain.Genre;
import com.steamclone.steam_clone.dto.GenreDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {

    GenreDto toDto(Genre genre);

    Genre toEntity(GenreDto genreDto);

    List<GenreDto> toDtoList(List<Genre> genres);

    List<Genre> toEntityList(List<GenreDto> genreDtos);
}



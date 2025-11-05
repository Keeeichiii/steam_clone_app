package com.steamclone.steam_clone.mapper;

import com.steamclone.steam_clone.domain.Game;
import com.steamclone.steam_clone.dto.GameDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GameMapper {

    @Mapping(source = "developer.id", target = "developerId")
    @Mapping(source = "publisher.id", target = "publisherId")
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "discounts", ignore = true)
    GameDto toDto(Game game);

    @Mapping(source = "developerId", target = "developer.id")
    @Mapping(source = "publisherId", target = "publisher.id")
    @Mapping(target = "developer", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "discounts", ignore = true)
    Game toEntity(GameDto gameDto);

    List<GameDto> toDtoList(List<Game> games);

    List<Game> toEntityList(List<GameDto> gameDtos);
}



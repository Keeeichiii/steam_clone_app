package com.steamclone.steam_clone.mapper;

import com.steamclone.steam_clone.domain.Review;
import com.steamclone.steam_clone.dto.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "game.id", target = "gameId")
    ReviewDto toDto(Review review);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "gameId", target = "game.id")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    Review toEntity(ReviewDto reviewDto);

    List<ReviewDto> toDtoList(List<Review> reviews);

    List<Review> toEntityList(List<ReviewDto> reviewDtos);
}



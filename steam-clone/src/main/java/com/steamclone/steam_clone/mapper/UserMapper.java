package com.steamclone.steam_clone.mapper;

import com.steamclone.steam_clone.domain.User;
import com.steamclone.steam_clone.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "credential.id", target = "credentialId")
    UserDto toDto(User user);

    @Mapping(source = "countryId", target = "country.id")
    @Mapping(source = "credentialId", target = "credential.id")
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "credential", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);

    List<User> toEntityList(List<UserDto> userDtos);
}



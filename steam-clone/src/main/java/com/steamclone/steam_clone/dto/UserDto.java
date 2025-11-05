package com.steamclone.steam_clone.dto;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
public class UserDto {
    private Long id;
    private Long credentialId;
    private Long countryId;
    private String username;
    private LocalDate registrationDate;
    private String firstName;
    private String lastName;
    private String profileName;
    private String avatarUrl;
    private String bio;
    private Instant lastActivity;
    private String phone;
}


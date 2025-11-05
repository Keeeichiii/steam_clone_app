package com.steamclone.steam_clone.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ReviewDto {
    private Long id;
    private Long userId;
    private Long gameId;
    private Integer rating;
    private String comment;
    private Instant createdAt;
}



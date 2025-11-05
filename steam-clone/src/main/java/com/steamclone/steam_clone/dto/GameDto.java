package com.steamclone.steam_clone.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class GameDto {
    private Long id;
    private Long developerId;
    private Long publisherId;
    private String title;
    private LocalDate releaseDate;
    private BigDecimal basePrice;
    private String description;
    private BigDecimal averageRating;
    private Integer reviewCount;
    private List<GenreDto> genres;
    private List<DiscountDto> discounts;
}

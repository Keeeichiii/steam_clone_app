package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();
    Optional<Review> findById(Long id);
    Review save(Review review);
    void deleteById(Long id);
}



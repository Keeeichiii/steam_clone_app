package com.steamclone.steam_clone.repository;

import com.steamclone.steam_clone.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}



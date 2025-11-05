package com.steamclone.steam_clone.repository;

import com.steamclone.steam_clone.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}



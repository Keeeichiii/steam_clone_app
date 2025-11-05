package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    List<Discount> findAll();
    Optional<Discount> findById(Long id);
    Discount save(Discount discount);
    void deleteById(Long id);
}



package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> findByCode(String code);
    Country save(Country country);
    void deleteById(Long id);
}






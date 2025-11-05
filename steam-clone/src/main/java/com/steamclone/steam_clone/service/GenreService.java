package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> findAll();
    Optional<Genre> findById(Long id);
    Optional<Genre> findByName(String name);
    Genre save(Genre genre);
    void deleteById(Long id);
}



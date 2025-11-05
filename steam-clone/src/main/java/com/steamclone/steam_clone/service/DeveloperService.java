package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.Developer;

import java.util.List;
import java.util.Optional;

public interface DeveloperService {
    List<Developer> findAll();
    Optional<Developer> findById(Long id);
    Optional<Developer> findByName(String name);
    Developer save(Developer developer);
    void deleteById(Long id);
}



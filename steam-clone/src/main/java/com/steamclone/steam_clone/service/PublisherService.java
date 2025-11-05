package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    List<Publisher> findAll();
    Optional<Publisher> findById(Long id);
    Optional<Publisher> findByName(String name);
    Publisher save(Publisher publisher);
    void deleteById(Long id);
}



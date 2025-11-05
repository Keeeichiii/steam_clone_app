package com.steamclone.steam_clone.repository;

import com.steamclone.steam_clone.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Optional<Developer> findByName(String name);
}



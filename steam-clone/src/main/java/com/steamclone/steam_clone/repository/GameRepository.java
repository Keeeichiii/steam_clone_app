package com.steamclone.steam_clone.repository;

import com.steamclone.steam_clone.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}



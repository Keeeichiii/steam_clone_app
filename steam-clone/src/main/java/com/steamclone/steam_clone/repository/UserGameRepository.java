package com.steamclone.steam_clone.repository;

import com.steamclone.steam_clone.domain.UserGame;
import com.steamclone.steam_clone.domain.UserGameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGameRepository extends JpaRepository<UserGame, UserGameId> {
}



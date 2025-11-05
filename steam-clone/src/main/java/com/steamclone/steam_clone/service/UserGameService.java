package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.UserGame;
import com.steamclone.steam_clone.domain.UserGameId;

import java.util.List;
import java.util.Optional;

public interface UserGameService {
    List<UserGame> findAll();
    Optional<UserGame> findById(UserGameId id);
    UserGame save(UserGame userGame);
    void deleteById(UserGameId id);
}



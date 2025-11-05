package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.UserGame;
import com.steamclone.steam_clone.domain.UserGameId;
import com.steamclone.steam_clone.repository.UserGameRepository;
import com.steamclone.steam_clone.service.UserGameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserGameServiceImpl implements UserGameService {

    private final UserGameRepository userGameRepository;

    public UserGameServiceImpl(UserGameRepository userGameRepository) {
        this.userGameRepository = userGameRepository;
    }

    @Override
    public List<UserGame> findAll() {
        return userGameRepository.findAll();
    }

    @Override
    public Optional<UserGame> findById(UserGameId id) {
        return userGameRepository.findById(id);
    }

    @Override
    @Transactional
    public UserGame save(UserGame userGame) {
        return userGameRepository.save(userGame);
    }

    @Override
    @Transactional
    public void deleteById(UserGameId id) {
        userGameRepository.deleteById(id);
    }
}



package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.Game;
import com.steamclone.steam_clone.repository.GameRepository;
import com.steamclone.steam_clone.service.GameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> findAll() { return gameRepository.findAll(); }

    @Override
    public Optional<Game> findById(Long id) { return gameRepository.findById(id); }

    @Override
    @Transactional
    public Game save(Game game) { return gameRepository.save(game); }

    @Override
    @Transactional
    public void deleteById(Long id) { gameRepository.deleteById(id); }
}






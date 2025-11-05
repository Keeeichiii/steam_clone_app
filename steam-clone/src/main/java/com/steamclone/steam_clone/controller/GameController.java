package com.steamclone.steam_clone.controller;

import com.steamclone.steam_clone.dto.GameDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final List<GameDto> games = new ArrayList<>();
    private Long nextId = 1L;

    public GameController() {
        games.addAll(List.of(
                seed("Half-Life 2"),
                seed("Portal 2"),
                seed("The Witcher 3"),
                seed("Hades")
        ));
    }

    private GameDto seed(String title) {
        GameDto dto = new GameDto();
        dto.setId(nextId++);
        dto.setTitle(title);
        return dto;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    Iterable<GameDto> getGames() {
        return games;
    }

    @GetMapping("/{id}")
    Optional<GameDto> getGameById(@PathVariable Long id) {
        for (GameDto g : games) {
            if (g.getId().equals(id)) {
                return Optional.of(g);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    ResponseEntity<GameDto> postGame(@RequestBody GameDto gameDto) {
        gameDto.setId(nextId++);
        games.add(gameDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(gameDto);
    }

    @PutMapping("/{id}")
    GameDto putGameById(@PathVariable Long id, @RequestBody GameDto gameDto) {
        int index = -1;
        for (GameDto g : games) {
            if (g.getId().equals(id)) {
                index = games.indexOf(g);
                games.set(index, gameDto);
            }
        }
        if (index == -1) {
            gameDto.setId(id != null ? id : nextId++);
            return postGame(gameDto).getBody();
        }
        return gameDto;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        games.removeIf(g -> g.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}



package com.steamclone.steam_clone.controller;

import com.steamclone.steam_clone.dto.GenreDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final List<GenreDto> genres = new ArrayList<>();
    private Long nextId = 1L;

    public GenreController() {
        genres.addAll(List.of(
                seed("Action"),
                seed("RPG"),
                seed("Puzzle"),
                seed("Roguelike")
        ));
    }

    private GenreDto seed(String name) {
        GenreDto dto = new GenreDto();
        dto.setId(nextId++);
        dto.setName(name);
        return dto;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    Iterable<GenreDto> getGenres() {
        return genres;
    }

    @GetMapping("/{id}")
    Optional<GenreDto> getGenreById(@PathVariable Long id) {
        for (GenreDto g : genres) {
            if (g.getId().equals(id)) {
                return Optional.of(g);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    ResponseEntity<GenreDto> postGenre(@RequestBody GenreDto genreDto) {
        genreDto.setId(nextId++);
        genres.add(genreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreDto);
    }

    @PutMapping("/{id}")
    GenreDto putGenreById(@PathVariable Long id, @RequestBody GenreDto genreDto) {
        int index = -1;
        for (GenreDto g : genres) {
            if (g.getId().equals(id)) {
                index = genres.indexOf(g);
                genres.set(index, genreDto);
            }
        }
        if (index == -1) {
            genreDto.setId(id != null ? id : nextId++);
            return postGenre(genreDto).getBody();
        }
        return genreDto;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genres.removeIf(g -> g.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}



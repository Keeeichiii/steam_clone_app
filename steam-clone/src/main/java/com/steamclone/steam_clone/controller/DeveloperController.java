package com.steamclone.steam_clone.controller;

import com.steamclone.steam_clone.dto.DeveloperDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    private final List<DeveloperDto> developers = new ArrayList<>();
    private Long nextId = 1L;

    public DeveloperController() {
        developers.addAll(List.of(
                seed("Valve"),
                seed("CD PROJEKT RED"),
                seed("Supergiant Games")
        ));
    }

    private DeveloperDto seed(String name) {
        DeveloperDto dto = new DeveloperDto();
        dto.setId(nextId++);
        dto.setName(name);
        return dto;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    Iterable<DeveloperDto> getDevelopers() {
        return developers;
    }

    @GetMapping("/{id}")
    Optional<DeveloperDto> getDeveloperById(@PathVariable Long id) {
        for (DeveloperDto d : developers) {
            if (d.getId().equals(id)) {
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    ResponseEntity<DeveloperDto> postDeveloper(@RequestBody DeveloperDto developerDto) {
        developerDto.setId(nextId++);
        developers.add(developerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(developerDto);
    }

    @PutMapping("/{id}")
    DeveloperDto putDeveloperById(@PathVariable Long id, @RequestBody DeveloperDto developerDto) {
        int index = -1;
        for (DeveloperDto d : developers) {
            if (d.getId().equals(id)) {
                index = developers.indexOf(d);
                developers.set(index, developerDto);
            }
        }
        if (index == -1) {
            developerDto.setId(id != null ? id : nextId++);
            return postDeveloper(developerDto).getBody();
        }
        return developerDto;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteDeveloper(@PathVariable Long id) {
        developers.removeIf(d -> d.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}



package com.steamclone.steam_clone.controller;

import com.steamclone.steam_clone.dto.PublisherDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final List<PublisherDto> publishers = new ArrayList<>();
    private Long nextId = 1L;

    public PublisherController() {
        publishers.addAll(List.of(
                seed("Valve"),
                seed("CD PROJEKT"),
                seed("Electronic Arts")
        ));
    }

    private PublisherDto seed(String name) {
        PublisherDto dto = new PublisherDto();
        dto.setId(nextId++);
        dto.setName(name);
        return dto;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    Iterable<PublisherDto> getPublishers() {
        return publishers;
    }

    @GetMapping("/{id}")
    Optional<PublisherDto> getPublisherById(@PathVariable Long id) {
        for (PublisherDto p : publishers) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    ResponseEntity<PublisherDto> postPublisher(@RequestBody PublisherDto publisherDto) {
        publisherDto.setId(nextId++);
        publishers.add(publisherDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherDto);
    }

    @PutMapping("/{id}")
    PublisherDto putPublisherById(@PathVariable Long id, @RequestBody PublisherDto publisherDto) {
        int index = -1;
        for (PublisherDto p : publishers) {
            if (p.getId().equals(id)) {
                index = publishers.indexOf(p);
                publishers.set(index, publisherDto);
            }
        }
        if (index == -1) {
            publisherDto.setId(id != null ? id : nextId++);
            return postPublisher(publisherDto).getBody();
        }
        return publisherDto;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publishers.removeIf(p -> p.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}



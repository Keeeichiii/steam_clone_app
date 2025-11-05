package com.steamclone.steam_clone.controller;

import com.steamclone.steam_clone.dto.ReviewDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final List<ReviewDto> reviews = new ArrayList<>();
    private Long nextId = 1L;

    public ReviewController() {
        reviews.addAll(List.of(
                seed(1L, 1L, 10, "Masterpiece"),
                seed(2L, 1L, 9, "Great game"),
                seed(1L, 2L, 8, "Clever puzzles")
        ));
    }

    private ReviewDto seed(Long userId, Long gameId, Integer rating, String comment) {
        ReviewDto dto = new ReviewDto();
        dto.setId(nextId++);
        dto.setUserId(userId);
        dto.setGameId(gameId);
        dto.setRating(rating);
        dto.setComment(comment);
        dto.setCreatedAt(Instant.now());
        return dto;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    Iterable<ReviewDto> getReviews() {
        return reviews;
    }

    @GetMapping("/{id}")
    Optional<ReviewDto> getReviewById(@PathVariable Long id) {
        for (ReviewDto r : reviews) {
            if (r.getId().equals(id)) {
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    ResponseEntity<ReviewDto> postReview(@RequestBody ReviewDto reviewDto) {
        reviewDto.setId(nextId++);
        if (reviewDto.getCreatedAt() == null) {
            reviewDto.setCreatedAt(Instant.now());
        }
        reviews.add(reviewDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewDto);
    }

    @PutMapping("/{id}")
    ReviewDto putReviewById(@PathVariable Long id, @RequestBody ReviewDto reviewDto) {
        int index = -1;
        for (ReviewDto r : reviews) {
            if (r.getId().equals(id)) {
                index = reviews.indexOf(r);
                reviews.set(index, reviewDto);
            }
        }
        if (index == -1) {
            reviewDto.setId(id != null ? id : nextId++);
            return postReview(reviewDto).getBody();
        }
        return reviewDto;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviews.removeIf(r -> r.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}



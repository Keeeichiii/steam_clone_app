package com.steamclone.steam_clone.controller;

import com.steamclone.steam_clone.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<UserDto> users = new ArrayList<>();
    private Long nextId = 1L;

    public UserController() {
        users.addAll(List.of(
                seed("gordon"),
                seed("chell"),
                seed("geralt"),
                seed("zag" )
        ));
    }

    private UserDto seed(String username) {
        UserDto dto = new UserDto();
        dto.setId(nextId++);
        dto.setUsername(username);
        dto.setRegistrationDate(LocalDate.now());
        return dto;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    Iterable<UserDto> getUsers() {
        return users;
    }

    @GetMapping("/{id}")
    Optional<UserDto> getUserById(@PathVariable Long id) {
        for (UserDto u : users) {
            if (u.getId().equals(id)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    ResponseEntity<UserDto> postUser(@RequestBody UserDto userDto) {
        userDto.setId(nextId++);
        users.add(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PutMapping("/{id}")
    UserDto putUserById(@PathVariable Long id, @RequestBody UserDto userDto) {
        int index = -1;
        for (UserDto u : users) {
            if (u.getId().equals(id)) {
                index = users.indexOf(u);
                users.set(index, userDto);
            }
        }
        if (index == -1) {
            userDto.setId(id != null ? id : nextId++);
            return postUser(userDto).getBody();
        }
        return userDto;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        users.removeIf(u -> u.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}



package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.Credential;

import java.util.List;
import java.util.Optional;

public interface CredentialService {
    List<Credential> findAll();
    Optional<Credential> findById(Long id);
    Optional<Credential> findByEmail(String email);
    Credential save(Credential credential);
    void deleteById(Long id);
}



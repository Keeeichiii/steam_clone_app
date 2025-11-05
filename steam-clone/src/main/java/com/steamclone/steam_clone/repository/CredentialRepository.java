package com.steamclone.steam_clone.repository;

import com.steamclone.steam_clone.domain.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
    Optional<Credential> findByEmail(String email);
}



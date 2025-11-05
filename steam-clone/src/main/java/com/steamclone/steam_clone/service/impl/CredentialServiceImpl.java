package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.Credential;
import com.steamclone.steam_clone.repository.CredentialRepository;
import com.steamclone.steam_clone.service.CredentialService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CredentialServiceImpl implements CredentialService {

    private final CredentialRepository credentialRepository;

    public CredentialServiceImpl(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Override
    public List<Credential> findAll() {
        return credentialRepository.findAll();
    }

    @Override
    public Optional<Credential> findById(Long id) {
        return credentialRepository.findById(id);
    }

    @Override
    public Optional<Credential> findByEmail(String email) {
        return credentialRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public Credential save(Credential credential) {
        return credentialRepository.save(credential);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        credentialRepository.deleteById(id);
    }
}



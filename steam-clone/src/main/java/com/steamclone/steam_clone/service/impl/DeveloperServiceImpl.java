package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.Developer;
import com.steamclone.steam_clone.repository.DeveloperRepository;
import com.steamclone.steam_clone.service.DeveloperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    @Override
    public Optional<Developer> findById(Long id) {
        return developerRepository.findById(id);
    }

    @Override
    public Optional<Developer> findByName(String name) {
        return developerRepository.findByName(name);
    }

    @Override
    @Transactional
    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        developerRepository.deleteById(id);
    }
}



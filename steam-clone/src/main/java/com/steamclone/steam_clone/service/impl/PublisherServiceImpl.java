package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.Publisher;
import com.steamclone.steam_clone.repository.PublisherRepository;
import com.steamclone.steam_clone.service.PublisherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> findById(Long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Optional<Publisher> findByName(String name) {
        return publisherRepository.findByName(name);
    }

    @Override
    @Transactional
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }
}



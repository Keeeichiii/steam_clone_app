package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.Country;
import com.steamclone.steam_clone.repository.CountryRepository;
import com.steamclone.steam_clone.service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> findByCode(String code) {
        return countryRepository.findByCode(code);
    }

    @Override
    @Transactional
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}






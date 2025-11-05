package com.steamclone.steam_clone.controller;

import com.steamclone.steam_clone.dto.CountryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final List<CountryDto> countries = new ArrayList<>();
    private Long nextId = 1L;

    public CountryController() {
        countries.addAll(List.of(
                seed("United States", "US", "USD"),
                seed("Ukraine", "UA", "UAH"),
                seed("Germany", "DE", "EUR"),
                seed("Japan", "JP", "JPY")
        ));
    }

    private CountryDto seed(String name, String code, String currencyCode) {
        CountryDto dto = new CountryDto();
        dto.setId(nextId++);
        dto.setName(name);
        dto.setCode(code);
        dto.setCurrencyCode(currencyCode);
        return dto;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    Iterable<CountryDto> getCountries() {
        return countries;
    }

    @GetMapping("/{id}")
    Optional<CountryDto> getCountryById(@PathVariable Long id) {
        for (CountryDto c : countries) {
            if (c.getId().equals(id)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    ResponseEntity<CountryDto> postCountry(@RequestBody CountryDto countryDto) {
        countryDto.setId(nextId++);
        countries.add(countryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryDto);
    }

    @PutMapping("/{id}")
    CountryDto putCountryById(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        int index = -1;
        for (CountryDto c : countries) {
            if (c.getId().equals(id)) {
                index = countries.indexOf(c);
                countries.set(index, countryDto);
            }
        }
        if (index == -1) {
            countryDto.setId(id != null ? id : nextId++);
            return postCountry(countryDto).getBody();
        }
        return countryDto;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countries.removeIf(c -> c.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}



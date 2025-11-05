package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.Discount;
import com.steamclone.steam_clone.repository.DiscountRepository;
import com.steamclone.steam_clone.service.DiscountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return discountRepository.findById(id);
    }

    @Override
    @Transactional
    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        discountRepository.deleteById(id);
    }
}



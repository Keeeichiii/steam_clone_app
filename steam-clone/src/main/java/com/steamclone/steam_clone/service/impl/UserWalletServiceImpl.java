package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.UserWallet;
import com.steamclone.steam_clone.repository.UserWalletRepository;
import com.steamclone.steam_clone.service.UserWalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserWalletServiceImpl implements UserWalletService {

    private final UserWalletRepository userWalletRepository;

    public UserWalletServiceImpl(UserWalletRepository userWalletRepository) {
        this.userWalletRepository = userWalletRepository;
    }

    @Override
    public List<UserWallet> findAll() {
        return userWalletRepository.findAll();
    }

    @Override
    public Optional<UserWallet> findById(Long id) {
        return userWalletRepository.findById(id);
    }

    @Override
    @Transactional
    public UserWallet save(UserWallet userWallet) {
        return userWalletRepository.save(userWallet);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userWalletRepository.deleteById(id);
    }
}



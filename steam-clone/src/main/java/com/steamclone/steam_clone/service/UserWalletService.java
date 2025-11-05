package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.UserWallet;

import java.util.List;
import java.util.Optional;

public interface UserWalletService {
    List<UserWallet> findAll();
    Optional<UserWallet> findById(Long id);
    UserWallet save(UserWallet userWallet);
    void deleteById(Long id);
}



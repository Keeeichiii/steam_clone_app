package com.steamclone.steam_clone.repository;

import com.steamclone.steam_clone.domain.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {
}



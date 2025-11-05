package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.TransactionItem;

import java.util.List;
import java.util.Optional;

public interface TransactionItemService {
    List<TransactionItem> findAll();
    Optional<TransactionItem> findById(Long id);
    TransactionItem save(TransactionItem transactionItem);
    void deleteById(Long id);
}



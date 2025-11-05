package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.TransactionItem;
import com.steamclone.steam_clone.repository.TransactionItemRepository;
import com.steamclone.steam_clone.service.TransactionItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TransactionItemServiceImpl implements TransactionItemService {

    private final TransactionItemRepository transactionItemRepository;

    public TransactionItemServiceImpl(TransactionItemRepository transactionItemRepository) {
        this.transactionItemRepository = transactionItemRepository;
    }

    @Override
    public List<TransactionItem> findAll() {
        return transactionItemRepository.findAll();
    }

    @Override
    public Optional<TransactionItem> findById(Long id) {
        return transactionItemRepository.findById(id);
    }

    @Override
    @Transactional
    public TransactionItem save(TransactionItem transactionItem) {
        return transactionItemRepository.save(transactionItem);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        transactionItemRepository.deleteById(id);
    }
}



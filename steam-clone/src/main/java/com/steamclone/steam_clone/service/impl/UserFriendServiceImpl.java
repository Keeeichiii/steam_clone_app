package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.UserFriend;
import com.steamclone.steam_clone.domain.UserFriendId;
import com.steamclone.steam_clone.repository.UserFriendRepository;
import com.steamclone.steam_clone.service.UserFriendService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserFriendServiceImpl implements UserFriendService {

    private final UserFriendRepository userFriendRepository;

    public UserFriendServiceImpl(UserFriendRepository userFriendRepository) {
        this.userFriendRepository = userFriendRepository;
    }

    @Override
    public List<UserFriend> findAll() {
        return userFriendRepository.findAll();
    }

    @Override
    public Optional<UserFriend> findById(UserFriendId id) {
        return userFriendRepository.findById(id);
    }

    @Override
    @Transactional
    public UserFriend save(UserFriend userFriend) {
        return userFriendRepository.save(userFriend);
    }

    @Override
    @Transactional
    public void deleteById(UserFriendId id) {
        userFriendRepository.deleteById(id);
    }
}



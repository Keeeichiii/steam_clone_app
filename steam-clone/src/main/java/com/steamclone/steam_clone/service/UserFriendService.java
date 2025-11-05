package com.steamclone.steam_clone.service;

import com.steamclone.steam_clone.domain.UserFriend;
import com.steamclone.steam_clone.domain.UserFriendId;

import java.util.List;
import java.util.Optional;

public interface UserFriendService {
    List<UserFriend> findAll();
    Optional<UserFriend> findById(UserFriendId id);
    UserFriend save(UserFriend userFriend);
    void deleteById(UserFriendId id);
}



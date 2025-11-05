package com.steamclone.steam_clone.repository;

import com.steamclone.steam_clone.domain.UserFriend;
import com.steamclone.steam_clone.domain.UserFriendId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFriendRepository extends JpaRepository<UserFriend, UserFriendId> {
}



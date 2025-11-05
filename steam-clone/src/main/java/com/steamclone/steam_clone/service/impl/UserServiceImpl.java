package com.steamclone.steam_clone.service.impl;

import com.steamclone.steam_clone.domain.User;
import com.steamclone.steam_clone.repository.UserRepository;
import com.steamclone.steam_clone.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() { return userRepository.findAll(); }

    @Override
    public Optional<User> findById(Long id) { return userRepository.findById(id); }

    @Override
    public Optional<User> findByUsername(String username) { return userRepository.findByUsername(username); }

    @Override
    @Transactional
    public User save(User user) { return userRepository.save(user); }

    @Override
    @Transactional
    public void deleteById(Long id) { userRepository.deleteById(id); }
}






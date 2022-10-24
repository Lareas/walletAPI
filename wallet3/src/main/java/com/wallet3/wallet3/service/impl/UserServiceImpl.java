package com.wallet3.wallet3.service.impl;

import com.wallet3.wallet3.entity.User;
import com.wallet3.wallet3.repository.UserRepository;
import com.wallet3.wallet3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User u) {
        return userRepository.save(u);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmailEquals(email);
    }
}

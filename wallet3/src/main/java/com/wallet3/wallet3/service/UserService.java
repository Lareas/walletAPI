package com.wallet3.wallet3.service;

import com.wallet3.wallet3.entity.User;

import java.util.Optional;

public interface UserService {
    User save(User u);

    Optional<User> findByEmail(String email);

}

package com.wallet3.wallet3.repository;

import com.wallet3.wallet3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailEquals(String email);
}

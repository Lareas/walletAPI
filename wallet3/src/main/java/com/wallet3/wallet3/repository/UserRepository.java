package com.wallet3.wallet3.repository;

import com.wallet3.wallet3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

package com.wallet3.wallet3.service;

import java.util.Optional;
import com.wallet3.wallet3.entity.User;
import com.wallet3.wallet3.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @BeforeEach
    public void setUp() {
        BDDMockito.given(userRepository
                .findByEmailEquals(Mockito.anyString()))
                .willReturn(Optional.of(new User()));
    }

    @Test
    public void testFindByEmailEquals() {
        Optional<User> user = userService.findByEmail("email@test.com");

        assertTrue(user.isPresent());
    }
}

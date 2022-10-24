package com.wallet3.wallet3.repository;

import com.wallet3.wallet3.entity.User;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL = "email@test.com"; 

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        User u = new User();
        u.setName("Setup User");
        u.setPassword("Senha123456");
        u.setEmail(EMAIL);
        userRepository.save(u);
    }

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
    }



    @Test
    public void testSave() {
        User u = new User();
        u.setName("teste");
        u.setPassword("123456");
        u.setEmail("teste@email.com");

        User response = userRepository.save(u);
        assertNotNull(response);
    }

    @Test
    public void testFindByEmail() {
        // usa o Optional porque pode existir um usuário ou não
        Optional<User> response = userRepository.findByEmailEquals(EMAIL);

        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }
}

package com.wallet3.wallet3.repository;

import com.wallet3.wallet3.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSave() {
        User u = new User();
        u.setName("teste");
        u.setPassword("123456");
        u.setEmail("teste@email.com");

        User response = userRepository.save(u);
        assertNotNull(response);
    }
}

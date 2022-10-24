package com.wallet3.wallet3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet3.wallet3.dto.UserDTO;
import com.wallet3.wallet3.entity.User;
import com.wallet3.wallet3.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    private static final String NAME = "User Test";
    private static final String PASSWORD = "123456";
    private static final String EMAIL = "email@test.com";
    private static final String URL = "/user";


    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testSave() throws Exception {

        BDDMockito.given(userService.save(Mockito.any(User.class)))
                .willReturn(getMockUser());

        mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }


    public User getMockUser() {
        User u = new User();
        u.setName(NAME);
        u.setPassword(PASSWORD);
        u.setEmail(EMAIL);
        return u;
    }

    public String getJsonPayload() throws JsonProcessingException {
        UserDTO dto = new UserDTO();
        dto.setName(NAME);
        dto.setPassword(PASSWORD);
        dto.setEmail(EMAIL);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(dto);
    }

}

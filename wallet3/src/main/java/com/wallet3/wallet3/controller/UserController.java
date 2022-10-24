package com.wallet3.wallet3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.wallet3.wallet3.dto.UserDTO;
import com.wallet3.wallet3.entity.User;
import com.wallet3.wallet3.response.Response;
import com.wallet3.wallet3.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult bindingResult) {

        Response<UserDTO> response = new Response<UserDTO>();

        User user = userService.save(this.convertDtoToEntity(dto));
        response.setData(convertEntityToDto(user));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private User convertDtoToEntity(UserDTO userDTO) {
        User u = new User();
        u.setName(userDTO.getName());
        u.setPassword(userDTO.getPassword());
        u.setEmail(userDTO.getEmail());
        return u;
    }

    private UserDTO convertEntityToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }


}

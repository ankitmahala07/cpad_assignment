package com.cpad.assignment.controller;

import com.cpad.assignment.dto.request.CredentialsDTO;
import com.cpad.assignment.dto.response.UserInfoDTO;
import com.cpad.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserInfoDTO> login(@RequestBody CredentialsDTO credentials) throws Exception {
        return ResponseEntity.ok(userService.login(credentials));
    }

}

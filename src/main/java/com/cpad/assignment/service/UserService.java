package com.cpad.assignment.service;

import com.cpad.assignment.dto.request.CredentialsDTO;
import com.cpad.assignment.dto.response.UserInfoDTO;

public interface UserService {
    public UserInfoDTO login(CredentialsDTO credentials) throws Exception;
}

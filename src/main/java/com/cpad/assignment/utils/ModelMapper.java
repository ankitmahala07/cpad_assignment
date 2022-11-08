package com.cpad.assignment.utils;

import com.cpad.assignment.dto.response.UserInfoDTO;
import com.cpad.assignment.model.User;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public UserInfoDTO convert(User user){
        UserInfoDTO userDto = new UserInfoDTO();
        userDto.setUsername(user.username);
        userDto.setDisplayName(user.displayName);
        userDto.setRole(user.role);
        return userDto;
    }

}

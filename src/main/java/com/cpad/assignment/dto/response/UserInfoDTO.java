package com.cpad.assignment.dto.response;

import com.cpad.assignment.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserInfoDTO {

    private String userId;

    private String username;

    private String displayName;

    private Role role;

}

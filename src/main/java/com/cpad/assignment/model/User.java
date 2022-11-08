package com.cpad.assignment.model;

import com.arangodb.springframework.annotation.Document;
import com.cpad.assignment.enums.Role;
import org.springframework.data.annotation.Id;

@Document("user")
public class User {
    @Id
    public String id;

    public String username;

    public String displayName;

    public String password;

    public Role role;
}

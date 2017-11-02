package com.chewbaccajerky.user;

import com.chewbaccajerky.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity{
//    public static final PasswordEncoder = new BCrypt;
    private String firstName;
    private String lastName;
    private String username;
    @JsonIgnore
    private String password;
}

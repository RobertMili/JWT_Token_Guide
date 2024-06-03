package com.example.jwt_token_guild.dtos;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;

    private String password;

    private String fullName;
}

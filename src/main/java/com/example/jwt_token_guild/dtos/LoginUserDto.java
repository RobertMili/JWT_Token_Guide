package com.example.jwt_token_guild.dtos;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;

    private String password;
}

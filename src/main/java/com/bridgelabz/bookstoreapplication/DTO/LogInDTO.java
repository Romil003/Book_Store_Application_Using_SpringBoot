package com.bridgelabz.bookstoreapplication.DTO;

import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
public class LogInDTO {

    @NotNull(message = "Email cannot be empty")
    public String email;

    @NotNull(message = "password cannot be empty")
    public String password;
}

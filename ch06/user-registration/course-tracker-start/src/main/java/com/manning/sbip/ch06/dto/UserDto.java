package com.manning.sbip.ch06.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
@ToString(exclude = "password")
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty(message ="Enter your firstname")
    private String firstName;

    @NotEmpty(message ="Enter your lastname")
    private String lastName;

    @NotEmpty(message ="Enter a username")
    private String username;

    @NotEmpty(message ="Enter an email")
    @Email(message ="Email is not valid")
    private String email;

    @NotEmpty(message ="Enter a password")
    private String password;

    @NotEmpty(message ="Please, confirm your password")
    private String confirmPassword;


}

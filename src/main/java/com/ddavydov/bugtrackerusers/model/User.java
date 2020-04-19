package com.ddavydov.bugtrackerusers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name must be longer than 2 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, message = "Last name must be longer than 2 characters")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be equal or grater than 8 chars and less than 16")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
}

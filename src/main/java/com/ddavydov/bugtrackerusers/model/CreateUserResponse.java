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
public class CreateUserResponse {
    private String firstName;
    private String lastName;
    private String userId;
    private String email;
}

package com.ddavydov.photoappusers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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

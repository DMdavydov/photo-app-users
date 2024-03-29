package com.ddavydov.photoappusers.dto;

import com.ddavydov.photoappusers.model.AlbumResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = -1371565189754411309L;
    private String userId;
    private String firstName;
    private String lastName;
    private String password;
    private String encryptedPassword;
    private String email;
    private List<AlbumResponse> albums;
}

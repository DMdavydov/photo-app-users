package com.ddavydov.bugtrackerusers.service;

import com.ddavydov.bugtrackerusers.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
}

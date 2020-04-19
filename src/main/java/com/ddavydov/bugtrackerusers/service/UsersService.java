package com.ddavydov.bugtrackerusers.service;

import com.ddavydov.bugtrackerusers.dto.UserDto;

public interface UsersService {
    UserDto createUser(UserDto userDetails);
}

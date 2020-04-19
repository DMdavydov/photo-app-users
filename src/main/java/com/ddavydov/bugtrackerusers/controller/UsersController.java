package com.ddavydov.bugtrackerusers.controller;

import com.ddavydov.bugtrackerusers.dto.UserDto;
import com.ddavydov.bugtrackerusers.model.User;
import com.ddavydov.bugtrackerusers.model.UsersEntity;
import com.ddavydov.bugtrackerusers.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final Environment env;
    private final UsersService usersService;

    @GetMapping("/status/check")
    public String status() {
        return "Working on port" + env.getProperty("local.server.port");
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody @Valid User user){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(user, UserDto.class);

        return usersService.createUser(userDto);
    }
}

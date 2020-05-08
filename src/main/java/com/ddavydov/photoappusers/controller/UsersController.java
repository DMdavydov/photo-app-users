package com.ddavydov.photoappusers.controller;

import com.ddavydov.photoappusers.dto.UserDto;
import com.ddavydov.photoappusers.model.CreateUserRequest;
import com.ddavydov.photoappusers.model.CreateUserResponse;
import com.ddavydov.photoappusers.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        return "Working on port" + env.getProperty("local.server.port") + ", with token = " + env.getProperty("token.secret");
    }

    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(createUserRequest, UserDto.class);
        UserDto createUser = usersService.createUser(userDto);

        CreateUserResponse response = modelMapper.map(createUser, CreateUserResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

package com.ddavydov.bugtrackerusers.service;

import com.ddavydov.bugtrackerusers.dto.UserDto;
import com.ddavydov.bugtrackerusers.model.UsersEntity;
import com.ddavydov.bugtrackerusers.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UsersEntity usersEntity = modelMapper.map(userDetails, UsersEntity.class);
        usersEntity.setEncryptedPassword("test");
        usersRepository.save(usersEntity);

        return userDetails;
    }
}

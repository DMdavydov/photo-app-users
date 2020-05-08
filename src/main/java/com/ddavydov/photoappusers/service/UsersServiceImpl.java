package com.ddavydov.photoappusers.service;

import com.ddavydov.photoappusers.dto.UserDto;
import com.ddavydov.photoappusers.model.UsersEntity;
import com.ddavydov.photoappusers.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity = usersRepository.findByEmail(username);
        if(usersEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(usersEntity.getEmail(), usersEntity.getEncryptedPassword(),
                true, true, true,
                true, new ArrayList<>());
    }

    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UsersEntity usersEntity = modelMapper.map(userDetails, UsersEntity.class);

        usersRepository.save(usersEntity);

        return modelMapper.map(usersEntity, UserDto.class);
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {
        UsersEntity usersEntity = usersRepository.findByEmail(email);
        if(usersEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        return new ModelMapper().map(usersEntity, UserDto.class);
    }
}

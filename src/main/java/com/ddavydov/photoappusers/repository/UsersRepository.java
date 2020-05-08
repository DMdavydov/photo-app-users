package com.ddavydov.photoappusers.repository;

import com.ddavydov.photoappusers.model.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UsersEntity, Long> {
    UsersEntity findByEmail(String email);
}

package com.ddavydov.bugtrackerusers.repository;

import com.ddavydov.bugtrackerusers.model.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UsersEntity, Long> {
}

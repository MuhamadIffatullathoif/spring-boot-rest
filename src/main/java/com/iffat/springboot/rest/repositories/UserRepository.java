package com.iffat.springboot.rest.repositories;

import com.iffat.springboot.rest.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

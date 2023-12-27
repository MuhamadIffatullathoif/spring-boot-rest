package com.iffat.springboot.rest.services;

import com.iffat.springboot.rest.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}

package com.iffat.springboot.rest.repositories;

import com.iffat.springboot.rest.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}

package com.iffat.springboot.rest.repositories;

import com.iffat.springboot.rest.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

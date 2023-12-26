package com.iffat.springboot.rest.services;

import com.iffat.springboot.rest.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> delete(Product product);
}
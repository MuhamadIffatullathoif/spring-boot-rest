package com.iffat.springboot.rest.services;

import com.iffat.springboot.rest.entities.Product;
import com.iffat.springboot.rest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            Product product1 = optionalProduct.get();

            product1.setSku(product.getSku());
            product1.setName(product.getName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            return Optional.of(productRepository.save(product1));
        }
        return optionalProduct;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        optionalProduct.ifPresent(productOpt -> {
            productRepository.delete(productOpt);
        });
        return optionalProduct;
    }

    @Override
    public boolean isExistSku(String sku) {
        return productRepository.existsBySku(sku);
    }
}

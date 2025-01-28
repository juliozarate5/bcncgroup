package com.bcncgroup.domain.repository;

import com.bcncgroup.domain.model.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findProductByCode(Long code);
}

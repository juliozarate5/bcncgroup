package com.bcncgroup.infrastructure.repository;

import com.bcncgroup.domain.model.Product;
import com.bcncgroup.domain.repository.ProductRepository;
import com.bcncgroup.infrastructure.mapper.ProductMapper;
import com.bcncgroup.infrastructure.persistence.jpa.entity.ProductEntity;
import com.bcncgroup.infrastructure.persistence.jpa.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class H2ProductRepository implements ProductRepository {

    private static final ProductMapper priceMapper = ProductMapper.INSTANCE;

    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public H2ProductRepository(final ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Optional<Product> findProductByCode(final Long code){
        final Optional<ProductEntity> productEntity = productJpaRepository.findByCode(code);
        return priceMapper.toProductOptional(productEntity);
    }
}

package com.bcncgroup.infrastructure.mapper;

import com.bcncgroup.domain.model.Product;
import com.bcncgroup.infrastructure.persistence.jpa.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductEntity productEntity);

}

package com.bcncgroup.infrastructure.mapper;

import com.bcncgroup.domain.model.Price;
import com.bcncgroup.infrastructure.rest.dto.PriceResponseDTO;
import com.bcncgroup.infrastructure.persistence.jpa.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);


    Price toPrice(PriceEntity priceEntity);

    // Mapea de Optional<PriceEntity> a Optional<Price>
    default Optional<Price> toPriceOptional(Optional<PriceEntity> priceEntityOptional) {
        return priceEntityOptional.map(this::toPrice);
    }

    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "product.code", target = "productId")
    PriceResponseDTO toPriceResponseDTO(Price price);
}

package com.bcncgroup.domain.mapper;

import com.bcncgroup.domain.dto.PriceResponseDTO;
import com.bcncgroup.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "product.code", target = "productId")
    PriceResponseDTO toPriceResponseDTO(Price price);

    List<PriceResponseDTO> toPriceResponseDtoList(List<Price> prices);
}

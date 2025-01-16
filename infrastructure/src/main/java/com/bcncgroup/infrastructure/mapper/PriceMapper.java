package com.bcncgroup.infrastructure.mapper;

import com.bcncgroup.domain.model.Price;
import com.bcncgroup.infrastructure.persistence.jpa.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price toPrice(PriceEntity priceEntity);

    List<Price> toPriceList(List<PriceEntity> priceEntityList);
}

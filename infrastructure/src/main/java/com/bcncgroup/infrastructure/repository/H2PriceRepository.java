package com.bcncgroup.infrastructure.repository;

import com.bcncgroup.domain.model.Price;
import com.bcncgroup.domain.repository.PriceRepository;
import com.bcncgroup.infrastructure.mapper.PriceMapper;
import com.bcncgroup.infrastructure.persistence.jpa.entity.PriceEntity;
import com.bcncgroup.infrastructure.persistence.jpa.repository.PriceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Adapter: Implementing of Domain repository
 */
@Component
public class H2PriceRepository implements PriceRepository {


    private static final PriceMapper priceMapper = PriceMapper.INSTANCE;

    @Autowired
    private PriceJpaRepository priceJpaRepository;

    /*@Autowired
    public H2PriceRepository(final PriceJpaRepository priceJpaRepository) {
        this.priceJpaRepository = priceJpaRepository;
    }*/

    @Override
    public List<Price> findPricesByParams(final LocalDateTime appDate,
                                          final Long productId,
                                          final Long brandId
                                          ) {
        final List<PriceEntity> priceEntityList =
                priceJpaRepository.findByAppDateAndProductIdAndBrandId(appDate, productId, brandId);
        return priceMapper.toPriceList(priceEntityList);
    }
}

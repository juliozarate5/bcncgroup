package com.bcncgroup.domain.service.impl;

import com.bcncgroup.domain.mapper.PriceMapper;
import com.bcncgroup.domain.repository.PriceRepository;
import com.bcncgroup.domain.service.PriceService;
import com.bcncgroup.domain.dto.PriceResponseDTO;
import com.bcncgroup.domain.model.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class DomainPriceServiceImpl implements PriceService {

    private static final PriceMapper priceMapper = PriceMapper.INSTANCE;

    @Autowired
    private PriceRepository priceRepository;

   /* @Autowired
    public DomainPriceServiceImpl(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }*/

    @Override
    public List<PriceResponseDTO> getPrices(
            final LocalDateTime appDate, final Long productId, final Long brandId) {
        try {
            final List<Price> prices = priceRepository.findPricesByParams(appDate, productId, brandId);
            return priceMapper.toPriceResponseDtoList(prices);
        } catch (Exception e) {
            throw new RuntimeException(""); // TODO: COLOCAR INTERNAL EXCEPTION
        }
    }
}

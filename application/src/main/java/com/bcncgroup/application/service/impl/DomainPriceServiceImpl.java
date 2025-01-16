package com.bcncgroup.application.service.impl;

import com.bcncgroup.application.service.PriceService;
import com.bcncgroup.domain.dto.ErrorDTO;
import com.bcncgroup.domain.dto.PriceResponseDTO;
import com.bcncgroup.domain.exceptions.BadRequestException;
import com.bcncgroup.domain.exceptions.InternalServerErrorException;
import com.bcncgroup.domain.exceptions.NotFoundException;
import com.bcncgroup.domain.mapper.PriceMapper;
import com.bcncgroup.domain.model.Price;
import com.bcncgroup.domain.model.Product;
import com.bcncgroup.domain.repository.PriceRepository;
import com.bcncgroup.domain.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class DomainPriceServiceImpl implements PriceService {

    private static final PriceMapper priceMapper = PriceMapper.INSTANCE;

    private final PriceRepository priceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public DomainPriceServiceImpl(
            final PriceRepository priceRepository
    ) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<PriceResponseDTO> getPrices(
            final LocalDateTime appDate, final Long productId, final Long brandId) {
        try {
            // TODO: VALIDAR BRAND
            final List<Price> prices = priceRepository.findPricesByParams(appDate, validateProduct(productId).getId(), brandId);
            Price price = prices.stream()
                    .max(Comparator.comparingInt(Price::getPriority))
                    .orElseThrow(() -> new BadRequestException("No valid price found"));

            return priceMapper.toPriceResponseDtoList(Collections.singletonList(price));

        } catch (InternalServerErrorException e) {
            throw new InternalServerErrorException(
                    ErrorDTO.builder()
                            .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                            .message("Error General")
                            .date(LocalDateTime.now())
                            .build()
            );
        }
    }

    private Product validateProduct(final Long code) {
        return productRepository.findProductByCode(code).orElseThrow(
                () -> new NotFoundException(
                        ErrorDTO.builder()
                                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                                .message("No existe producto")
                                .date(LocalDateTime.now())
                                .build()
                )
        );
    }
}

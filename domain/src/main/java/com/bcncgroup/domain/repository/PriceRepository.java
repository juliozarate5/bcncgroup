package com.bcncgroup.domain.repository;

import com.bcncgroup.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Port: for infraestructura layer connects to the model
 */
public interface PriceRepository {

    // Others methods...

    Optional<Price> findPricesByParams(
            LocalDateTime appDate, Long productId, Long brandId
    );
}

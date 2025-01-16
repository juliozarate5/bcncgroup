package com.bcncgroup.domain.repository;

import com.bcncgroup.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Port: for infraestructura layer connects to the model
 */
public interface PriceRepository {

    // Others methods...

    List<Price> findPricesByParams(
            LocalDateTime appDate, Long productId, Long brandId
    );
}

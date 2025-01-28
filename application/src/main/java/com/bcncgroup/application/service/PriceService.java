package com.bcncgroup.application.service;

import com.bcncgroup.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceService {

    // ... rest of methods

    Price getPrice(LocalDateTime appDate, Long productId, Long brandId);

}

package com.bcncgroup.domain.service;

import com.bcncgroup.domain.dto.PriceResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {

    // ... rest of methods

    List<PriceResponseDTO> getPrices(LocalDateTime appDate, Long productId, Long brandId);

}

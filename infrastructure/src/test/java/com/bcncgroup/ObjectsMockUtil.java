package com.bcncgroup;

import com.bcncgroup.domain.dto.PriceResponseDTO;
import com.bcncgroup.domain.enums.PriceListEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public final class ObjectsMockUtil {

    public static PriceResponseDTO priceResponseDTOMock() {
        return PriceResponseDTO.builder()
                .productId(35455L)
                .brandId(1L)
                .priceList(PriceListEnum.LIST_1)
                .startDate(LocalDateTime.of(2020, 6, 14, 9, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 15, 10, 0, 0))
                .total(BigDecimal.TEN)
                .build();
    }

    public static List<PriceResponseDTO> priceResponseDTOListMock() {
        return Collections.singletonList(priceResponseDTOMock());
    }
}

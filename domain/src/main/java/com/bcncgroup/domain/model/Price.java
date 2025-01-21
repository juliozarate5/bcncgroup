package com.bcncgroup.domain.model;

import com.bcncgroup.domain.enums.CurrencyEnum;
import com.bcncgroup.domain.enums.PriceListEnum;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
public class Price {

    Long id;

    Brand brand;

    LocalDateTime startDate;

    LocalDateTime endDate;

    PriceListEnum priceList;

    Product product;

    Integer priority;

    BigDecimal total;

    CurrencyEnum currency;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}

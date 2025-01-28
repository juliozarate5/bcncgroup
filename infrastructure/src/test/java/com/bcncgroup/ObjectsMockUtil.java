package com.bcncgroup;

import com.bcncgroup.domain.enums.CurrencyEnum;
import com.bcncgroup.domain.enums.PriceListEnum;
import com.bcncgroup.domain.model.Brand;
import com.bcncgroup.domain.model.Price;
import com.bcncgroup.domain.model.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class ObjectsMockUtil {

    public static Price priceMock() {
        return Price.builder()
                .id(1L)
                .brand(brandMock())
                .startDate(LocalDateTime.of(2020, 6, 14, 9, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 15, 10, 0, 0))
                .priceList(PriceListEnum.LIST_1)
                .product(productMock())
                .priority(1)
                .total(BigDecimal.TEN)
                .currency(CurrencyEnum.EUR)
                .createdAt(LocalDateTime.of(2020, 6, 14, 9, 0, 0))
                .updatedAt(LocalDateTime.of(2020, 6, 14, 9, 0, 0))
                .build();
    }

    public static Brand brandMock(){
        return Brand.builder()
                .id(1L)
                .name("ZARA")
                .createdAt(LocalDateTime.of(2020, 6, 14, 9, 0, 0))
                .updatedAt(LocalDateTime.of(2020, 6, 14, 9, 0, 0))
                .build();
    }

    public static Product productMock() {
        return Product.builder()
                .id(1L)
                .code(35455L)
                .name("anyName")
                .description("anyDescription")
                .unitPrice(new BigDecimal("10"))
                .image("anyImage")
                .provider("AnyProvider")
                .createdAt(LocalDateTime.of(2020, 6, 14, 9, 0, 0))
                .updatedAt(LocalDateTime.of(2020, 6, 14, 9, 0, 0))
                .build();
    }

}

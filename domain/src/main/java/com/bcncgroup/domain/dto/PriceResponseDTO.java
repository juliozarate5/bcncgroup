package com.bcncgroup.domain.dto;

import com.bcncgroup.domain.enums.PriceListEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponseDTO implements Serializable {

    static final long serialVersionUID = 1L;

    @JsonProperty("product_id")
    Long productId;

    @JsonProperty("brand_id")
    Long brandId;

    @JsonProperty("price_list") // tax to applicate
    PriceListEnum priceList;

    @JsonProperty("start_date")
    LocalDateTime startDate;

    @JsonProperty("end_date")
    LocalDateTime endDate;

    @JsonProperty("price")
    BigDecimal total;
}

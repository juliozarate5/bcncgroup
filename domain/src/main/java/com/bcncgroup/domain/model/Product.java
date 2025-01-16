package com.bcncgroup.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
public class Product {

    Long id;

    String name;

    String description;

    BigDecimal unitPrice;

    String image;

    String provider; // can be other table

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}

package com.bcncgroup.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
public class Brand {

    Long id;

    String name;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}

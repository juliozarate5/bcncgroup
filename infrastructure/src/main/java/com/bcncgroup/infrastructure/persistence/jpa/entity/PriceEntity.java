package com.bcncgroup.infrastructure.persistence.jpa.entity;

import com.bcncgroup.domain.enums.CurrencyEnum;
import com.bcncgroup.domain.enums.PriceListEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "prices")
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
public class PriceEntity implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    BrandEntity brand;

    @Column(name = "start_date", nullable = false)
    LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    LocalDateTime endDate;

    @Column(name = "price_list", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    PriceListEnum priceList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    ProductEntity product;

    @Column(nullable = false)
    Integer priority;

    @Column(name = "price", nullable = false)
    BigDecimal total;

    @Column(name = "curr", nullable = false)
    @Enumerated(EnumType.STRING)
    CurrencyEnum currency;

    @Column(name = "created_at", updatable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if(createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

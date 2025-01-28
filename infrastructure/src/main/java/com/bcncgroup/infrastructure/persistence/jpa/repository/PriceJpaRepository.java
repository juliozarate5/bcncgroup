package com.bcncgroup.infrastructure.persistence.jpa.repository;

import com.bcncgroup.infrastructure.persistence.jpa.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceJpaRepository
        extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p " +
            "WHERE :appDate >= p.startDate " +
            "AND :appDate <= p.endDate " +
            "AND p.product.id = :productId " +
            "AND p.brand.id = :brandId " +
            "ORDER BY p.priority DESC " +
            "LIMIT 1")
    Optional<PriceEntity> findByAppDateAndProductIdAndBrandId(
            @Param("appDate") LocalDateTime appDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId
    );
}

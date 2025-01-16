package com.bcncgroup.infrastructure.config;

import com.bcncgroup.domain.repository.PriceRepository;
import com.bcncgroup.application.service.PriceService;
import com.bcncgroup.application.service.impl.DomainPriceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriceConfiguration {

    @Bean
    PriceService priceService(final PriceRepository priceRepository) {
        return new DomainPriceServiceImpl(priceRepository);
    }


 }

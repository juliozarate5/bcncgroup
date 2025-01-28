package com.bcncgroup.application.service.impl;

import com.bcncgroup.application.exceptions.InternalServerErrorException;
import com.bcncgroup.application.exceptions.NotFoundException;
import com.bcncgroup.application.service.PriceService;
import com.bcncgroup.domain.model.Price;
import com.bcncgroup.domain.model.Product;
import com.bcncgroup.domain.repository.PriceRepository;
import com.bcncgroup.domain.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Slf4j
public class DomainPriceServiceImpl implements PriceService {

    private static final String NO_PRICE = "No exists Price";

    private static final String NO_PRODUCT = "No exists product";

private static final String GENERAL_ERROR = "General Error on Price";

    private final PriceRepository priceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public DomainPriceServiceImpl(
            final PriceRepository priceRepository
    ) {
        this.priceRepository = priceRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Price getPrice(
            final LocalDateTime appDate, final Long productId, final Long brandId) {
        try {

            // TODO: VALIDAR & get BRAND

            final Product product = this.getProduct(productId);
            return priceRepository.findPricesByParams(appDate, product.getId(), brandId)
                            .orElseThrow(() -> new NotFoundException(NO_PRICE));
        } catch (InternalServerErrorException e) {
            throw new InternalServerErrorException(GENERAL_ERROR);
        }
    }

    private Product getProduct(final Long code) {
        return productRepository.findProductByCode(code).orElseThrow(
                () -> new NotFoundException(NO_PRODUCT)
        );
    }
}

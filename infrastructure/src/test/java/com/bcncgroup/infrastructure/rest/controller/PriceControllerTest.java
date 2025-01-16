package com.bcncgroup.infrastructure.rest.controller;

import com.bcncgroup.ObjectsMockUtil;
import com.bcncgroup.infrastructure.rest.PriceController;
import com.bcncgroup.application.service.PriceService;
import com.bcncgroup.domain.dto.PriceResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @InjectMocks
    private PriceController priceController;

    @Mock
    private PriceService priceService;

    @DisplayName("Test get prices by params: appDate, productId & brandId successful")
    @Test
    void get_prices_by_params_successful() {
        final LocalDateTime appDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        final Long productId = 35455L;
        final Long brandId = 1L;
        Mockito.when(
                priceService.getPrices(
                                ArgumentMatchers.any(),
                                ArgumentMatchers.anyLong(),
                                ArgumentMatchers.anyLong()
                        )
                ).thenReturn(ObjectsMockUtil.priceResponseDTOListMock());
        final ResponseEntity<List<PriceResponseDTO>> response =
                priceController.getPrices(
                        appDate, productId, brandId
                );
        assertNotNull(response);
        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        final List<PriceResponseDTO> items = response.getBody();
        assertNotNull(items);
        assertTrue(items.size() > 0);
    }

}
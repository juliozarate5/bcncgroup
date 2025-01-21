package com.bcncgroup.infrastructure.rest.controller;

import com.bcncgroup.domain.dto.PriceResponseDTO;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @DisplayName("Test 1 get prices by params: appDate, productId & brandId successful")
    @Test
    void get_prices_shouldGetSuccessful_test_1() {
        // Given
        HttpStatus expected = HttpStatus.OK;

        // When
        ResponseEntity<PriceResponseDTO[]> actual =
                testRestTemplate.getForEntity(
                        "http://localhost:"+port+"/api/v1/prices?application_date=2020-06-14T10:00:00&product_id=35455&brand_id=1",
                        PriceResponseDTO[].class
                );

        // Then
        BDDAssertions.then(actual.getStatusCode()).isEqualTo(expected);
        BDDAssertions.then(actual.getBody()).isNotEmpty();

        BDDAssertions.then(actual.getBody()[0].getProductId()).isEqualTo(35455L);
        BDDAssertions.then(actual.getBody()[0].getBrandId()).isEqualTo(1);
        BDDAssertions.then(actual.getBody()[0].getStartDate()).isEqualTo("2020-06-14T00:00:00");
        BDDAssertions.then(actual.getBody()[0].getEndDate()).isEqualTo( "2020-12-31T23:59:59");
        BDDAssertions.then(actual.getBody()[0].getTotal()).isEqualTo(new BigDecimal("35.50"));
    }

    @DisplayName("Test 2 get prices by params: appDate, productId & brandId successful")
    @Test
    void get_prices_shouldGetSuccessful_test_2() {
        // Given
        HttpStatus expected = HttpStatus.OK;

        // When
        ResponseEntity<PriceResponseDTO[]> actual =
                testRestTemplate.getForEntity(
                        "http://localhost:"+port+"/api/v1/prices?application_date=2020-06-14T16:00:00&product_id=35455&brand_id=1",
                        PriceResponseDTO[].class
                );

        // Then
        BDDAssertions.then(actual.getStatusCode()).isEqualTo(expected);
        BDDAssertions.then(actual.getBody()).isNotEmpty();

        BDDAssertions.then(actual.getBody()[0].getProductId()).isEqualTo(35455L);
        BDDAssertions.then(actual.getBody()[0].getBrandId()).isEqualTo(1);
        BDDAssertions.then(actual.getBody()[0].getStartDate()).isEqualTo("2020-06-14T15:00:00");
        BDDAssertions.then(actual.getBody()[0].getEndDate()).isEqualTo( "2020-06-14T18:30:00");
        BDDAssertions.then(actual.getBody()[0].getTotal()).isEqualTo(BigDecimal.valueOf(25.45));
    }

    @DisplayName("Test 3 get prices by params: appDate, productId & brandId successful")
    @Test
    void get_prices_shouldGetSuccessful_test_3() {
        // Given
        HttpStatus expected = HttpStatus.OK;

        // When
        ResponseEntity<PriceResponseDTO[]> actual =
                testRestTemplate.getForEntity(
                        "http://localhost:"+port+"/api/v1/prices?application_date=2020-06-14T21:00:00&product_id=35455&brand_id=1",
                        PriceResponseDTO[].class
                );

        // Then
        BDDAssertions.then(actual.getStatusCode()).isEqualTo(expected);
        BDDAssertions.then(actual.getBody()).isNotEmpty();

        BDDAssertions.then(actual.getBody()[0].getProductId()).isEqualTo(35455L);
        BDDAssertions.then(actual.getBody()[0].getBrandId()).isEqualTo(1);
        BDDAssertions.then(actual.getBody()[0].getStartDate()).isEqualTo("2020-06-14T00:00:00");
        BDDAssertions.then(actual.getBody()[0].getEndDate()).isEqualTo( "2020-12-31T23:59:59");
        BDDAssertions.then(actual.getBody()[0].getTotal()).isEqualTo(new BigDecimal("35.50"));
    }

    @DisplayName("Test 4 get prices by params: appDate, productId & brandId successful")
    @Test
    void get_prices_shouldGetSuccessful_test_4() {
        // Given
        HttpStatus expected = HttpStatus.OK;

        // When
        ResponseEntity<PriceResponseDTO[]> actual =
                testRestTemplate.getForEntity(
                        "http://localhost:"+port+"/api/v1/prices?application_date=2020-06-15T10:00:00&product_id=35455&brand_id=1",
                        PriceResponseDTO[].class
                );

        // Then
        BDDAssertions.then(actual.getStatusCode()).isEqualTo(expected);
        BDDAssertions.then(actual.getBody()).isNotEmpty();

        BDDAssertions.then(actual.getBody()[0].getProductId()).isEqualTo(35455L);
        BDDAssertions.then(actual.getBody()[0].getBrandId()).isEqualTo(1);
        BDDAssertions.then(actual.getBody()[0].getStartDate()).isEqualTo("2020-06-15T00:00:00");
        BDDAssertions.then(actual.getBody()[0].getEndDate()).isEqualTo( "2020-06-15T11:00:00");
        BDDAssertions.then(actual.getBody()[0].getTotal()).isEqualTo(new BigDecimal("30.50"));
    }

    @DisplayName("Test 5 get prices by params: appDate, productId & brandId successful")
    @Test
    void get_prices_shouldGetSuccessful_test_5() {
        // Given
        HttpStatus expected = HttpStatus.OK;

        // When
        ResponseEntity<PriceResponseDTO[]> actual =
                testRestTemplate.getForEntity(
                        "http://localhost:"+port+"/api/v1/prices?application_date=2020-06-16T21:00:00&product_id=35455&brand_id=1",
                        PriceResponseDTO[].class
                );

        // Then

        BDDAssertions.then(actual.getStatusCode()).isEqualTo(expected);
        BDDAssertions.then(actual.getBody()).isNotEmpty();

        BDDAssertions.then(actual.getBody()[0].getProductId()).isEqualTo(35455L);
        BDDAssertions.then(actual.getBody()[0].getBrandId()).isEqualTo(1);
        BDDAssertions.then(actual.getBody()[0].getStartDate()).isEqualTo("2020-06-15T16:00:00");
        BDDAssertions.then(actual.getBody()[0].getEndDate()).isEqualTo( "2020-12-31T23:59:59");
        BDDAssertions.then(actual.getBody()[0].getTotal()).isEqualTo(BigDecimal.valueOf(39.95));

        //...
    }
}
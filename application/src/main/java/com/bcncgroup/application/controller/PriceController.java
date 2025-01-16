package com.bcncgroup.application.controller;

import com.bcncgroup.domain.service.PriceService;
import com.bcncgroup.domain.dto.PriceResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Endpoints Prices Controller", description = "Prices Controller")
@RestController
@RequestMapping("/prices")
@Slf4j
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(final PriceService priceService) {
        this.priceService = priceService;
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "500", description = "Internal Error Server"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @Operation(
            summary = "Get Prices by params",
            description = "Get Prices by Application Date, Product ID & Brand ID"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<PriceResponseDTO>> getPrices(
            @RequestParam("application_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime appDate,
            @RequestParam("product_id") Long productId,
            @RequestParam("brand_id") Long brandId
    ) {
        log.info("Executing getPrices from Controller");
        return ResponseEntity.ok(
                priceService.getPrices(appDate, productId, brandId)
        );
    }
}

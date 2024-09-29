package com.bootcamp.pragma.transactionmicroservice.infrastructure.driving.http.controllers;

import com.bootcamp.pragma.transactionmicroservice.application.dto.request.AddStockArticleRequest;
import com.bootcamp.pragma.transactionmicroservice.application.handler.SupplyHandler;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driving.http.util.SwaggerConstants;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class SupplyController {

    private final SupplyHandler supplyHandler;

    @PostMapping("/stock")
    @ApiResponses(value = {
            @ApiResponse(responseCode = SwaggerConstants.OK_STATUS_CODE , description = SwaggerConstants.STOCK_ADDED_SUCCESSFULLY),
            @ApiResponse(responseCode = SwaggerConstants.BAD_REQUEST_STATUS_CODE, description = SwaggerConstants.BAD_REQUEST_MSG),
    })
    public ResponseEntity<Void> supplyStock(@Valid @RequestBody AddStockArticleRequest request) {
        supplyHandler.saveSupply(request);
        return ResponseEntity.ok().build();
    }
}

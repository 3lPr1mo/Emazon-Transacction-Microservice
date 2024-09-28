package com.bootcamp.pragma.transactionmicroservice.infrastructure.driving.http.controllers;

import com.bootcamp.pragma.transactionmicroservice.application.dto.request.AddStockArticleRequest;
import com.bootcamp.pragma.transactionmicroservice.application.handler.SupplyHandler;
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
    public ResponseEntity<Void> supplyStock(@Valid @RequestBody AddStockArticleRequest request) {
        supplyHandler.saveSupply(request);
        return ResponseEntity.ok().build();
    }
}

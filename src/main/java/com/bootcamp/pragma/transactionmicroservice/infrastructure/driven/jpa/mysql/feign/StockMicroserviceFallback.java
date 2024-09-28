package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.feign;

import com.bootcamp.pragma.transactionmicroservice.application.dto.response.StockResponse;
import com.bootcamp.pragma.transactionmicroservice.domain.model.StockArticle;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StockMicroserviceFallback implements IStockServiceFeign {
    @Override
    public ResponseEntity<StockResponse> updateStock(StockArticle request) {
        return ResponseEntity.ok().body(new StockResponse(false));
    }
}
